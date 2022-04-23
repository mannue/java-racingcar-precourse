package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.Optional;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class PresenterTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("사용자가 쉼표를 기준으로 입력한 갯수만큼 Array 를 반환한다.")
    @ParameterizedTest
    @MethodSource("provideUserInput")
    public void sameInputSizeWithListSize(final String mockInput, final int expectedLength) {
        try (MockedStatic<Console> consoleMockedStatic = Mockito.mockStatic(Console.class)) {
            consoleMockedStatic.when(Console::readLine).thenReturn(mockInput);
            Optional<Name[]> isNames = Presenter.inputCarNames();
            assertThat(isNames.isPresent()).isTrue();
            assertThat(isNames.get().length).isEqualTo(expectedLength);
        }
    }

    private static Stream<Arguments> provideUserInput() {
        return Stream.of(
                Arguments.of("pobi,woni,jun", 3),
                Arguments.of("pobi",1)
        );
    }

    @DisplayName("사용자가 입력을 잘못하면 ERROR 메시지를 출력한다.")
    @Test
    public void invalidInputTest() {
        try (MockedStatic<Console> consoleMockedStatic = Mockito.mockStatic(Console.class)) {
            consoleMockedStatic.when(Console::readLine).thenReturn("");
            Presenter.inputCarNames();
            assertSimpleTest(() -> Assertions.assertThat(output()).contains(ERROR_MESSAGE));
        }
    }


    @Override
    protected void runMain() {
        Presenter.inputCarNames();
    }
}
