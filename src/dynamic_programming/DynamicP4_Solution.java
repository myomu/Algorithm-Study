package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 효율적인 화폐 구성
 * 226p
 */
public class DynamicP4_Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] cash = new int[N];
        int[] dp = new int[10001];
        Arrays.fill(dp, 10001);

        for (int i = 0; i < N; i++) {
            cash[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(cash);

        dp[0] = 0;
        for (int i = 0; i < N; i++) {
            for (int j = cash[i]; j < M + 1; j++) {
                if (dp[j - cash[i]] != 10001) {
                    dp[j] = Math.min(dp[j], dp[j - cash[i]] + 1);
                }
            }
        }

        if (dp[M] == 10001) {
            System.out.print(-1);
        } else {
            System.out.print(dp[M]);
        }
    }
}

