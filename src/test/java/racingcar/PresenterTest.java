package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class PresenterTest {

    @DisplayName("사용자가 name 입력시 Array 반환")
    @Test
    public void inputTest() {
        String[] names = Presenter.inputCarNames();
        assertThat(names).isNotNull();
    }

    @DisplayName("사용자가 쉼표를 기준으로 입력한 갯수만큼 Array 를 반환한다.")
    @Test
    public void sameInputSizeWithListSize() {
        String[] mockInput = {"pobi","crong","honux"};
        try (MockedStatic<Console> consoleMockedStatic = Mockito.mockStatic(Console.class)) {
            consoleMockedStatic.when(Console::readLine).thenReturn(String.join(",", mockInput));
            String[] names = Presenter.inputCarNames();
            assertThat(names.length).isEqualTo(mockInput.length);
        }

    }
}
