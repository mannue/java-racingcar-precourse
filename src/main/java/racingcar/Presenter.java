package racingcar;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Presenter {
    private static final String INPUT_DELIMITER = ",";
    private static final String INPUT_DISPLAY_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_DISPLAY_COUNT = "시도할회수";

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

    public static Optional<RacingCount> inputRacingCount() {
        try {
            return Optional.of(validationForTryCount());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return Optional.empty();
    }

    private static RacingCount validationForTryCount() {
        try {
            return new RacingCount(Integer.parseInt(readLine()));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] input is invalid");
        }
    }

    public void disPlayPrintForName() {
        System.out.println(INPUT_DISPLAY_NAME);
    }

    public void disPlayPrintForTryCount() {
        System.out.println(INPUT_DISPLAY_COUNT);
    }

    public static void winnerPrint(Name[] winners) {
        System.out.print("최종 우승자: "+String.join(",", Arrays.toString(winners)));
    }
}
