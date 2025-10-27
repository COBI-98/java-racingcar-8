package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.util.CarInputParser;
import racingcar.view.InputView;

public class RacingController {

    private final InputView inputView;

    public RacingController() {
        inputView = new InputView();
    }

    public void start() {
        List<Car> carList = CarInputParser.splitCarNames(inputView.inputCarNames());

    }
}
