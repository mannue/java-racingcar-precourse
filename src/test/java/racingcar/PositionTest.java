package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class PositionTest {

    @DisplayName("Position 는 VO 객체다")
    @Test
    public void createTest() {
        Position zeroPosition = new Position(0);
        assertThat(zeroPosition).isEqualTo(new Position(0));
        assertThat(zeroPosition).isNotEqualTo(new Position(1));
    }
}
