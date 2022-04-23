package racingcar;

import java.util.Objects;

import static racingcar.RacingResult.*;

public class Car{
    private final Name name;
    private final Energy minGauge;
    private Position startPosition;

    public Car(final Name name, final Energy minGauge) {
        this(name, minGauge, new Position(0));
    }

    public Car(final Name name, final Energy minGauge, final Position startPosition) {
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

    @Override
    public String toString() {
        return String.format("%s:%s",this.name,this.startPosition);
    }

    public Name getName() {
        return name;
    }

    public RacingResult isResult(Car target) {
        paramValidation(target);
        final int diffPosition = target.compareBy(this.startPosition);
        if (diffPosition == 0) {
            return Draw;
        }
        if (diffPosition > 0) {
            return Win;
        }
        return Lose;
    }

    private void paramValidation(Object input) {
        if (Objects.isNull(input)) {
            throw new IllegalArgumentException("[ERROR] input is null");
        }
    }

    private int compareBy(Position sourcePosition) {
        return sourcePosition.compareTo(this.startPosition);
    }
}
