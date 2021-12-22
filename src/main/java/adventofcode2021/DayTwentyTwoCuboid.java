package adventofcode2021;

import java.util.Objects;

public class DayTwentyTwoCuboid {

    private final boolean on;
    private final long maxX;
    private final long minY;
    private final long maxY;
    private final long minZ;
    private final long maxZ;
    private final long minX;

    @Override
    public String toString() {
        return "DayTwentyTwoCuboid{" +
                "on=" + on +
                ", minX=" + minX +
                ", maxX=" + maxX +
                ", minY=" + minY +
                ", maxY=" + maxY +
                ", minZ=" + minZ +
                ", maxZ=" + maxZ +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DayTwentyTwoCuboid that = (DayTwentyTwoCuboid) o;
        return on == that.on && maxX == that.maxX && minY == that.minY && maxY == that.maxY && minZ == that.minZ && maxZ == that.maxZ && minX == that.minX;
    }

    @Override
    public int hashCode() {
        return Objects.hash(on, maxX, minY, maxY, minZ, maxZ, minX);
    }

    public DayTwentyTwoCuboid(String onOrOff, long minX, long maxX, long minY, long maxY, long minZ, long maxZ) {
        on = onOrOff.equals("on");
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
        this.minZ = minZ;
        this.maxZ = maxZ;
    }

    public boolean intersects(DayTwentyTwoCuboid otherCuboid) {
        return otherCuboid.minX <= maxX &&
                otherCuboid.maxX >= minX &&
                otherCuboid.minY <= maxY &&
                otherCuboid.maxY >= minY &&
                otherCuboid.minZ <= maxZ &&
                otherCuboid.maxZ >= minZ;
    }

    public DayTwentyTwoCuboid intersection(DayTwentyTwoCuboid otherCuboid) {
        return new DayTwentyTwoCuboid(this.on?"off":"on", Math.max(minX, otherCuboid.minX),
                Math.min(maxX, otherCuboid.maxX), Math.max(minY, otherCuboid.minY),
                Math.min(maxY, otherCuboid.maxY), Math.max(minZ, otherCuboid.minZ),
                Math.min(maxZ, otherCuboid.maxZ));

    }

    public boolean isOn() {
        return on;
    }

    public long getVolume(){
        long volume = (maxX - minX + 1) * (maxY - minY + 1) * (maxZ - minZ + 1);
        return volume * (on ? 1L : -1L);
    }
}
