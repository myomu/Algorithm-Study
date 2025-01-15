package sort;

public class QuickSortBasic {

    public static void main(String[] args) {
        int[] array = {10, 7, 8, 9, 1, 5}; // 정렬할 배열
        System.out.println("정렬 전 배열:");
        printArray(array);

        quickSort(array, 0, array.length - 1); // 퀵 정렬 실행

        System.out.println("\n정렬 후 배열:");
        printArray(array);
    }

    // 1. 퀵 정렬 메서드
    public static void quickSort(int[] arr, int low, int high) {
        // 배열이 두 개 이상의 요소로 구성되어 있으면 정렬을 진행
        if (low < high) {
            // 2. 분할(Partition): 피벗 위치를 기준으로 배열을 나눔
            int pi = partition(arr, low, high);

            // 3. 분할된 두 부분 배열을 각각 재귀적으로 정렬
            quickSort(arr, low, pi - 1); // 피벗 왼쪽 부분
            quickSort(arr, pi + 1, high); // 피벗 오른쪽 부분
        }
    }

    // 2. 분할(Partition) 메서드
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // 피벗을 배열의 마지막 요소로 선택
        int i = low - 1; // 작은 요소를 추적하는 인덱스

        for (int j = low; j < high; j++) { // 배열의 처음부터 끝까지 순회
            // 현재 요소가 피벗보다 작거나 같으면 교환
            if (arr[j] <= pivot) {
                i++; // 작은 요소 위치 증가
                swap(arr, i, j); // 작은 요소와 현재 요소 교환
            }
        }

        // 마지막으로 피벗을 올바른 위치로 이동
        swap(arr, i + 1, high);

        return i + 1; // 피벗의 최종 위치 반환
    }

    // 3. 배열 요소 교환 메서드
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 4. 배열 출력 메서드
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }


}
