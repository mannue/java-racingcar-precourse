package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class EnergyGenerator {
    private final int min;
    private final int max;
    public EnergyGenerator(final int min, final int max) {
        validation(min, max);
        this.min = min;
        this.max = max;
    }

    private void validation(final int min , final int max) {
        if (min >= max) {
            throw new IllegalArgumentException("[ERROR] invalid ranges");
        }
    }
    public Energy[] create(final int number) {
        Energy[] energyBox = new Energy[number];
        for (int i=0; i < number; i++) {
            energyBox[i] = new Energy(pickNumberInRange(this.min, this.max));
        }
        return energyBox;
    }
}