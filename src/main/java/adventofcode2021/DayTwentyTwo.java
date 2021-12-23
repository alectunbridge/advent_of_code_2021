package adventofcode2021;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

public class DayTwentyTwo {

    private  List<DayTwentyTwoCuboid> cuboids = new ArrayList<>();

    public DayTwentyTwo(List<String> input) {
        for (String line: input) {
            String[] tokens = line.split(" ");
            String onOrOff = tokens[0];
            String[] xyzCoordsWithDots = tokens[1].replace("x=", "")
                    .replace("y=", "")
                    .replace("z=", "")
                    .split(",");

            int minX = Integer.parseInt(xyzCoordsWithDots[0].split("\\.\\.")[0]);
            int maxX = Integer.parseInt(xyzCoordsWithDots[0].split("\\.\\.")[1]);
            int minY = Integer.parseInt(xyzCoordsWithDots[1].split("\\.\\.")[0]);
            int maxY = Integer.parseInt(xyzCoordsWithDots[1].split("\\.\\.")[1]);
            int minZ = Integer.parseInt(xyzCoordsWithDots[2].split("\\.\\.")[0]);
            int maxZ = Integer.parseInt(xyzCoordsWithDots[2].split("\\.\\.")[1]);


            DayTwentyTwoCuboid newCuboid = new DayTwentyTwoCuboid(onOrOff, minX, maxX, minY, maxY, minZ, maxZ);
            List<DayTwentyTwoCuboid> newCuboids = new ArrayList<>();
            for (DayTwentyTwoCuboid cuboid : cuboids) {
                if (cuboid.intersects(newCuboid)) {
                    newCuboids.add(cuboid.intersection(newCuboid));
                }
            }
            if(newCuboid.isOn()) {
                cuboids.add(newCuboid);
            }
            cuboids.addAll(newCuboids);
        }
    }

    public long countLitCubes() {
        long sum = 0L;
        for (DayTwentyTwoCuboid cuboid : cuboids) {
            long volume = cuboid.getVolume();
            sum += volume;
        }
        return sum;
    }

}
