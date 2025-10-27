package racingcar.domain;

public class Car {
    private static final int MOVING_DISTANCE = 1;
    private static final int MOVING_CONDITION = 4;

    private CarName carName;
    private Distance distance;

    public Car(final String name) {
        this.carName = new CarName(name);
        distance = new Distance();
    }

    public void move(final int number) {
        if (number >= MOVING_CONDITION) {
            distance.move(MOVING_DISTANCE);
        }
    }

    public CarName getCarName() {
        return carName;
    }

    public Distance getDistance() {
        return distance;
    }
}