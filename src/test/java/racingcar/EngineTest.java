package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class EngineTest {

    @DisplayName("엔진은 작동을 판단하는 EnergyGauge 를 갖는다.")
    @Test
    public void createTest() {
        Engine engine = new Engine(0);
        assertThat(engine).isNotNull();
    }
}
