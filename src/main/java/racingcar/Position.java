package racingcar;

import java.util.Objects;

public class Position {
    private static final char DISPLAY_CHAR = '-';
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

    public Position move(int dist) {
        if (dist == 0) return this;
        return new Position(this.dist + dist);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=1; i <= dist; i++) {
            stringBuilder.append(DISPLAY_CHAR);
        }
        return stringBuilder.toString();
    }
}
