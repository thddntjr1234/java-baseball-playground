package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Set 자료구조 테스트")
public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    void requirement1() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("set 내에 값이 존재하는지 검사한다")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void requirement2(int number) {
        assertThat(numbers).contains(number);
    }

    @DisplayName("set 내에 값이 존재하는지를 Boolean으로 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
    void requirement3(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
