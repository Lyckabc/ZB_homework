/*
제로베이스 백엔드 20기 신동호
 */

public class Test {
    public static void main(String[] args) {
        int ans = 0;
        System.out.println("[구구단 출력]");
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                ans = i * j;
                System.out.print(String.format("%02d x %02d = %02d    ", j, i, ans));
            }
            System.out.println();
        }
    }
}