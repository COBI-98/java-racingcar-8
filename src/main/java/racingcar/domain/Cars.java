package racingcar.domain;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        validateNoDuplicateCarNames(cars);
        this.cars = cars;
    }

    private void validateNoDuplicateCarNames(final List<Car> cars) {
        long distinct = cars.stream()
                .map(Car::getCarName)
                .distinct()
                .count();
        if (distinct != (long) cars.size()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 중복으로 사용될 수 없습니다.");
        }
    }
}
