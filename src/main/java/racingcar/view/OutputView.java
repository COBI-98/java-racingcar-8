package racingcar.view;

import racingcar.domain.Car;
public class OutputView {

    private static final String EXECUTION_RESULT = "실행 결과";
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
}
