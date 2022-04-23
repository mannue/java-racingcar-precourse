package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.*;

public class CarsTest {
    private Cars cars;
    private String[] carNames = {"pobi", "crong"};

    @BeforeEach
    public void setUp() {
        cars = new Cars(getCarArrayBy(carNames));
    }

    @DisplayName("Cars 는 Car Array 를 입력받는다.")
    @Test
    public void creatCars() {
        assertThat(cars).isNotNull();
        assertThat(cars.isNumberOfParticipants(carNames.length)).isTrue();
    }

    private Car[] getCarArrayBy(String... name) {
        Car[] cars = new Car[name.length];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(new Name(name[i]), new Energy(3), new Position(0));
        }
        return cars;
    }

    @DisplayName("EnergyGenerator 를 인자로 받고 Car Array 크기 만큼 create 메소드를 호출한다.")
    @Test
    public void play() {
        EnergyGenerator spyGenerator = spy(new EnergyGenerator(1, 9));
        cars.play(spyGenerator);
        verify(spyGenerator, times(carNames.length)).create();
    }
}
