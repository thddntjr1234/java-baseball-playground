package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BaseballTest {

    @BeforeEach
    void initTestStart() {

    }

    @Test
    @DisplayName("100~999사이의 수를 가진 공을 생성한다.")
    void generate_random_3digits_number() {
        Balls balls = new Balls(NumberGenerator.generateRandomNumber());
        assertThat(balls.getBalls().size()).isEqualTo(3);
    }

}
