package B26008;

import java.io.*;
import java.util.*;

public class B26008{
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        Solution sol = new Solution();

        // 입력값 받기
//        int N = scanner.nextInt();
//        int M = scanner.nextInt();
//        int A = scanner.nextInt();
//        int H = scanner.nextInt();
//        int N1 = 3, M1 = 2, A1 = 1, H1 = 1;
//        long result1 = sol.HashHacking(N1, M1, A1, H1);
//        System.out.println(result1);

        int N2 = 5000000, M2 = 5000000, A2 = 5000000, H2 = 1;
        long result2 = sol.HashHacking(N2, M2, A2, H2);
        System.out.println(result2);
    }
}

class Solution {
    public static long HashHacking(int N, int M, int A, int H) {

        // 거듭제곱을 계산하는 함수
        long answer = 1L;
        System.out.println("answer : " + answer);
        for (int i = 0; i < N-1; i++) {
            answer = (answer * M) % 1_000_000_007;
            System.out.println("answer : " + answer);
        }
        System.out.println("answer : " + answer);

        // 비밀번호 개수 계산
//        for (int i = 0; i < N; i++) {
//            result = (result * M) % 1_000_000_007;
//        }

        // 해시값을 만족하는 비밀번호 개수 계산
//        result = (result + (H * pow) % 1_000_000_007) % 1_000_000_007;

        return answer;
    }
}