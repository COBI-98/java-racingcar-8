package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.TryCount;
import racingcar.util.CarInputParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void start() {
        Cars racingCars = createRacingCars();
        TryCount tryCount = new TryCount(inputView.inputAttempts());
    }

    private Cars createRacingCars() {
        List<Car> carList = CarInputParser.splitCarNames(inputView.inputCarNames());
        return new Cars(carList);
    }

}
