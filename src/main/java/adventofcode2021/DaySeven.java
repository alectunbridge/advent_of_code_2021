package adventofcode2021;

import java.util.List;
import java.util.stream.Collectors;

public class DaySeven {
    public int solve(List<String> input) {
        List<Integer> horizontalPositions = input.stream().map(Integer::parseInt).sorted().collect(Collectors.toList());
        int lowestFuelCost = Integer.MAX_VALUE;
        int bestPosition = Integer.MAX_VALUE;
        for (int position = horizontalPositions.get(0); position <= horizontalPositions.get(horizontalPositions.size()-1); position++) {
            int fuelCost = 0;
            for(int startingPosition:horizontalPositions){
                fuelCost += Math.abs(position - startingPosition);
            }
            if(fuelCost < lowestFuelCost){
                lowestFuelCost = fuelCost;
                bestPosition = position;
            }
        }
        return lowestFuelCost;
    }

    public int solvePart2(List<String> input) {
        List<Integer> horizontalPositions = input.stream().map(Integer::parseInt).sorted().collect(Collectors.toList());
        int lowestFuelCost = Integer.MAX_VALUE;
        int bestPosition = Integer.MAX_VALUE;
        for (int position = horizontalPositions.get(0); position <= horizontalPositions.get(horizontalPositions.size()-1); position++) {
            int fuelCost = 0;
            for(int startingPosition:horizontalPositions){
                int differenceInPositions = Math.abs(position - startingPosition);
                //forumla for summing series https://en.wikipedia.org/wiki/Arithmetic_progression
                int costForThisMove = 0;
                for (int i = 0; i <= differenceInPositions; i++) {
                    costForThisMove += i;
                }
                fuelCost += costForThisMove;
            }
            if(fuelCost < lowestFuelCost){
                lowestFuelCost = fuelCost;
                bestPosition = position;
            }
        }
        return lowestFuelCost;
    }
}
