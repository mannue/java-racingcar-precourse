package racingcar;

public class Engine {
    private final Energy energyGauge;

    public Engine(final int energyGauge) {
        this.energyGauge = new Energy(energyGauge);
    }


    public boolean isWorking(final Energy push) {
        return push.compareTo(energyGauge) >= 0;
    }
}
