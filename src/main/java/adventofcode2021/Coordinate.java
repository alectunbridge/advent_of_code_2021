package adventofcode2021;

import java.util.Objects;

public class Coordinate {

    private final int row;
    private final int column;
    private int height;
    private int area;

    public Coordinate(int row, int column, int height) {
        this.row = row;
        this.column = column;
        this.height = height;
    }

    public Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getHeight() {
        return height;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getArea() {
        return area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return row == that.row && column == that.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
