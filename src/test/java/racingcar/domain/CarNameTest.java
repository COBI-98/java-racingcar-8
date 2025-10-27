package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "woni", "jun"})
    @DisplayName("경주할 자동차를 생성할 수 있다.")
    void constructor_carName_success(String input) {
        // given
        CarName carName = new CarName(input);

        // when & then
        assertThat(carName.name()).isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"    ", ""})
    @DisplayName("경주할 자동차 이름이 비어있거나 공백일 수 없다.")
    void constructor_carName_blank_fail(String carName) {
        // given
        String expectedMessage = "[ERROR] 자동차이름은 비어있거나 공백일 수 없습니다.";

        // when & then
        assertThatThrownBy(() -> new CarName(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }
}