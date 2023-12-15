/*
제로베이스 백엔드 20기 신동호
미니과제06 - 가상 선거 및 당선 프로그램
 */
import java.util.*;
//import java.io.*;

public class ZBMini06 {
    public static void main(String[] args) {
        System.out.println("[가상 선거 및 당선 프로그램]");
        int countvoter;
        int countelector;
        int electornum = 0;

        Scanner input = new Scanner(System.in);
        System.out.print("총 진행할 투표수를 입력해 주세요.");
        countvoter = input.nextInt();
        System.out.print("가상 선거를 진행할 후보자 인원을 입력해 주세요.");
        countelector = input.nextInt();
        String[] elector = new String[countelector];

        for (String inputname:elector) {
            electornum++;
            System.out.printf("%d번째 후보자이름을 입력해 주세요.", electornum);
            elector[electornum-1] = input.next();
        }
        voteprogress(countvoter, elector);

    }
    private static void voteprogress(int countvoter, String[] elector) {
        float progressper = 0;
        int randomnum ;
        int electornum ;
        int a ;
        float countper ;
        int[] countelectornum = new int[elector.length];
        String randomvote ;
        Random rand = new Random();

        for (int countnum = 1; countnum <= countvoter; countnum++) {
            progressper = ((float)countnum / countvoter) * 100;
            randomnum = rand.nextInt(elector.length);
            countelectornum[randomnum]++;
            a = countelectornum[randomnum];
            randomvote = elector[randomnum];
            /*
             System.out.printf("countvoter : %d %n", countvoter);
            System.out.printf("countnum : %d %n", countnum);
            System.out.printf("randomnum : %d %n", randomnum);
            System.out.printf("progressper : %.2f %n", progressper);
            System.out.printf("a: %d %n", a);
             */
            System.out.printf("[투표진행률]: %.2f%%, %d명 투표 => %s", progressper, countnum, randomvote);
            System.out.println();
            electornum = 0;
            for (String inputname:elector) {
                countper = ((float) countelectornum[electornum]/countnum) * 100;
                System.out.printf("[기호:%d] %-6s: %.2f%%  (투표수: %d)", electornum + 1, elector[electornum], countper, countelectornum[electornum]);
                System.out.println();
                electornum++;
            }
        }
        int maxvoter = Integer.MIN_VALUE;
        for (int num : countelectornum) {
            if (num > maxvoter) {
              maxvoter = num;
            }
        }
        int winnernum = Arrays.asList(countelectornum).indexOf(maxvoter);
        String winner = elector[winnernum];

        System.out.println();
        System.out.printf("[투표결과] 당선인 : %s", winner);
    }
}