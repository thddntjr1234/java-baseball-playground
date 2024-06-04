package study;

import java.util.Objects;

public class Ball {
    private final int pos;
    private final int no;

    public Ball(int pos, int no) {
        this.pos = pos;
        this.no = no;
    }

    public BallStatus play(Ball ball) {
        if (this.equals(ball)) {
            return BallStatus.STRIKE;
        }

        if(matchBallNo(ball.no)) { // 강의에선 ball.matchBallnNo로 설명하지만, play()시 수행되는 내부 동작은 play하는 객체가 주체가 되어야 한다고 생각함.
            return BallStatus.BALL;
        }

        return BallStatus.NOTHING;
    }

    private boolean matchBallNo(int no) {
        return this.no == no;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return pos == ball.pos && no == ball.no;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pos, no);
    }
}
