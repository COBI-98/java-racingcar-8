package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DistanceTest {

    @DisplayName("constructor(): 경주할 자동차의 위치를 생성한다.")
    @Test
    void constructor_distance_success() {
        // given
        final int INITIAL_POSITION = 0;
        Distance distance = new Distance();

        // when & then
        assertThat(distance.toInt()).isEqualTo(INITIAL_POSITION);
    }

}