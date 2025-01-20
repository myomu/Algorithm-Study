package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 바닥 공사
 * 223p
 */
public class DynamicP3_Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];

        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i < N + 1; i++) {
            dp[i] = (dp[i - 2] * 2 + dp[i - 1]) % 796796; // 나누는 부분 빠짐
        }

        System.out.print(dp[N]);
    }
}

// 해설을 보면 n - 1 일때, 는 2x1 덮개를 채우는 경우가 1개
// n - 2 일때, 는 1x2 덮개를 2개 사용하는 경우와 2x2 덮개를 1개 사용하는 경우가 있으면 총 2개의 경우가 존재한다.
// 그러므로 => dp[i] = dp[i - 1] + 2 * dp[i - 2] 라는 식이 생기게 된다.
// 왼쪽부터 덮개를 채워갈때 n - 2 이전의 타일은 이미 덮개로 채워져 있다고 가정한다.

