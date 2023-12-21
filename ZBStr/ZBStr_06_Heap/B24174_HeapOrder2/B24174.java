package B24174;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B24174 {
    static StringBuilder result = new StringBuilder() ;
    static int k ;
    static int count = 0;
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());

        k = Integer.parseInt(st.nextToken());

        StringTokenizer Str = new StringTokenizer(br.readLine());
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(Str.nextToken());
        }
        // 힙 정렬 수행
        heapSort(arr);
    }

    // 힙 정렬 메서드
    public static void heapSort(int[] arr) {
        // 힙 생성
        buildHeap(arr);


        // 힙에서 원소를 하나씩 꺼내면서 정렬
        for (int i = arr.length - 1; i >= 1; i--) {
            // 루트와 가장 마지막 원소를 교환
            swap(arr, 0, i);

            // 루트가 힙 성질을 만족하도록 재정렬
            heapify(arr, 0, i - 1);
        }
        if (flag) {
            System.out.println(result);
        } else {
            System.out.println("-1");
        }
    }

    // 힙 생성 메서드
    public static void buildHeap(int[] arr) {
        for (int i = arr.length / 2; i >= 0; i--) {
            heapify(arr, i, arr.length - 1);
        }
    }

    // 힙 성질을 만족하도록 재정렬하는 메서드
    public static void heapify(int[] arr, int i, int n) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int smaller;

        if (left <= n && arr[left] < arr[i]) {
            smaller = left;
        } else {
            smaller = i;
        }

        if (right <= n && arr[right] < arr[smaller]) {
            smaller = right;
        }

        if (smaller != i) {
            swap(arr, i, smaller);

            heapify(arr, smaller, n);

        }
    }
    private static void swap(int[] arr, int i, int j) {
        count++;
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        if (count == k) {
            flag = true;
            appendarr(arr);
        }
    }
    private static void printarr(int[] arr, int count) {
        System.out.println("swap " + count + "번째 : ");
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }
        System.out.println();
    }
    private static void appendarr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            result.append(arr[i] + " ");
        }
    }
}