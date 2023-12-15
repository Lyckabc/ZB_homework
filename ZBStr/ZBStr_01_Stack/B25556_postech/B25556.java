package baekjoon;
//import java.io.*;
import java.util.*;

public class B25556 {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            Solution sol = new Solution();
            int N;

            N = input.nextInt();
            int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = input.nextInt();
            }

            if (N != 0 && sol.PostechClean(A)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Solution {
    public boolean PostechClean(int[] A) {
        Stack<Integer> S1 = new Stack<>();
        Stack<Integer> S2 = new Stack<>();
        Stack<Integer> S3 = new Stack<>();
        Stack<Integer> S4 = new Stack<>();
//        Stack<Integer>[] stacks = new Stack<>[4];
//
//        for (int i = 0; i < 4; i++) {
//            stacks[i] = new Stack<>();
//        }

        for (int i = 0; i < A.length; i++) {
            if (S1.isEmpty() || A[i] > S1.peek()) {
                S1.push(A[i]);
            } else if (S2.isEmpty() || A[i] > S2.peek()) {
                S2.push(A[i]);
            } else if (S3.isEmpty() || A[i] > S3.peek()) {
                S3.push(A[i]);
            } else if (S4.isEmpty() || A[i] > S4.peek()) {
                S4.push(A[i]);
            } else {
                return false;
            }
        }
        return true;
    }
}