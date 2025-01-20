package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 개미 전사
 * 220p
 */
public class DynamicP2_Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] food = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[100];

        dp[0] = food[0];
        dp[1] = Math.max(food[0], food[1]);

        for (int i = 2; i < N; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + food[i]);
        }

        System.out.print(dp[N - 1]);
    }
}

// 직전의 값을 가져오면 현재 food 창고를 털 수 없다.
// 그러나 1칸을 건너뛰면 현재 food 창고를 털 수 있다.
// 이 두 가지 조합 중 큰 값을 dp에 저장한다면 마지막엔 가장 큰 값을 구할 수 있다.

