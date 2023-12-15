/*
제로베이스 백엔드 20기 신동호
미니과제03 - 입장권 계산
 */
import java.util.*;


public class ZBMini03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int age, time, ans = 10000;
        String sale1,sale2 ;
        System.out.println("[입장권 계산]");
        System.out.print("나이를 입력해 주세요.(숫자):");
        age = input.nextInt();
        System.out.print("입장시간을 입력해 주세요.(숫자입력):");
        time = input.nextInt();
        System.out.print("국가유공자 여부를 입력해 주세요.(y/n):");
        sale1 = input.next();
        System.out.print("복지카드 여부를 입력해 주세요.(y/n):");
        sale2 = input.next();
        if (sale1.equals("y") || sale2.equals("y")) {
            ans = 8000;
        } else if ((age >= 3 && age < 13) || time > 17) {
            ans = 4000;
        } else if (age < 3) {
            ans = 0;
        }
        System.out.println("입장료: " + ans);
    }
}