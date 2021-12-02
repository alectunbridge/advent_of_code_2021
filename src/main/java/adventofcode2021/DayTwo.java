package adventofcode2021;

import java.util.List;

public class DayTwo {

    public int process(List<String> input) {

        int horizontal = 0;
        int depth = 0;
        for (String line : input) {
            String[] tokens = line.split(" ");
            String direction = tokens[0];
            int movement = Integer.parseInt(tokens[1]);

            if (direction.equals("forward")) {
                horizontal += movement;
            } else if(direction.equals("down")){
                depth += movement;
            } else if (direction.equals("up")){
                depth -= movement;
            } else {
                throw new RuntimeException("well this is a surprise!");
            }

        }
        return horizontal * depth;
    }

    public int processTwo(List<String> input) {

        int horizontal = 0;
        int depth = 0;
        int aim = 0;
        for (String line : input) {
            String[] tokens = line.split(" ");
            String direction = tokens[0];
            int movement = Integer.parseInt(tokens[1]);

            if (direction.equals("forward")) {
                horizontal += movement;
                depth += aim * movement;
            } else if(direction.equals("down")){
                aim += movement;
            } else if (direction.equals("up")){
                aim -= movement;
            } else {
                throw new RuntimeException("well this is a surprise!");
            }

        }
        return horizontal * depth;
    }
}
