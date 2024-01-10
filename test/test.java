package test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int year, month, count;
        int[][] months = new int[3][42];
        LocalDate[] localDates = new LocalDate[3];

        System.out.print("달력의 년도를 입력해 주세요.(yyyy): ");
        year = sc.nextInt();
        System.out.print("달력의 월를 입력해 주세요.(mm): ");
        month = sc.nextInt();
        LocalDate localDate;

        // 입력 전 달과 입력 달
        for(int i=-1; i<1; i++) {
            if (month + i < 1) {
                localDate = LocalDate.of(year - 1, 12, 1);
            } else if (month + i > 12) {
                localDate = LocalDate.of(year + 1, 1, 1);
            } else {
                localDate = LocalDate.of(year, month + i, 1);
            }

            localDates[i+1] = localDate;

            count = dayOfWeek(localDate.getDayOfWeek());

            for (int dayStart = 1; dayStart <= localDate.lengthOfMonth(); dayStart++) {
                months[i + 1][dayStart - 1 + count] = dayStart;
            }
        }

        // 현재 달
        localDate = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(),1);
        localDates[2] = localDate;

        count = dayOfWeek(localDates[2].getDayOfWeek());

        for (int dayStart = 1; dayStart <= localDates[2].lengthOfMonth(); dayStart++) {
            months[2][dayStart - 1 + count] = dayStart;
        }

        printMonth(localDates, months);

    }

    // 달의 시작 요일 만큼의 빈칸 개수
    public static int dayOfWeek(DayOfWeek dayOfWeek) {
        switch (dayOfWeek) {
            case SUNDAY:
                return 0;
            case MONDAY:
                return 1;
            case TUESDAY:
                return 2;
            case WEDNESDAY:
                return 3;
            case THURSDAY:
                return 4;
            case FRIDAY:
                return 5;
            case SATURDAY:
                return 6;
        }
        return 7;
    }

    public static void printMonth(LocalDate[] localDates, int[][] months) {
        for(int i=0; i<3; i++) {
            System.out.print(String.format("[%d년 %02d월]\t\t\t\t\t", localDates[i].getYear(), localDates[i].getMonth().getValue()));
        }
        System.out.println();
        for(int i=0; i<3; i++) {
            System.out.print("일\t월\t화\t수\t목\t금\t토\t\t");
        }
        System.out.println();
        for(int i=0; i<6; i++) {	// 한 달의 최대 주 개수
            for(int j=0; j<3; j++) {	// 나타낼 달력 개수
                for(int k = 0; k < 7; k++) {	// 주의 일
                    if(months[j][i*7+k] != 0) {
                        System.out.print(String.format("%02d\t", months[j][i * 7 + k]));
                    } else {
                        System.out.print("\t");
                    }
                }
                System.out.print("\t");
            }
            System.out.println();
        }
    }
}
