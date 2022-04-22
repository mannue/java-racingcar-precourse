package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CarTest {

    @DisplayName("Car 는 이름과 최소 Energy 를 갖는다.")
    @Test
    public void hasNameWithPosition() {
        assertThat(new Car("pobi", new Energy(4))).isNotNull();
    }
}
