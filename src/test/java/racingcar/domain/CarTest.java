package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @DisplayName("constructor(): 경주할 자동차를 생성할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "woni", "jun"})
    void constructor_car_success(String input) {
        // given
        Car car = new Car(input);

        // when & then
        assertThat(car).isNotNull();
    }
}