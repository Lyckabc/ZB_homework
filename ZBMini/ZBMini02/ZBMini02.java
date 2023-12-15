/*
제로베이스 백엔드 20기 신동호
미니과제02 - 캐시백 계산
 */
import java.util.*;

public class ZBMini02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cash, cback = 0;
        System.out.println("[캐시백 계산]");
        System.out.print("결제 금액을 입력해 주세요.(금액):");
        cash = input.nextInt();
        cback = ((cash /10) / 100) * 100;
        if (cback > 300) {
            cback = 300;
        }
        System.out.print(String.format("결제 금액은 %d원이고, 캐시백은 %d원 입니다.", cash, cback));
    }
}