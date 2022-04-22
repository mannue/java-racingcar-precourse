package racingcar;

public class Engine {
    private final Energy energyGauge;

    public Engine(final int energyGauge) {
        this.energyGauge = new Energy(energyGauge);
    }
}
