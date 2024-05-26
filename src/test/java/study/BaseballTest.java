package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class BaseballTest {

    @Test
    @DisplayName("100~999사이의 수를 가진 공을 생성한다.")
    void generate_random_3digits_number() {
        Balls balls = new Balls(NumberGenerator.generateRandomNumber());
        assertThat(balls.getBalls().size()).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("스트라이크, 볼, 낫싱을 판단한다.")
    @CsvSource({"323,123,2스트라이크", "900,321,낫싱", "972,273,2볼", "180,109,1스트라이크 1볼"})
    void judge_ball_result(int computerNumber, int playerNumber, String resultMessage) {
        Balls computerBalls = new Balls(computerNumber);
        Balls playerBalls = new Balls(playerNumber);

        BaseballGame game = new BaseballGame(computerBalls, playerBalls);
        PlayResult playResult = game.play();

        assertThat(playResult.createResultMessage()).isEqualTo(resultMessage);
    }
}
