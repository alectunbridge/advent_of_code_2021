package adventofcode2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DayFive {

    private final List<CoordDayFive> coordinates = new ArrayList<>();

    public DayFive(List<String> input) {
        for (String line : input) {
            String[] inputCoords = line.split(" -> ");
            int[] startCoords = Arrays.stream(inputCoords[0].split(",")).mapToInt(Integer::parseInt).toArray();
            int[] endCoords = Arrays.stream(inputCoords[1].split(",")).mapToInt(Integer::parseInt).toArray();
            coordinates.addAll(generateCoords(startCoords, endCoords));
        }
    }

    private List<CoordDayFive> generateCoords(int[] startCoords, int[] endCoords) {
        List<CoordDayFive> result = new ArrayList<>();
        if(startCoords[0] == endCoords[0]){
            int xCoord = startCoords[0];
            int smallestY = Integer.min(startCoords[1], endCoords[1]);
            int largestY = Integer.max(startCoords[1], endCoords[1]);
            for(int i = smallestY; i <= largestY; i++){
                result.add(new CoordDayFive(xCoord, i));
            }
        }
        if(startCoords[1] == endCoords[1]){
            int yCoord = startCoords[1];
            int smallestX = Integer.min(startCoords[0], endCoords[0]);
            int largestX = Integer.max(startCoords[0], endCoords[0]);
            for(int i = smallestX; i <= largestX; i++){
                result.add(new CoordDayFive(i, yCoord));
            }
        }
        return result;
    }

    public int solvePart1() {
        Map<CoordDayFive, Long> countOfCoords = coordinates.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return (int) countOfCoords.values().stream().filter(x -> x > 1).count();
    }
}
