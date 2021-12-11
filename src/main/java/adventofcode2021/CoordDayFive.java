package adventofcode2021;

import java.util.Objects;

public class CoordDayFive {
    private final int y;
    private final int x;

    public CoordDayFive(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoordDayFive that = (CoordDayFive) o;
        return y == that.y && x == that.x;
    }

    @Override
    public int hashCode() {
        return Objects.hash(y, x);
    }
}
