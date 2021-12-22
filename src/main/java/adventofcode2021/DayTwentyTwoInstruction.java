package adventofcode2021;

public class DayTwentyTwoInstruction {

    private final boolean on;
    private final int maxX;
    private final int minY;
    private final int maxY;
    private final int minZ;
    private final int maxZ;
    private final int minX;

    public DayTwentyTwoInstruction(String onOrOff, int minX, int maxX, int minY, int maxY, int minZ, int maxZ) {
        on = onOrOff.equals("on");
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
        this.minZ = minZ;
        this.maxZ = maxZ;
    }

    public boolean[][][] execute(boolean[][][] cuboid) {
        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                for (int z = minZ; z <= maxZ; z++) {
                    cuboid[x][y][z] = on;
                }
            }
        }
        return cuboid;
    }
}
