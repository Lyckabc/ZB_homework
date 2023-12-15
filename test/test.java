package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) { // n 만큼 숫자를 입력해서 numbers 에 저장한다.
            numbers.add(Integer.parseInt(scanner.next()));
        }
        List<Stack<Integer>> stackList = new ArrayList<>();
        for (int i = 0; i < 4; i++) { // 1 부터 시작이므로 0을 미리 저장한다.
            stackList.add(new Stack<>());
            stackList.get(i).push(0);
        }
        boolean isFlag = true;
        for (int number : numbers) {
            boolean isNumber = false;
            for (Stack<Integer> integers : stackList) {
                if (number > integers.peek()) { // 리스트 안에 스택 한개를 꺼내서 맨위의 값을 꺼냈을 때 스택에 있는애보다 크면 스택에 저장
                    integers.push(number);
                    isNumber = true; // number 가 더 크면 true 하고 멈추기
                    break;
                }
            }
            if (!isNumber) { // 숫자가 작거나 같아서 true 로 바뀌지 않았다면 제일 밖에 for 문 정지
                isFlag = false;
                break;
            }
        }
        if (isFlag) { // 모든 숫자들을 스택에 저장할 수 있었으면 YES 그렇지 않으면 NO
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}