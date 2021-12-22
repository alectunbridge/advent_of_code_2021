package adventofcode2021;

import java.util.ArrayList;
import java.util.List;

public class DayTwentyTwo {

    private boolean[][][] cuboid;
    private final List<DayTwentyTwoInstruction> instructions = new ArrayList<>();

    public DayTwentyTwo(List<String> instructions) {
        cuboid = new boolean[101][101][101];
        for (String instruction: instructions) {
            String[] tokens = instruction.split(" ");
            String onOrOff = tokens[0];
            String[] xyzCoordsWithDots = tokens[1].replace("x=", "")
                    .replace("y=", "")
                    .replace("z=", "")
                    .split(",");

            int minX = Integer.parseInt(xyzCoordsWithDots[0].split("\\.\\.")[0]) + 50;
            int maxX = Integer.parseInt(xyzCoordsWithDots[0].split("\\.\\.")[1]) + 50;
            int minY = Integer.parseInt(xyzCoordsWithDots[1].split("\\.\\.")[0]) + 50;
            int maxY = Integer.parseInt(xyzCoordsWithDots[1].split("\\.\\.")[1]) + 50;
            int minZ = Integer.parseInt(xyzCoordsWithDots[2].split("\\.\\.")[0]) + 50;
            int maxZ = Integer.parseInt(xyzCoordsWithDots[2].split("\\.\\.")[1]) + 50;

            try {
                boolean min = cuboid[minX][minY][minZ];
                boolean max = cuboid[maxX][maxY][maxZ];
                this.instructions.add(new DayTwentyTwoInstruction(onOrOff, minX, maxX, minY, maxY, minZ, maxZ));
            } catch (ArrayIndexOutOfBoundsException e) {

            }
        }
    }

    public int countLitCubes() {
        int count = 0;

        for (int x = 0; x < 101; x++) {
            for (int y = 0; y < 101; y++) {
                for (int z = 0; z < 101; z++) {
                    if (cuboid[x][y][z]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public void followInstructions() {
        for (DayTwentyTwoInstruction instruction: instructions) {
            cuboid = instruction.execute(cuboid);
        }
    }
}
