package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1로 만들기
 * 217p
 */
public class DynamicP1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int size = 30001;
        int[] dp = new int[size * 5];

        for (int i = 1; i < size; i++) {
            int a = i * 5;
            int b = i * 3;
            int c = i * 2;
            int d = i + 1;
            int count = dp[i] + 1;

            if (dp[a] == 0 || dp[a] > count) {
                dp[a] = count;
            }
            if (dp[b] == 0 || dp[b] > count) {
                dp[b] = count;
            }
            if (dp[c] == 0 || dp[c] > count) {
                dp[c] = count;
            }
            if (dp[d] == 0 || dp[d] > count) {
                dp[d] = count;
            }
        }

        System.out.print(dp[X]);
    }
}

// 바텀업 방식으로 풀려고 했다. dp 테이블을 이용해서 아래에서 부터 올라가며 만약 값이 0 이거나 count 보다 작을 때,
// 값을 넣어주는 방식으로 진행했다.
