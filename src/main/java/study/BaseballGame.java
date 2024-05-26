package study;

import java.util.List;
import java.util.stream.Stream;

// judge, play를 결정하는 역할을 가진다.
public class BaseballGame implements Playable {

    private Balls computerBalls;
    private Balls playerBalls;

    public BaseballGame(Balls computerBalls, Balls playerBalls) {
        this.computerBalls = computerBalls;
        this.playerBalls = playerBalls;
    }

    @Override
    public PlayResult play() {
        return judgeBalls(computerBalls, playerBalls);
    }

    private PlayResult judgeBalls(Balls computerBalls, Balls playerBalls) {
        List<Ball> playBallList = playerBalls.getBalls();
        List<Ball> computerBallList = computerBalls.getBalls();

        // playerBall마다 computerBallList에 해당하는지를 조회한다.
        playBallList.stream().map(playerBall -> {
            computerBallList.forEach(computerBall -> judgeBall(computerBall, playerBall));

            // TODO : BallStatus상태값에 따라 strike, ball, nothing을 추가해 주자
        })

        return new PlayResult();
    }

    private BallStatus judgeBall(Ball computerBall, Ball playerBall) {
        // STRIKE 판정
        if (playerBall.isEqualNumber(computerBall) && playerBall.isEqualPos(computerBall)) {
            return BallStatus.STRIKE;
        }

        // BALL 판정
        if (playerBall.isEqualPos(computerBall)) {
            return BallStatus.BALL;
        }

        // NOTHING 판정
        return BallStatus.NOTHING;
    }
}
