package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class EnergyGeneratorTest {
    @DisplayName("EnergyGenerator 는 생성 범위를 가지며 사용자 입력 숫자만큼 Energy 를 생성한다.")
    @Test
    public void createTest() {
        EnergyGenerator energyGenerator = new EnergyGenerator(1, 9);
        Energy[] createEnergy = energyGenerator.create(1);
        assertThat(createEnergy.length).isEqualTo(1);
    }
}
