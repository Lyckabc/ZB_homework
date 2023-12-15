package P12910;

import java.io.*;
import java.util.*;

public class P12910 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {3,2,6};
        int divisor = 10;

        int[] result = sol.solution(arr, divisor);

        // 결과 출력
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}

class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> cleanarr = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                cleanarr.add(arr[i]);
            }
        }
        if (cleanarr.isEmpty()) {
            cleanarr.add(-1);
        }
        int[] answer = new int[cleanarr.size()];
        Collections.sort(cleanarr);
        for (int i = 0; i < cleanarr.size(); i++) {
            answer[i] = cleanarr.get(i);
        }
        return answer;
    }
}