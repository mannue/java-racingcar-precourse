package racingcar;

import java.util.Objects;

public class Car {
    private final String name;
    private final Energy minGauge;
    private Position startPosition;

    public Car(final String name, final Energy minGauge) {
        this(name, minGauge, new Position(0));
    }

    public Car(final String name, final Energy minGauge, final Position startPosition) {
        this.name = name;
        this.minGauge = minGauge;
        this.startPosition = startPosition;
    }

    public boolean isMove(Energy energy) {
        paramValidation(energy);
        if (energy.compareTo(minGauge) < 0) {
            return false;
        }
        this.startPosition = this.startPosition.move(1);
        return true;
    }

    private void paramValidation(Energy energy) {
        if (Objects.isNull(energy)) {
            throw new IllegalArgumentException("[ERROR] input is null");
        }
    }
}
