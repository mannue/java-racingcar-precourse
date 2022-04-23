package racingcar;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Presenter {
    private static final String INPUT_DELIMITER = ",";

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
}
