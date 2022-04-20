package racingcar;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.Objects;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Energy {
    final int MIN = 0;
    final int MAX = 9;
    final int value;

    public Energy(final int value) {
        validation(value);
        this.value = value;
    }

    private void validation(final int value) {
        if (value < MIN || value > MAX) {
            throw new IllegalArgumentException();
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Energy energy = (Energy) o;
        return value == energy.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
