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
        Presenter.winnerPrint(eachPlay().winner());
    }

    private Cars eachPlay() {
        Cars cars = new Cars(createCars());
        for (int i = 0; !Objects.equals(racingCount, new RacingCount(i)); i++) {
            cars.play(this.generator);
            Presenter.disPlayCar(cars);
        }
        return cars;
    }

    private Car[] createCars() {
        Car[] cars = new Car[carNames.length];
        for (int i=0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i],energyGauge);
        }
        return cars;
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
