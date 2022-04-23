package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class PresenterTest {

    @DisplayName("사용자가 name 입력시 Array 반환")
    @Test
    public void inputTest() {
        String[] names = Presenter.inputCarNames();
        assertThat(names).isNotNull();
    }

    @DisplayName("사용자가 쉼표를 기준으로 입력한 갯수만큼 Array 를 반환한다.")
    @ParameterizedTest
    @MethodSource("provideUserInput")
    public void sameInputSizeWithListSize(final String mockInput, final int expectedLength) {
        try (MockedStatic<Console> consoleMockedStatic = Mockito.mockStatic(Console.class)) {
            consoleMockedStatic.when(Console::readLine).thenReturn(mockInput);
            String[] names = Presenter.inputCarNames();
            assertThat(names.length).isEqualTo(expectedLength);
        }
    }

    private static Stream<Arguments> provideUserInput() {
        return Stream.of(
                Arguments.of("pobi,woni,jun", 3),
                Arguments.of("pobi",1)
        );
    }
}
