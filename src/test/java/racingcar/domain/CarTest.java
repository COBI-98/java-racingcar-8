package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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

    @DisplayName("isSameDistance(): 같은 위치의 자동차가 존재하는지 확인할 수 있다.")
    @ParameterizedTest
    @CsvSource({"2,6,false", "6,6,true"})
    void isSameDistance_car_success(
            int moveCondition1,
            int moveCondition2,
            boolean sameDistanceCheck
    ) throws Exception {
        //given
        Car myCar = new Car("pobi");
        Car competeCar = new Car("woni");

        //when
        myCar.move(moveCondition1);
        competeCar.move(moveCondition2);
        boolean sameDistance = myCar.isSameDistance(competeCar);

        //then
        assertThat(sameDistance).isEqualTo(sameDistanceCheck);
    }

    @DisplayName("compareTo(): 전진한 자동차들을 비교할 수 있다.")
    @ParameterizedTest
    @CsvSource({"2,6,-1", "6,6,0","6,2,1"})
    void compareTo_car_success(
            int moveCondition1,
            int moveCondition2,
            int compareToCheck
    ) throws Exception {

        //given
        String myCarName = "pobi";
        String competeCarName = "woni";
        Car myCar = new Car(myCarName);
        Car competeCar = new Car(competeCarName);

        //when
        myCar.move(moveCondition1);
        competeCar.move(moveCondition2);
        int compare = myCar.compareTo(competeCar);

        //then
        assertThat(compare).isEqualTo(compareToCheck);
    }
}