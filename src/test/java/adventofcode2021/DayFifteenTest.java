package adventofcode2021;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DayFifteenTest {


    @Test
    void part1Example() {
        DayFifteen dayFifteen = new DayFifteen("day_fifteen_example_part1.txt");
        assertThat(dayFifteen.solvePart1()).isEqualTo(40);
    }

    @Test
    void part1() {
        DayFifteen dayFifteen = new DayFifteen("day_fifteen.txt");
        assertThat(dayFifteen.solvePart1()).isEqualTo(498);
    }

    @Test
    void part2ExpandGrid(){
        int[][] grid = {
            {0,9},
            {2,3}
        };
        int[][] expectedGrid = {
            {0,9,1,1},
            {2,3,3,4},
            {1,1,2,2},
            {3,4,4,5}
        };

        int[][] expandedGrid = DayFifteen.expandGrid(grid, 2);
        assertThat(expandedGrid).isEqualTo(expectedGrid);
    }

    @Test
    void part2(){
        List<String> lines = Utils.readInputLinesFromFile("day_fifteen.txt");
        int[][] startRisks = new int[lines.size()][lines.size()];
        for (int i = 0; i < lines.size(); i++) {
            for (int j = 0; j < lines.size(); j++) {
                startRisks[i][j] = Integer.parseInt(String.valueOf(lines.get(i).charAt(j)));
            }
        }

        int[][] expandedGrid = DayFifteen.expandGrid(startRisks, 5);

        List<String> expandedInput = new ArrayList<>();
    
        for (int i = 0; i < expandedGrid.length; i++) {
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < expandedGrid.length; j++) {
                line.append(expandedGrid[i][j]);
            }
            expandedInput.add(line.toString());
        }
       // assertThat(expandedInput).isEqualTo(Utils.readInputLinesFromFile("day_fifteen_example_part2.txt"));

        DayFifteen dayFifteen = new DayFifteen(expandedInput);
        assertThat(dayFifteen.solvePart1()).isEqualTo(2901);
    }
}
