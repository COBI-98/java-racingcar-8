package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarsTest {

    @DisplayName("각 자동차에 이름을 부여할 수 있다.")
    @ParameterizedTest
    @CsvSource({
            "pobi,woni,jin"
    })
    void constructor_cars_success(
            String pobi,
            String woni,
            String jin
            ) throws Exception {
        //given
        List<Car> cars = List.of(new Car(pobi), new Car(woni), new Car(jin));

        //when && then
        assertThatCode(() -> new Cars(cars)).doesNotThrowAnyException();
    }

    @DisplayName("자동차 이름은 중복으로 사용될 수 없다.")
    @ParameterizedTest
    @CsvSource({"pobi,pobi,woni,jin"})
    void constructor_cars_fail(
            String pobi,
            String pobi2,
            String woni,
            String jin
            ) throws Exception {
        //given
        String errorMessage = "[ERROR] 자동차 이름은 중복으로 사용될 수 없습니다.";
        List<Car> cars = List.of(new Car(pobi), new Car(pobi2), new Car(woni), new Car(jin));

        //when //then
        Assertions.assertThatThrownBy(() -> new Cars(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage);
    }
}