package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Cars {
    private List<Car> carList = new ArrayList<>();
    public Cars(Car... cars) {
        carList.addAll(Arrays.asList(cars));
    }


    public boolean isNumberOfParticipants(final int number) {
        return Objects.equals(carList.size(), number);
    }

    public void play(EnergyGenerator energyGenerator) {
        for (Car car : carList) {
            car.move(energyGenerator.create());
        }
    }
}
