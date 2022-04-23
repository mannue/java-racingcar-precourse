package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Presenter {
    public static String[] inputCarNames() {
        return readLine().split(",");
    }
}
