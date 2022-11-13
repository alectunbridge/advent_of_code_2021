package adventofcode2021;

import java.util.Objects;

public class CoordDayFifteen extends Node {
    public final int x,y;
    public final int risk;




    public CoordDayFifteen(int x, int y, int risk) {
        this.x = x;
        this.y = y;
        this.risk = risk;

    }


    @Override
    public String toString() {
        return "CoordDayFifteen{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
