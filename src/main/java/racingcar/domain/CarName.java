package racingcar.domain;

public record CarName(String name) {

    private static final int CAR_NAME_LENGTH_MAX = 5;

    public CarName {
        name = validateCarNameNonBlank(name);
        validateCarNameLength(name);
    }

    private static String validateCarNameNonBlank(final String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 자동차이름은 비어있거나 공백일 수 없습니다.");
        }
        return name.strip();
    }

    private void validateCarNameLength(final String carName) {
        if (carName.length() > CAR_NAME_LENGTH_MAX) {
            throw new IllegalArgumentException("[ERROR] 자동차이름은 1자리이상 5자 이하만 가능합니다.");
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
