package study;

public class Ball {
    private int pos;
    private int number;

    public Ball(int pos, int number) {

    }

    boolean isEqualPos(Ball targetBall) {
        return this.pos == targetBall.pos;
    }

    boolean isEqualNumber(Ball targetBall) {
        return this.number == targetBall.number;
    }
}
