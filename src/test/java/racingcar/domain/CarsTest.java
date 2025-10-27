package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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

}