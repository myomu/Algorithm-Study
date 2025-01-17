package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/**
 * 떡볶이 떡 만들기
 * 201p
 */
public class BinarySearch2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[] riceCakeLength = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(riceCakeLength);
        int start = 0;
        int end = riceCakeLength[riceCakeLength.length - 1];
        int result = 0;

        while (start <= end) {

            int mid = (start + end) / 2;
            int sliceLength = 0;
            for (int i = 0; i < N; i++) {
                if (riceCakeLength[i] > mid) {
                    sliceLength += riceCakeLength[i] - mid;
                }
            }

            if (sliceLength >= M) {
                result = mid; // 최대한 덜 잘랐을 때가 정답이므로, 여기에서 result에 기록한다.
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.print(result);
    }
}
