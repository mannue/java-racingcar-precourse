package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

}
