/*
제로베이스 백엔드 20기 신동호
미니과제04 - 주민등록번호 계산
 */
import java.util.*;

public class ZBMini04 {
    public static void main(String args[]) {
        int yy, mm, dd, ran, sxn = 0;
        String sxs = "";
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("[주민등록번호 계산]");
        System.out.print("출생년도를 입력해 주세요.(yyyy):");
        yy = input.nextInt();
        System.out.print("출생월을 입력해 주세요.(mm):");
        mm = input.nextInt();
        System.out.print("출생일을 입력해 주세요.(dd):");
        dd = input.nextInt();
        System.out.print("성별을 입력해 주세요.(m/f):");
        sxs = input.next();
        ran = rand.nextInt(1000000);
        yy = yy % 2000;
        if (sxs.equals("m")) {
            sxn = 3;
        } else if (sxs.equals("f")) {
            sxn = 4;
        }
        System.out.println(String.format("%02d%02d%02d-%d%d", yy, mm, dd, sxn, ran));
    }
}