package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class EnergyTest {

    @DisplayName("Energy 는 int 값을 전달 받고 VO 객체이다.")
    @ParameterizedTest
    @CsvSource(value = {"0:0:True", "0:9:False"}, delimiter = ':')
    public void validTest(final int value, final int target, final boolean expectedResult) {
        assertThat(Objects.equals(new Energy(value),new Energy(target))).isEqualTo(expectedResult);
    }

    @DisplayName("Energy 는 0~9 까지의 값만 갖는다.")
    @ParameterizedTest
    @ValueSource(ints = {-1,10})
    public void invalidTest(final int item) {
        assertThatThrownBy(() -> new Energy(item)).isInstanceOf(IllegalArgumentException.class);
    }
}
