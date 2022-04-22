package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.verify;

public class CarTest {
    private static final int MIN_GAUGE = 4;
    private static final String DEFAULT_NAME = "pobi";
    private Car car;

    @BeforeEach
    void setUp() {
        this.car = new Car(DEFAULT_NAME, new Energy(MIN_GAUGE));
    }

    @DisplayName("Car 는 이름과 최소 Energy 를 갖는다.")
    @Test
    public void hasNameWithPosition() {
        assertThat(car).isNotNull();
    }

    @DisplayName("Car 는 외부로부터 입력 받은 Energy 가 최소 Energy 보다 크면 움직인다.")
    @ParameterizedTest
    @CsvSource(value = {"4:True", "9:True", "3:False"}, delimiter = ':')
    public void isMove(final int energyValue, final boolean expectedResult) {
        assertThat(car.isMove(new Energy(energyValue))).isEqualTo(expectedResult);
    }

    @DisplayName("Car 는 Position 값을 가진다.")
    @Test
    public void hasPosition() {
        assertThat(new Car(DEFAULT_NAME, new Energy(MIN_GAUGE), new Position(0))).isNotNull();
    }

    @DisplayName("Car 가 움직이면 Position 값도 증가한다.")
    @Test
    public void increasePosition() {
        Position mockPosition = Mockito.spy(Position.class);
        Car defaultCar = new Car(DEFAULT_NAME, new Energy(MIN_GAUGE), mockPosition);
        assertThat(defaultCar.isMove(new Energy(MIN_GAUGE + 1))).isEqualTo(true);
        verify(mockPosition).move(1);
    }
}
