package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}
