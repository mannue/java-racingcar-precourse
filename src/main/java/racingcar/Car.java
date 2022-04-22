package racingcar;

public class Car {
    private final String name;
    private final Energy minGauge;

    public Car(final String name, final Energy minGauge) {
        this.name = name;
        this.minGauge = minGauge;
    }
}
