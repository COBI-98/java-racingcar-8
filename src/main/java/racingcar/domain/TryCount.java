package racingcar.domain;

import java.util.regex.Pattern;

public class TryCount {

    private static final Pattern NATURAL_NUMBER = Pattern.compile("^[1-9]\\d*$");
    private final int tryCount;

    public TryCount(final String input) {
        String trimmedInput = validateTryCountNonBlank(input);
        validateNaturalNumber(trimmedInput);
        this.tryCount = convertStringToInt(trimmedInput);
    }

    private static String validateTryCountNonBlank(final String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 비어있거나 공백일 수 없습니다.");
        }
        return input.strip();
    }

    private static void validateNaturalNumber(final String input) {
        if (!NATURAL_NUMBER.matcher(input).matches()) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 0보다 큰 자연수여야 합니다.");
        }
    }

    private int convertStringToInt(final String input) {
        return Integer.parseInt(input);
    }

    public int getTryCount() {
        return tryCount;
    }
}
