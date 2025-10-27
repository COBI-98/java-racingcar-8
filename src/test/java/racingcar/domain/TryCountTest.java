package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class TryCountTest {

    @DisplayName("constructor(): 각 자동차에 이름을 부여할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"3", "6", "10"})
    void constructor_tryCount_success(String input) throws Exception {
        //given
        TryCount tryCount = new TryCount(input);
        int expected = Integer.parseInt(input.trim());

        //when //then
        assertThat(tryCount.getTryCount()).isEqualTo(expected);
    }

    @DisplayName("validateTryCountNonBlank(): 시도 횟수는 비어있거나 공백일 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "     "})
    void validateTryCountNonBlank_tryCount_fail(String input) throws Exception {
        //given
        String errorMessage = "[ERROR] 시도 횟수는 비어있거나 공백일 수 없습니다.";

        //when && then
        assertThatThrownBy(() -> new TryCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage);
    }

    @DisplayName("validateNaturalNumber(): 이동할 횟수는 자연수여야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "qw", "!@", "-1", "pobi"})
    void validateNaturalNumber_tryCount_fail(String input) throws Exception {
        //given
        String errorMessage = "[ERROR] 시도 횟수는 0보다 큰 자연수여야 합니다.";

        //when && then
        assertThatThrownBy(() -> new TryCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 시도 횟수는 0보다 큰 자연수여야 합니다.");
    }
}