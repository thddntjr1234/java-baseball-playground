package study;

import org.junit.jupiter.api.*;
import study.baseball.before.Baseball;
import study.baseball.before.InputView;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("숫자야구게임 테스트")
public class BaseballTest {

    private Baseball baseball;
    private InputView inputView;

    @BeforeEach
    public void init() {
        baseball = new Baseball();
        inputView = new InputView();
    }

    @Test
    @DisplayName("컴퓨터가 랜덤하게 생성한 값이 100~999사이의 자연수인가?")
    public void validateGeneratedComputerNumber() {
        // given
        int num;

        // when
        num = baseball.getRandomNumber();

        // then
        assertThat(num).isGreaterThan(99).isLessThan(1000);
    }

    @Test
    @DisplayName("플레이어가 입력한 값이 100~999사이의 자연수인가?")
    public void validatePlayerInputNumber() throws IOException {
        // given
        int num;
        InputStream input = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("482".getBytes());
        System.setIn(in);

        // when
        num = inputView.getInputNumber();

        // then
        assertThat(num).isGreaterThan(99).isLessThan(1000);
    }

    @Test
    @DisplayName("3자리의 자연수는 각 자리별로 배열에 분리되는가?")
    public void split() {
        // given
        int number = 297;

        // when
        int[] numArr = baseball.split(number);

        //then
        assertThat(numArr).hasSize(3);
    }

    @Test
    @DisplayName("1스트라이크 1볼로 정상 계산되는가?")
    public void baseballCalculate() {
        // given
        List<Integer> playerNumberList = Arrays.asList(2, 6, 4);
        List<Integer> computerNumberList = Arrays.asList(4, 6, 3);

        // when
        baseball.getBaseballResult(playerNumberList, computerNumberList);

        // then
        assertThat(baseball.getStrike()).isEqualTo(1);
        assertThat(baseball.getBall()).isEqualTo(1);
    }

    @Test
    @DisplayName("아무 것도 일치하지 않는 경우 정상 계산되는가?")
    public void baseballCalculateNoting() {
        // given
        List<Integer> playerNumberList = Arrays.asList(2, 6, 4);
        List<Integer> computerNumberList = Arrays.asList(8, 7, 3);

        // when
        baseball.getBaseballResult(playerNumberList, computerNumberList);

        // then
        assertThat(baseball.getStrike()).isEqualTo(0);
        assertThat(baseball.getBall()).isEqualTo(0);
    }
}
