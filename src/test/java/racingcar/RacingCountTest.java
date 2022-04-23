package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCountTest {

    @DisplayName("생성시 Integer 값을 가지며, VO 객체이다.")
    @Test
    public void createTest() {
        RacingCount racingCount = new RacingCount(0);
        assertThat(racingCount).isEqualTo(new RacingCount(0));
    }
}
