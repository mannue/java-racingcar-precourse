package racingcar;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Presenter {
    private static final String INPUT_DELIMITER = ",";
    private static final String INPUt_DISPLAY = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public static Optional<Name[]> inputCarNames() {
        try {
            return Optional.of(validationForCarName(readLine().split(INPUT_DELIMITER)));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return Optional.empty();
    }

    private static Name[] validationForCarName(final String[] names) {
        Set<Name> nameSet = new HashSet<>();
        for (String name : names) {
            nameSet.add(new Name((name)));
        }
        return nameSet.toArray(new Name[0]);
    }

    public static Optional<Integer> inputRacingTryCount() {
        try {
            return Optional.of(validationForTryCount());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return Optional.empty();
    }

    private static int validationForTryCount() {
        int racingCount = -1;
        try {
            racingCount = Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] input is invalid");
        }
        if (racingCount < 0) {
            throw new IllegalArgumentException("[ERROR] invalid racingCount is "+racingCount);
        }
        return racingCount;
    }

    public void disPlayPrintForInput() {
        System.out.println(INPUt_DISPLAY);
    }


}
