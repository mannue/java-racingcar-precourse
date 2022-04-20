package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EnergyTest {

    @DisplayName("Energy 는 int 값을 전달 받고 VO 객체이다.")
    @Test
    public void validTest() {
        assertThat(new Energy(0)).isEqualTo(new Energy(0));
        assertThat(new Energy(0)).isNotEqualTo(new Energy(9));
    }
}
