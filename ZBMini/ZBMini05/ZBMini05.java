/*
제로베이스 백엔드 20기 신동호
미니과제05 - 달력 출력 프로그램
 */
import java.time.*;
import java.util.*;
//import java.io.*;


public class ZBMini05 {
    public static void main(String[] args) {
        System.out.println("달력 출력 프로그램");
        Scanner input = new Scanner(System.in);
        int yy, mm ;
        System.out.print("달력의 년도를 입력해 주세요.(yyyy):");
        yy = input.nextInt();
        System.out.print("달력의 월을 입력해 주세요.(mm):");
        mm = input.nextInt();

        String[][] CalendarArray1 = GenerateCalArr(yy, mm-1);
        String[][] CalendarArray2 = GenerateCalArr(yy, mm);
        String[][] CalendarArray3 = GenerateCalArr(yy, mm+1);

        for (int i = 0; i < 8; i++) {
            PrintSet(CalendarArray1, i);
            System.out.printf("\t\t");
            PrintSet(CalendarArray2, i);
            System.out.printf("\t\t");
            PrintSet(CalendarArray3, i);
            System.out.println();
        }
    }

    private static String[][] GenerateCalArr(int year, int month) {
        String[][] CalendarArray = new String[8][7];
//        System.out.println(Arrays.deepToString(CalendarArray));
        CalendarArray[0][0] = String.format("[%d년 %d월]", year, month);
        CalendarArray[1] = new String[]{"일","월","화","수","목","금","토"};
        int date = 1 ;
        int dayValue ;
        int calLength ;
        int calrow = 2 ;
        int calcol ;
        LocalDate Cal ;

        Cal = LocalDate.of(year, month, date);
        // 그 달의 첫 날.
        calLength = Cal.lengthOfMonth();
        // 그 달의 길이.
        dayValue = Cal.getDayOfWeek().getValue();
        // 월~일 요일을 숫자화(1~7)
        calcol = dayValue;
        // 그 달의 숫자화 된 요일 if 월요일 = 1
//        System.out.print("Cal" + ":" + Cal + "\n");
//        System.out.print("calLength" + ":" + calLength + "\n");
//        System.out.print("calcol" + ":" + calcol + "\n");
        if (calcol % 7 == 0) {
            calcol = 0;
        }
        for (int i = date; i <= calLength; i++) {
            CalendarArray[calrow][calcol] = String.valueOf(String.format("%02d",date));
            date++;
            calcol++;
            if (calcol % 7 == 0) {
                calrow++;
                calcol = 0;
            }
//            System.out.print("calcol" +i + ":" + calcol + "  ");
//            System.out.print("calrow" +i + ":" + calrow + "\n");
//            System.out.println(Arrays.deepToString(CalendarArray));
        }
//        System.out.println(Arrays.deepToString(CalendarArray));
        return CalendarArray;
    }
    
    private static void PrintSet(String[][] CalendarArray, int row) {
        if (row == 0) {
            System.out.print(String.format("%-40s", CalendarArray[0][0]));
        } else if (row == 1) {
            for (int i = 0; i < 7 ; i++) {
                    System.out.printf(CalendarArray[row][i]);
                if (i != 6) {
                    System.out.printf("%-5s", "");
                }
            }
        } else {
            for (int i = 0; i < 7; i++) {
                if (CalendarArray[row][i] == null || CalendarArray[row][i].isEmpty()) { //(stirng != null && !string.isEmpty())
                    System.out.printf("%-4s", " ");
                } else {
                    System.out.printf("%-4s", CalendarArray[row][i]);
                }
                if (i != 6) {
                    System.out.printf("%-2s", "");
                }
            }
        }
    }
}
