package B26008;

import java.io.*;
import java.util.*;

public class B26008{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution sol = new Solution();

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int A = scanner.nextInt();
        int H = scanner.nextInt();
        long output = sol.HashHacking(N, M);
      System.out.println(output);

    }
}

class Solution {
    public static long HashHacking(int N, int M) {
        long result = 1L;
        for (int i = 0; i < N-1; i++) {
            result = (result * M) % 1_000_000_007;
        }
        return result;
    }
}