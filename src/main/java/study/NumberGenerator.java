package study;

import java.util.Random;

public class NumberGenerator {
    public static int generateRandomNumber() {
        return new Random().nextInt(900) + 100;
    }
}
