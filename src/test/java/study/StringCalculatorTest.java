package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("문자열 계산기 테스트")
public class StringCalculatorTest {


    private StringCalculator stringCalculator;

    @BeforeEach
    void initialize() {
        stringCalculator = new StringCalculator();
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2, 10", "1 + 15 / 8 * 2 - 1, 3"})
    void 문자열_입력시_올바른_값을_반환하는가(String input, int expectValue) {
        assertThat(stringCalculator.calculate(input)).isEqualTo(expectValue);
    }
}
