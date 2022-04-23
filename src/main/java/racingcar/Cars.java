package racingcar;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class Cars {
    private List<Car> carList = new ArrayList<>();
    private Queue<Car> queue = new LinkedBlockingQueue<>();

    public Cars(Car... cars) {
        carList.addAll(Arrays.asList(cars));
    }


    public boolean isNumberOfParticipants(final int number) {
        return Objects.equals(carList.size(), number);
    }

    public void play(EnergyGenerator energyGenerator) {
        validationParam(energyGenerator);
        for (Car car : carList) {
            car.move(energyGenerator.create());
        }
    }

    private void validationParam(Object obj) {
        if (Objects.isNull(obj)) {
            throw new IllegalArgumentException("[ERROR] energyGenerator is null");
        }
    }

    public Car[] winner() {
        queue.add(carList.remove(0));
        carList.forEach(this::compare);
        return queue.toArray(new Car[0]);
    }

    private void compare(final Car target) {
        Car source = queue.peek();
        RacingResult result = source.isMatchResult(target);
        if (RacingResult.isWin(result)) {
            return ;
        }
        if (RacingResult.isLose(result)) {
            queue.clear();
        }
        queue.add(target);
    }
}
