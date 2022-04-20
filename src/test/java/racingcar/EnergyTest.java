package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class EnergyTest {

    @DisplayName("Energy 는 int 값을 전달 받고 VO 객체이다.")
    @Test
    public void validTest() {
        assertThat(new Energy(0)).isEqualTo(new Energy(0));
        assertThat(new Energy(0)).isNotEqualTo(new Energy(9));
    }

    @DisplayName("Energy 는 0~9 까지의 값만 갖는다.")
    @Test
    public void invalidTest() {
        assertThatThrownBy(() -> new Energy(-1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() ->  new Energy(10)).isInstanceOf(IllegalArgumentException.class);
    }
}
