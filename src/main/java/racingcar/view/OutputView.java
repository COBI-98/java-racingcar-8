package racingcar.view;

import static java.util.stream.Collectors.joining;

import java.util.List;
import java.util.StringJoiner;
import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.Cars;

public class OutputView {

    private static final String EXECUTION_RESULT = "실행 결과";
    private static final String FINAL_WINNER = "최종 우승자";
    private static final String NEW_LINE = "\n";
    private static final String COLON_SIGN = " : ";
    private static final String MOVE_SIGN = "-";
    private static final String COMMA_SIGN = ", ";

    public void printExecutionResult(){
        System.out.print(NEW_LINE);
        System.out.println(EXECUTION_RESULT);
    }

    public void printRoundByExecutionResults(final Cars cars) {
        StringBuilder resultByRound = new StringBuilder();
        for (Car car : cars.getCars()) {
            resultByRound.append(car.getCarName())
                    .append(COLON_SIGN)
                    .append(MOVE_SIGN.repeat(car.getDistance().toInt()))
                    .append(NEW_LINE);
        }
        System.out.println(resultByRound);
    }

    public void printRacingCarWinnerResult(final Cars cars) {
        String winners = cars.findWinners().stream()
                .map(CarName::name)
                .collect(joining(COMMA_SIGN));

        System.out.println(FINAL_WINNER + COLON_SIGN + winners);
    }
}
