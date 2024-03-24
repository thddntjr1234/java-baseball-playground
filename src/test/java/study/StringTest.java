package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DisplayName("문자열 테스트")
public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("split으로 반점이 제거한다")
    void requirements1() {
        String input = "1,2";
        String[] result = input.split(",");

        System.out.println("1, 2 split 테스트");
        assertThat(result).contains("1", "2");

        String input2 = "1";
        String[] result2 = input.split(",");

        System.out.println("1 split 테스트");
        assertThat(result2).contains("1");
    }

    @Test
    @DisplayName("subString으로 괄호를 제거한다")
    void requirements2() {
        String input = "(1,2)";

        String result = input.substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt() 사용 중 예외 발생시 이를 처리한다")
    void requirements3() {
        String input = "abc";

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
          .isThrownBy(() -> {
              char c = input.charAt(4);
              assertThat(c).isEqualTo('c');
        }).withMessageContaining("%d", 4);
    }
}
