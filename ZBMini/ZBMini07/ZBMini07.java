/*
제로베이스 백엔드 20기 신동호
미니과제07 - 로또 당첨 프로그램
 */
import java.util.*;

public class ZBMini07 {
    public static void main(String[] args) {
        System.out.println("[로또 당첨 프로그램]");
        System.out.println();
        System.out.print("로또 개수를 입력해 주세요.(숫자 1~10):");

        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        int buylottototal;
        int howmany = 6;
        while (true) {
            buylottototal = input.nextInt();
            input.nextLine();
            if (!(buylottototal >= 1 && buylottototal <= 10)) {
                System.out.print("1~10숫자로 다시 입력해주세요.");
            }else {
                int[][] mylottonum = mylottoprint(buylottototal, rand);

                System.out.println("[로또 발표]");
                int[] lottonum = lottonumprint(howmany, rand);

                System.out.println("[내 로또 결과]");

                lottomatching(mylottonum, lottonum, howmany);
                break;
            }
        }
    }

    private static int[][] mylottoprint(int buylottototal, Random rand) {
        int howmany = 6;
        int[][] mylottonum = new int[buylottototal][howmany];

        for (int i = 0; i < buylottototal; i++) {
            char asciichar = (char) (65 + i);
            System.out.printf("%c\t", asciichar);
            mylottonum[i] = makerandom(howmany,rand);
            for (int j = 0; j < howmany; j++) {
                System.out.printf("%d", mylottonum[i][j]);
                if (j != howmany - 1) {
                    System.out.print(",");
                }
            }
            System.out.println();
        }
        System.out.println();
        return mylottonum;
    }

    private static int[] lottonumprint(int howmany, Random rand) {
        int[] lottonum = new int[howmany];
        System.out.print("  \t");
        lottonum = makerandom(howmany, rand);
        for (int i = 0; i < howmany; i++) {
            System.out.printf("%d", lottonum[i]);
            if (i != howmany - 1) {
                System.out.print(",");
            }
        }
        System.out.println();
        return lottonum;
    }

    private static int[] makerandom(int howmany, Random rand) {
        int[] lottonum = new int[howmany];
        for (int i = 0; i < howmany; i++) {
            lottonum[i] = rand.nextInt(45) + 1;
            for (int j = 0; j < i; j++) {
                if (lottonum[i] == lottonum[j]) {
                    i--;
                }
            }
        }
        lottonum = sortlotto(lottonum);

        return lottonum;
    }

    private static int[] sortlotto(int[] lottonum) {
        for (int i = 0; i < lottonum.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < lottonum.length; j++) {
                if (lottonum[j] < lottonum[minIdx]) {
                    minIdx = j;
                }
            }
            swap(lottonum,i, minIdx);
        }
        return lottonum;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    private static void lottomatching(int[][] mylottonum, int[] lottonum, int howmany) {
        for (int i = 0; i < mylottonum.length; i++) {
            char asciichar = (char) (65 + i);
            System.out.printf("%c\t", asciichar);
            int turnlifenum = 0;
            for (int j = 0; j < howmany; j++) {
                System.out.printf("%d", mylottonum[i][j]);
                if (j != howmany - 1) {
                    System.out.print(",");
                }
                for (int k = 0; k < lottonum.length; k++) {
                    if (mylottonum[i][j] == (lottonum[k])) {
                        turnlifenum++;
                    }
                }
            }
            System.out.printf(" => %d개 일치%n", turnlifenum);
        }
    }
}