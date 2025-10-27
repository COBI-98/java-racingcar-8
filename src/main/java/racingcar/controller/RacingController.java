package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.TryCount;
import racingcar.util.CarInputParser;
import racingcar.util.CarRandomMoveGenerator;
import racingcar.util.RandomUtils;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RandomUtils racingCarRandomMoveUtils = new CarRandomMoveGenerator();

    public RacingController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void start() {
        Cars racingCars = createRacingCars();
        TryCount tryCount = new TryCount(inputView.inputAttempts());

        racing(racingCars, tryCount);

        outputView.printRacingCarWinnerResult(racingCars);
    }

    private Cars createRacingCars() {
        List<Car> carList = CarInputParser.splitCarNames(inputView.inputCarNames());
        return new Cars(carList);
    }

    private void racing(Cars racingCars, TryCount tryCount) {
        outputView.printExecutionResult();

        for (int i = 0; i < tryCount.getTryCount(); i++) {
            racingCars.moveAll(racingCarRandomMoveUtils);
            outputView.printRoundByExecutionResults(racingCars);
        }
    }

}
