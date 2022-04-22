package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class CarTest {
    private static final int MIN_GAUGE = 4;
    private static final String DEFAULT_NAME = "pobi";
    private Car car;
    private Position spyPosition;
    @BeforeEach
    void setUp() {
        this.spyPosition = spy(new Position(0));
        this.car = new Car(DEFAULT_NAME, new Energy(MIN_GAUGE), spyPosition);
    }

    @DisplayName("Car 는 이름, 최소 Energy, Position 를 갖는다.")
    @Test
    public void hasNameWithEnergyWithPosition() {
        assertThat(car).isNotNull();
    }

    @DisplayName("Car 는 외부로부터 입력 받은 Energy 가 최소 Energy 보다 크면 움직인다.")
    @ParameterizedTest
    @CsvSource(value = {"4:True", "9:True", "3:False"}, delimiter = ':')
    public void isMove(final int energyValue, final boolean expectedResult) {
        assertThat(car.isMove(new Energy(energyValue))).isEqualTo(expectedResult);
    }

    @DisplayName("Car 가 움직이면 Position 값도 증가한다.")
    @Test
    public void increasePosition() {
        this.isMove(MIN_GAUGE+1, true);
        verify(spyPosition).move(1);
    }
}
