package racingcar.domain;

public class Car {

    private CarName carName;
    private Distance distance;

    public Car(final String name) {
        this.carName = new CarName(name);
        distance = new Distance();
    }

    public CarName getCarName() {
        return carName;
    }

    public Distance getDistance() {
        return distance;
    }
}