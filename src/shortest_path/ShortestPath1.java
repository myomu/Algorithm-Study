package shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 미래 도시
 * 259p
 */
public class ShortestPath1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int INF = Integer.MAX_VALUE;

        String[] input1 = br.readLine().split(" ");
        int N = Integer.parseInt(input1[0]);
        int M = Integer.parseInt(input1[1]);

        long[][] graph = new long[N + 1][N + 1];

        for (int i = 0; i < N + 1; i++) {
            Arrays.fill(graph[i], INF);
        }

        for (int i = 0; i < N + 1; i++) {
            graph[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            graph[start][end] = 1;
            graph[end][start] = 1; // 양방향으로 연결됨으로 반대 상황도 1로 설정해준다.
        }

        String[] input2 = br.readLine().split(" ");
        int X = Integer.parseInt(input2[0]);
        int K = Integer.parseInt(input2[1]);

        for (int k = 1; k < N + 1; k++) {
            for (int a = 1; a < N + 1; a++) {
                for (int b = 1; b < N + 1; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        long distance = graph[1][K] + graph[K][X];
        if (distance >= INF) {
            System.out.print(-1);
        } else {
            System.out.print(distance);
        }
    }
}

// 플로이드 워셜 알고리즘 문제이다.
// N 의 범위가 100 으로 적고 쉽게 구현이 가능한 플로이드 위셜을 사용하는 것이 좋기 때문이다.
// 다익스트라는 출발지가 고정되어 있으므로 1 -> K, K -> X 로 계산을 두 번 해야할 것이다.
