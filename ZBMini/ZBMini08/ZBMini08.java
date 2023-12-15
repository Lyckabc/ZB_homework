/*
제로베이스 백엔드 20기 신동호
미니과제08 - 과세금액 계산 프로그램
 */
import java.util.*;


public class ZBMini08 {
    public static void main(String[] args) {
        System.out.println("[과세금액 계산 프로그램]");
        Scanner input = new Scanner(System.in);
        int mysalary ;
        System.out.print("연소득을 입력해 주세요.:");
        mysalary = input.nextInt();

        int[][] taxtable = maketable() ;

        taxprint(taxtable, mysalary);

    }

    private static int[][] maketable() {
        int unit1 = 10000; // 만원단위
        int unit2 = 1000000; //  백만원 단위

        int[][] taxtable = {
                {12*unit2, 46*unit2,88*unit2,150*unit2,300*unit2,500*unit2,1000*unit2},
                {6,15,24,35,38,40,42,45},
                {0,108*unit1,522*unit1,1490*unit1,1940*unit1,2540*unit1,3540*unit1,6540*unit1}
        };
        return taxtable;
    }

    private static void taxprint(int[][] taxtable, int mysalary) {
        int taxbyrate = 0;
        int taxbyprogdeduction;
        int levoftax = 0;

        for (int i = 0; i < taxtable[0].length; i++) {
            if (mysalary <= taxtable[0][i]) {
                break;
            }
            levoftax++;
        }

        taxbyrate = formulabyrate(taxtable, mysalary, levoftax);
        taxbyprogdeduction = formulabyprogdeduction(taxtable, mysalary, levoftax);

        System.out.printf("[세율에 의한 세금]:%19s%n", taxbyrate);
        System.out.printf("[누진공제 계산에 의한 세금]:%12s%n", taxbyprogdeduction);
    }

    private static int formulabyrate(int[][] taxtable, int mysalary, int levoftax) {
        int taxbyrate = 0;
        int tax ;
        int rate;
        int averagetax = 0 ;

        for (int i = 0; i <= levoftax; i++) {
            rate = taxtable[1][i];

            if (levoftax == 0) {
                tax = (mysalary / 100) * rate;
                System.out.printf("%10d * %2d%% = %15d%n", mysalary, rate, tax );
            } else if (levoftax > 0 && (i == 0)) {
                averagetax = taxtable[0][i];
                tax = (averagetax / 100) * rate;
                System.out.printf("%10d * %2d%% = %15d%n", averagetax, rate, tax );
            } else if (levoftax == i) {
                tax = ((mysalary - averagetax) / 100) * rate;
                System.out.printf("%10d * %2d%% = %15d%n", mysalary - averagetax, rate, tax );
            } else {
                tax = ((taxtable[0][i] - averagetax) / 100) * rate;
                System.out.printf("%10d * %2d%% = %15d%n", taxtable[0][i] - averagetax, rate, tax );
            }
            averagetax= taxtable[0][i];
            taxbyrate += tax ;
        }
        System.out.println();

        return taxbyrate;
    }

    private static int formulabyprogdeduction(int[][] taxtable, int mysalary, int levoftax) {
        int rate = taxtable[1][levoftax];
        int deductiontax = taxtable[2][levoftax];

        return (mysalary / 100) * rate - deductiontax;
    }
}