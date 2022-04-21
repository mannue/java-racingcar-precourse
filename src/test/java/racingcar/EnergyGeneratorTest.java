package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class EnergyGeneratorTest {
    @DisplayName("EnergyGenerator 는 생성 범위를 가지며 사용자 입력 숫자만큼 Energy 를 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {1,9})
    public void createTest(final int number) {
        EnergyGenerator energyGenerator = new EnergyGenerator(1, 9);
        Energy[] createEnergy = energyGenerator.create(number);
        assertThat(createEnergy.length).isEqualTo(number);
    }

    @DisplayName("생성범위는 잘못 입력시 에러 발생")
    @ParameterizedTest
    @CsvSource(value = {"9:1","-2:-9","2:2"}, delimiter = ':')
    public void invalidRange(final int rangeMin, final int rangeMax) {
        assertThatThrownBy(() -> new EnergyGenerator(rangeMin, rangeMax))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
