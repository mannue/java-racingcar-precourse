package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static racingcar.RacingResult.Lose;
import static racingcar.RacingResult.Win;

public class CarTest {
    private static final int MIN_GAUGE = 4;
    private static final Name DEFAULT_NAME = new Name("pobi");
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
        this.isMove(MIN_GAUGE + 1, true);
        verify(spyPosition).move(1);
    }

    @DisplayName("isMove 메소드의 인자값은 null 이 될수 없다.")
    @Test
    public void isMoveParamIsNull() {
        assertThatThrownBy(() -> car.isMove(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("Car -> String 으로 변환시 이름과 Position 을 출력한다.")
    @ParameterizedTest
    @MethodSource("provideNamePositionExpectedString")
    public void toStringTest(final String name, final Position position, final String disPlayMsg) {
        assertThat(createCar(name, position).toString()).isEqualTo(disPlayMsg)
                .usingComparator(String::compareToIgnoreCase);
    }

    private static Stream<Arguments> provideNamePositionExpectedString() {
        return Stream.of(
                Arguments.of("pobi", new Position(1), "pobi:-"),
                Arguments.of("crong", new Position(0), "crong:"),
                Arguments.of("honux", new Position(2), "honux:--")
        );
    }

    private Car createCar(final String name, final Position position) {
        return new Car(new Name(name), new Energy(MIN_GAUGE), position);
    }

    @DisplayName("승자를 판별할수 있다.")
    @Test
    public void isWinner() {
        Car crong = createCar("crong", new Position(2));
        assertThat(car.isResult(crong)).isEqualTo(Lose);
        assertThat(crong.isResult(car)).isEqualTo(Win);
    }

    @DisplayName("결과 판별시 잘못된 값을 입력하면 에러가 발생한다.")
    @Test
    public void invalidIsResultParam() {
        assertThatThrownBy(() -> car.isResult(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
