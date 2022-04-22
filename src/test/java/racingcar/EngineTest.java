package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class EngineTest {

    @DisplayName("엔진은 작동을 판단하는 EnergyGauge 를 갖는다.")
    @Test
    public void createTest() {
        Engine engine = new Engine(0);
        assertThat(engine).isNotNull();
    }


    @DisplayName("엔진은 외부로 부터 Energy 를 주입받아서 작동여부를 확인한다")
    @ParameterizedTest
    @MethodSource("provideGaugeAndInputAndExpectedResult")
    public void isWorkingTest(final int gauge, final int input, final boolean expectedResult) {
        assertThat(new Engine(gauge).isWorking(new Energy(input))).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideGaugeAndInputAndExpectedResult() {
        return Stream.of(
                Arguments.of(1, 9, true),
                Arguments.of(9, 1, false),
                Arguments.of(5, 5, true)
        );
    }
}
