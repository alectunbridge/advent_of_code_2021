package adventofcode2021;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

class DayTwentyThreeTest {
    @Test
    void availableMoves() {
        DayTwentyThree dayTwentyThree = new DayTwentyThree(
                new String[]{
                       //01234567890
                        "...........",//0
                        "##B#C#B#D##",//1
                        "##A#D#C#A##"}//2
        );
        assertThat(dayTwentyThree.getAvailableMoves()).containsExactlyInAnyOrder(
                //B moves
                new int[]{2,1,0,0},
                new int[]{2,1,1,0},
                new int[]{2,1,3,0},
                new int[]{2,1,5,0},
                new int[]{2,1,7,0},
                new int[]{2,1,9,0},
                new int[]{2,1,10,0},
                //C moves
                new int[]{4,1,0,0},
                new int[]{4,1,1,0},
                new int[]{4,1,3,0},
                new int[]{4,1,5,0},
                new int[]{4,1,7,0},
                new int[]{4,1,9,0},
                new int[]{4,1,10,0}
        );
    }
}
