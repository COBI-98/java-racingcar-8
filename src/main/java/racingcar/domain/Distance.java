package racingcar.domain;

public class Distance {

    private static final int INITIAL_POSITION = 0;

    private int position;

    public Distance() {
        this.position = INITIAL_POSITION;
    }

    public void move(int distance) {
        this.position += distance;
    }

    public int toInt() {
        return this.position;
    }

}
