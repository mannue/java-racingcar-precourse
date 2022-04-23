package racingcar;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Presenter {
    private static final String INPUT_DELIMITER = ",";
    private static final String INPUt_DISPLAY = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public static Optional<Name[]> inputCarNames() {
        try {
            return Optional.of(validationInput(readLine().split(INPUT_DELIMITER)));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return Optional.empty();
    }

    private static Name[] validationInput(final String[] names) {
        Set<Name> nameSet = new HashSet<>();
        for (String name : names) {
            nameSet.add(new Name((name)));
        }
        return nameSet.toArray(new Name[0]);
    }

    public static Optional<Integer> inputRacingTryCount() {
        return Optional.of(Integer.parseInt(readLine()));
    }

    public void disPlayPrintForInput() {
        System.out.println(INPUt_DISPLAY);
    }


}
