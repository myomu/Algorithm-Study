package DFSandBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DFSandBFS_1 {

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        int[][] graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            graph[i] = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt).toArray();
        }

        //System.out.println(Arrays.deepToString(graph));

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 0) {
                    count += dfs(graph, i, j, 0);
                }
            }
        }

        System.out.println(count);
    }

    private static int dfs(int[][] graph, int n, int m, int depth) {
//        if (graph[n][m] == 1) {
//            return;
//        }

        graph[n][m] = 1;

        // 상
        if (n - 1 >= 0 && graph[n - 1][m] == 0) {
            dfs(graph, n - 1, m, depth + 1);
        }
        // 하
        if (n + 1 < N && graph[n + 1][m] == 0) {
            dfs(graph, n + 1, m, depth + 1);
        }
        // 좌
        if (m - 1 >= 0 && graph[n][m - 1] == 0) {
            dfs(graph, n, m - 1, depth + 1);
        }
        // 우
        if (m + 1 < M && graph[n][m + 1] == 0) {
            dfs(graph, n, m + 1, depth + 1);
        }

        if (depth == 0) {
            return 1;
        } else {
            return 0;
        }
    }

}

// 인접한 0번들을 묶어서 1개로 카운트 하는 방식.
// 더이상 연결된 0번이 없으면 1개를 카운트 하고 다음으로 넘어가야함.
// 행과 열로 표시되어 있으므로 1행1열 부터 시작해서 차례대로 탐색하면 될 것 같음.
// 이어진 0번들은 1로 표시롤 변경하면 방문했다고 표시가 될 것이다.
// 결국 보튼 행열을 탐색하며 0번을 1번으로 바꾸고, 인접한 0번을 1번으로 바꾸는 과정을
// dfs 로 수행하면서 이 dfs 함수가 한번 실행될 때 마다 1번 count 를 해주면 될 것 같다.

// 조금 더 개선사항이 있다고 한다면 나는 상하좌우에 범위를 벗어나지 않도록 조건을 주었지만
// dfs 함수 최상단에 이 조건을 주어 자동으로 False 가 되도록 하면 될 것 같다.
// 그리고 return 값이 int 가 아닌 boolean 형으로 하여 count 를 체크하는 것도 좋아보인다.
