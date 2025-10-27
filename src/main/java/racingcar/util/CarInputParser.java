package racingcar.util;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;

public class CarInputParser {

    private static final String DELIMITER_COMMA = ",";
    private static final int PRESERVE_EMPTY_VALUES = -1;

    public CarInputParser() {
    }

    public static List<Car> splitCarNames(final String input) {
        return Arrays.stream(input.split(DELIMITER_COMMA, PRESERVE_EMPTY_VALUES))
                     .map(Car::new)
                     .toList();
    }

}
