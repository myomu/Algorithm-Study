package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 두 배열의 원소 교체
 * 182p
 */
public class Sort3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int[] arr1 = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        Integer[] arr2 = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt).toArray(Integer[]::new);

        Arrays.sort(arr1);
        Arrays.sort(arr2, Collections.reverseOrder());

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

        for (int i = 0; i < K; i++) {
            if (arr1[i] < arr2[i]) {
                swap(arr1, arr2, i);
            }
        }

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

        System.out.println(Arrays.stream(arr1).sum());
    }

    private static void swap(int[] arr1, Integer[] arr2, int i) {
        int temp = arr1[i];
        arr1[i] = arr2[i];
        arr2[i] = temp;
    }
}
