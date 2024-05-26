package study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Balls {

    // Balls가 Play 메서드를 가지는 것이 맞을까, 별도의 Play 객체를 가지는게 맞을까?

    private List<Ball> balls = new ArrayList<>();
    public Balls(int randomNumber) {
        int[] numbers = Arrays.stream(String.valueOf(randomNumber).split("")).mapToInt(Integer::parseInt).toArray();

        for (int pos = 0; pos < 3; pos++) {
            int number = numbers[pos];
            balls.add(new Ball(pos + 1, number)); // index 상으로는 0~2지만, 실제론 1~3자리이므로 +1 수행
        }
    }

    public List<Ball> getBalls() {
        return this.balls;
    }
}
