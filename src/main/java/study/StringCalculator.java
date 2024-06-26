package study;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StringCalculator {

    /*    요구사항
          사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
          문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다.
          즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
          예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다. */
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String input = sc.nextLine();
//
//        System.out.println(calculate(input));
//    }

    public int calculate(String input) {
        String[] values = input.split(" ");
        List<String> instructions = Arrays.asList("+", "-", "*", "/");

        int sum = 0;
        Integer a = null;
        Integer b = null;
        String instruction = null;

        for (String value : values) {
            if (instructions.contains(value)) {
                instruction = value;
            } else if (a == null) {
                a = Integer.parseInt(value);
            } else if (b == null) {
                b = Integer.parseInt(value);
            }

            if (a != null && b != null && instruction != null) {
                sum = eachCalculate(instruction, a, b);
                System.out.println(sum);
                a = sum;
                b = null;
                instruction = null;
            }
        }

        return sum;
    }

    public int eachCalculate(String instruction, Integer a, Integer b) {
        int result = 0;

        if (instruction.equals("+")) {
            result = a + b;
        } else if (instruction.equals("-")) {
            result = a - b;
        } else if (instruction.equals("*")) {
            result = a * b;
        } else if (instruction.equals("/")) {
            result = a / b;
        }
        return result;
    }
}
