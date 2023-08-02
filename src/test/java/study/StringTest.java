package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void case1WithContains() {
        // 배열로 반환하는 값의 경우 assertj의 contains(), containsExactly()를 활용해 반환 값이 맞는지 검증한다.
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).contains("2");
    }

    @Test
    void case1WithContainsExactly() {
        // 원소가 정확히 일치해야 한다.
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void case2() {
        // substring 메소드를 활용한다.
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt() 수행 시 특정 위치의 문자를 가져올 때 위치 값을 벗어나는 경우 예외 테스트")  // 테스트 메소드의 의도를 드러낸다.
    void case3WithThrownBy() {
        // 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 Exception이 발생한다.
        assertThatThrownBy(() -> {
            char result = "abc".charAt(3);
        })
        .isInstanceOf(IndexOutOfBoundsException.class)
        .hasMessageContaining("String index out of range: 3");
    }

    @Test
    @DisplayName("charAt() 수행 시 특정 위치의 문자를 가져올 때 위치 값을 벗어나는 경우 예외 테스트")
    void case3WithExceptionOfType() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
        .isThrownBy(() -> {
            char result = "abc".charAt(3);
        })
        .withMessageMatching("String index out of range: \\d+");
    }
}
