package P42586;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P42586 {
    public static void main(String[] args) {
        // 예시 입력
        Solution sol = new Solution();
        int[] progresses1 = {93, 30, 55};
        int[] speeds1 = {1, 30, 5};
        int[] result1 = sol.solution(progresses1, speeds1);
        System.out.println(Arrays.toString(result1));  // 출력: [2, 1]

        int[] progresses2 = {95, 90, 99, 99, 80, 99};
        int[] speeds2 = {1, 1, 1, 1, 1, 1};
        int[] result2 = sol.solution(progresses2, speeds2);
        System.out.println(Arrays.toString(result2));  // 출력: [1, 3, 2]
    }
}

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answerList = new ArrayList<>();
        int idx = 0;

        while (idx < progresses.length) {
            int deployDay = (int) Math.ceil((100.0 - progresses[idx]) / speeds[idx]);
            int deployCount = 1;

            while (++idx < progresses.length && progresses[idx] + speeds[idx] * deployDay >= 100) {
                deployCount++;
            }

            answerList.add(deployCount);
        }

        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}