package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 부품 찾기
 * 197p
 */
public class BinarySearch1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] marketList = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int M = Integer.parseInt(br.readLine());
        int[] requestList = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(marketList);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int target = requestList[i];
            sb.append(binarySearch(marketList, target, 0, N - 1)).append(" ");
        }

        System.out.print(sb.toString());
    }

    private static String binarySearch(int[] arr, int target, int start, int end) {

        if (start > end) {
            return "no";
        }

        int mid = (start + end) / 2;

        if (arr[mid] == target) {
            return "yes";
        }

        if (arr[mid] > target) {
            return binarySearch(arr, target, start, mid - 1);
        } else {
            return binarySearch(arr, target, mid + 1, end);
        }
    }
}
