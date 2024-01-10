/******************************************************
 **                                                  **
 **        99_ZBTest                                 **
 **        M1_findcoordi                    **
 **        Made by Toji                              **
 **        1/11/2024  2:15 AM                       **
 **        https://github.com/lyckabc                **
 **                                                  **
 ******************************************************/
package M1_findcoordi;

import java.util.*;
import java.io.*;

public class M1_findcoordi {
    public static void main(String[] args) {
        Solution sol = new Solution();
        Random rand = new Random();
        int ranlen = rand.nextInt(9) + 2;
        int[][] coordiinsert = new int[ranlen][2];

        for (int i = 0; i < ranlen; i++) {
            coordiinsert[i][0] = rand.nextInt(101);
            coordiinsert[i][1] = rand.nextInt(101);
        }
        for (int i = 0; i < ranlen; i++) {
            System.out.print("(" + coordiinsert[i][0] + ", " + coordiinsert[i][1] + ")");
            if (!(i == ranlen-1)) {
                System.out.print(", ");
            }
        }
        System.out.println();
        int[] result = sol.solution(coordiinsert);
        System.out.println("나와 가장 가까운 좌표값은 (" + result[0] + ", " + result[1] + ") 입니다.");
    }
}
class Solution {
    public int[] solution(int[][] insert) {
        int minSum = Integer.MAX_VALUE;
        int curSum = 0;
        int[] minArr = {1, 1};
        for (int i = 0; i < insert.length; i++) {
            int x = insert[i][0];
            int y = insert[i][1];
            curSum = Math.abs((1 - x) + (1 - y));
            if (curSum < minSum) {
                minSum = curSum;
                minArr[0] = x;
                minArr[1] = y;
            }
        }
        return minArr;
    }
}
