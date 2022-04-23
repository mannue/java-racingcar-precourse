package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Presenter {
    private static final String INPUT_DELIMITER = ",";

    public static String[] inputCarNames() {
        return readLine().split(INPUT_DELIMITER);
    }
}
