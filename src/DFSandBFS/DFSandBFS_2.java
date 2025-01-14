package DFSandBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Map;

public class DFSandBFS_2 {

    static int N;
    static int M;
    static int[][] graph;
    static int[] dx;
    static int[] dy;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            graph[i] = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt).toArray();
        }

        dx = new int[]{-1, 1, 0, 0};
        dy = new int[]{0, 0, -1, 1};

        System.out.println(bfs(0, 0));
        System.out.println(Arrays.deepToString(graph));
    }

    private static int bfs(int n, int m) {

        Deque<Pair<Integer, Integer>> deque = new ArrayDeque<>();
        deque.offer(new Pair<>(n, m));

        while (!deque.isEmpty()) {
            Pair<Integer, Integer> pair = deque.poll();
            int x = pair.getFirst();
            int y = pair.getSecond();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }

                if (graph[nx][ny] == 0) {
                    continue;
                }

                if (graph[nx][ny] == 1) {
                    graph[nx][ny] = graph[x][y] + 1;
                    deque.offer(new Pair<>(nx, ny));
                }
            }
        }
        return graph[N - 1][M - 1];
    }

    static class Pair<K, V> {
        K first;
        V second;

        public Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }

        public K getFirst() {
            return first;
        }

        public V getSecond() {
            return second;
        }
    }

}

// dfs 가 아닌 bfs 로 풀라고 한다. bfs 는 큐 형태를 사용하는데 시작 지점에서 주위의 노드를 모두 탐색한다.
// (1, 1) 부터 (N, M) 까지 모두를 돌며 0이 아닌 수라면 상하 좌우에 값을 보고 0 이 아니면 현재 위치의 값에
// 1을 더하여 준다고 해보자.

// 답을 보고 풀었다. (1, 1) 부터 시작을 하게 되는데 이 값을 deque 에 넣어준다.
// java 는 python 의 튜플 같은 자료구조가 없기 때문에 Pair 라는 스태틱 클래스를 만들어 주었다.
// static 메서드에서는 static 만 사용 가능하기 때문일까 에러가 떳었는데 static 을 추가하여 해결해줬다.
// 이후 dx, dy 배열을 이용해 상하좌우 의 좌표값을 dx, dy 라는 변수에 담고 이것이 범위를 벗어나는지
// 값이 0 인지 체크를 한다음 이 값이 1인 경우에만 현재 좌표의 값에 1을 더하고 이것을 Pair 객체에 담아
// deque 에 넣어준다. 이것을 반복하면 현재 위치에서 가장 가까운 노드들 중에 조건을 만족하는 것을
// deque 에 넣고 이것을 다시 빼기를 반복하면 가장 최종적으로 도착점인 (N - 1, M - 1) 의 값을 출력하면 된다.