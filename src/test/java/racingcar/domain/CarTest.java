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

    @DisplayName("move(): 값이 4 이상인 경우 전진한다.")
    @ParameterizedTest
    @ValueSource(strings = {"4", "5", "6"})
    void move_car_success(int input) {
        // given
        final String carName = "pobi";
        final int MOVING_DISTANCE = 1;
        Car car = new Car(carName);

        // when
        car.move(input);

        // then
        assertThat(car.getDistance().toInt()).isEqualTo(MOVING_DISTANCE);
    }

    @DisplayName("move(): 값이 3이하인 경우 멈춘다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    void move_car_fail(int input) {
        // given
        String carName = "pobi";
        Car car = new Car(carName);

        // when
        car.move(input);

        // then
        assertThat(car.getDistance().toInt()).isZero();
    }
}