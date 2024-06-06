package study.baseball.before;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class InputView {
    public int getInputNumber() throws IOException {
        System.out.println("숫자를 입력해 주세요 : ");
        Scanner sc = new Scanner(System.in);

        return sc.nextInt();
    }

    public int getPlayType() throws IOException {
        Scanner sc = new Scanner(System.in);

        return sc.nextInt();
    }
}
