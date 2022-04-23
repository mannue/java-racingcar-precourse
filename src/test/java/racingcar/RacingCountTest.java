package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCountTest {

    @DisplayName("생성시 Integer 값을 가지며, VO 객체이다.")
    @Test
    public void createTest() {
        RacingCount racingCount = new RacingCount(0);
        assertThat(racingCount).isEqualTo(new RacingCount(0));
    }

    @DisplayName("레이싱 횟수는 음수 값을 입력할수 없다.")
    @Test
    public void invalidRacingCount() {
        assertThatThrownBy(() -> new RacingCount(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
