package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1로 만들기
 * 217p
 */
public class DynamicP1_Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int size = 30001;
        int[] dp = new int[size];

        for (int i = 2; i < size; i++) {
            // 현재의 수에서 1을 빼는 경우
            dp[i] = dp[i - 1] + 1;
            // 현재의 수가 2로 나누어 떨어지는 경우
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            // 현재의 수가 3으로 나누어 떨어지는 경우
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
            // 현재의 수가 5로 나누어 떨어지는 경우
            if (i % 5 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 5] + 1);
            }
        }

        System.out.print(dp[X]);
    }
}

// 문제 풀이 방법이다. 마찬가지로 바텀업 방식을 사용한다. 즉, 반복문을 사용한다는 뜻.
