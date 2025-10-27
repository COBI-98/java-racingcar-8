package racingcar.util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarRandomMoveGeneratorTest {

    private static RandomUtils randomUtils = new GenerateCarMoveSuccessTest();
    private static int randomNumber = randomUtils.generateRandomNumber();


    @DisplayName("generateRandomNumber() : 0에서 9사이에서 무작위한 값을 생성한다.")
    @Test
    void generateRandomNumber_car_success() throws Exception {
        //given
        final int min = 0;
        final int max = 9;

        //when && then
        assertThat(randomNumber).isBetween(min, max);
    }
}