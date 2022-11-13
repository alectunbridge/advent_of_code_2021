package adventofcode2021;

import java.util.Objects;

public class CoordDayFifteen {
    public final int x,y;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoordDayFifteen that = (CoordDayFifteen) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public CoordDayFifteen(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public CoordDayFifteen moveRight() {
        return new CoordDayFifteen(x + 1, y);
    }

    public CoordDayFifteen moveDown() {
        return new CoordDayFifteen(x,y+1);
    }

    public CoordDayFifteen moveLeft() {
        return new CoordDayFifteen(x-1,y);
    }

    public CoordDayFifteen moveUp() {
        return new CoordDayFifteen(x,y-1);
    }
}
