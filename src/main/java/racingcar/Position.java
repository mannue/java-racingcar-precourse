package racingcar;

import java.util.Objects;

public class Position {
    private final int dist;
    public Position(final int dist) {
        this.dist = dist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return dist == position.dist;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dist);
    }
}
