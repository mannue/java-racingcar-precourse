package racingcar;

import java.util.Objects;
import java.util.Optional;

public class RacingService {
    private final Energy energyGauge = RacingConfig.getDefaultEnergyGauge();
    private final EnergyGenerator generator;
    private Name[] carNames;
    private RacingCount racingCount;

    public RacingService() {
        this.generator = new EnergyGenerator(RacingConfig.getMinRandom(),RacingConfig.getMaxRandom());
    }

    public void userInput() {
        Presenter.disPlayPrintForName();
        carNames = waitValidCarNames();
        Presenter.disPlayPrintForTryCount();
        racingCount = waitValidTryCount();
    }

    public void play() {
        Presenter.disPlayResult();
        Cars cars = createCars();
        start(cars);
        Presenter.winnerPrint(cars.winner());
    }

    private void start(final Cars cars) {
        try {
            eachPlay(cars);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    private void eachPlay(final Cars cars) {
       do {
            racingCount = racingCount.decrease();
            cars.play(this.generator);
            Presenter.disPlayCar(cars);
        } while (true);
    }

    private Cars createCars() {
        Car[] cars = new Car[carNames.length];
        for (int i=0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i],energyGauge);
        }
        return new Cars(cars);
    }

    private Name[] waitValidCarNames() {
        while (true){
            Optional<Name[]> isValidNames = Presenter.inputCarNames();
            if (isValidNames.isPresent()) {
               return isValidNames.get();
            }
        }
    }

    private RacingCount waitValidTryCount() {
        while (true){
            Optional<RacingCount> isValidRacingCount = Presenter.inputRacingCount();
            if (isValidRacingCount.isPresent()) {
                return isValidRacingCount.get();
            }
        }
    }

}
