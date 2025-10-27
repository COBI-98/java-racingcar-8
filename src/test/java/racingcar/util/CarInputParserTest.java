package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;

class CarInputParserTest {

    @DisplayName("constructor(): 자동차는 쉼표(,)를 기준으로 구분하여 생성된다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni,jun"})
    void constructor_carInputParser_success(String playerInput) throws Exception{
        //given
        List<String> expected = List.of("pobi", "woni", "jun");
        List<Car> cars = CarInputParser.splitCarNames(playerInput);

        //when && then
        assertThat(cars).hasSameSizeAs(expected);
    }

}