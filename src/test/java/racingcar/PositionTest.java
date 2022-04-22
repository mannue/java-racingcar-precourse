package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class PositionTest {
    private Position zero;
    @BeforeEach
    public void setUp() {
        zero = new Position(0);
    }
    @DisplayName("Position 는 VO 객체다")
    @Test
    public void createTest() {
        assertThat(zero).isEqualTo(new Position(0));
        assertThat(zero).isNotEqualTo(new Position(1));
    }

    @DisplayName("move 호출시 입력한 정보에 따라 새로운 Position 객체를 리턴한다")
    @Test
    public void moveTest() {
        assertThat(zero.move(0)).isEqualTo(zero);
        Position one = zero.move(1);
        assertThat(one).isEqualTo(new Position(1));
        Position two = one.move(1);
        assertThat(two).isEqualTo(new Position(2));
    }
}
