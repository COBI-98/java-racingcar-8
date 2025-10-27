package racingcar.domain;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.RandomUtils;

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

    public void moveAll(final RandomUtils randomUtils) {
        for (final Car car : cars) {
            int engine = randomUtils.generateRandomNumber();
            car.move(engine);
        }
    }

    public List<CarName> findWinners() {
        Car maxDistanceCar = findMaxDistanceCar();
        List<CarName> winnerCarNameList = findSameDistanceList(maxDistanceCar);
        return winnerCarNameList;
    }

    private Car findMaxDistanceCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 경주할 자동차가 없습니다."));
    }

    private List<CarName> findSameDistanceList(Car maxDistanceCar) {
        return cars.stream()
                .filter(maxDistanceCar::isSameDistance)
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }
}
