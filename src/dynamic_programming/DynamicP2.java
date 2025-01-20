package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 개미 전사
 * 220p
 */
public class DynamicP2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] food = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int size = food.length;
        int[] dp = new int[size];

        dp[0] = food[0];
        dp[1] = food[1];

        for (int i = 2; i < size; i++) {
            dp[i] = food[i] + dp[i - 2];
        }

        System.out.print(Math.max(dp[N - 2], dp[N - 1]));
    }
}

