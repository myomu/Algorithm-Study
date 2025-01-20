package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 바닥 공사
 * 223p
 */
public class DynamicP3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i < N + 1; i++) {
            dp[i] = dp[i - 2] * 2 + dp[i - 1];
        }

        System.out.print(dp[N]);
    }
}

/*
dp[1] = 1;
dp[2] = 3;
dp[3] = 5;
dp[4] = 11;
예를 들어 N = 5 라고 한다면 N = 4 인 경우의 수에서 1칸 늘어난 것이고,
N = 3 인 경우의 수에서 2칸 늘어난 것으로 볼 수 있다.
조건에서 덮개가 가로가 1 인 것도 있고 2 인 것도 있어서 1칸 늘어난 경우와 2칸 늘어난 경우를 생각하면 될 것 같았다.
2칸 늘어난 경우는 이전의 2배를 1칸 늘어난 경우는 이전의 1배를,
=> 최종적으로 dp[N - 2] * 2 + dp[N - 1] 이라는 공식을 도출해보았다.
*/

