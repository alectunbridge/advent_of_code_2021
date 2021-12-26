package adventofcode2021;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

class DayTwentyThreeTest {
    @Test
    void availableMovesFromStartState() {
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
                new int[]{4,1,10,0},
                //more B moves
                new int[]{6,1,0,0},
                new int[]{6,1,1,0},
                new int[]{6,1,3,0},
                new int[]{6,1,5,0},
                new int[]{6,1,7,0},
                new int[]{6,1,9,0},
                new int[]{6,1,10,0},
                //D moves
                new int[]{8,1,0,0},
                new int[]{8,1,1,0},
                new int[]{8,1,3,0},
                new int[]{8,1,5,0},
                new int[]{8,1,7,0},
                new int[]{8,1,9,0},
                new int[]{8,1,10,0}
        );
    }

    @Test
    void availableMovesConsideringBurrows(){
        DayTwentyThree dayTwentyThree = new DayTwentyThree(
                new String[]{
                       //01234567890
                        "...B.......",//0
                        "##B#C#.#D##",//1
                        "##A#D#C#A##"}//2
        );

        assertThat(dayTwentyThree.getAvailableMoves()).containsExactlyInAnyOrder(
                //B moves
                new int[]{2,1,0,0},
                new int[]{2,1,1,0},

                //C moves
                new int[]{4,1,6,1},
                new int[]{4,1,5,0},
                new int[]{4,1,7,0},
                new int[]{4,1,9,0},
                new int[]{4,1,10,0},

                //D moves
                new int[]{8,1,5,0},
                new int[]{8,1,7,0},
                new int[]{8,1,9,0},
                new int[]{8,1,10,0}
        );
    }

    @Test
    void availableMovesDisallowIncorrectBurrows() {
        DayTwentyThree dayTwentyThree = new DayTwentyThree(
                new String[]{
                       //01234567890
                        "...B.......",//0
                        "##B#.#C#D##",//1
                        "##A#D#C#A##"}//2
        );
        assertThat(dayTwentyThree.getAvailableMoves()).containsExactlyInAnyOrder(
                //B moves
                new int[]{2, 1, 0, 0},
                new int[]{2, 1, 1, 0},

                //C moves

                //D moves
                new int[]{4, 2, 5, 0},
                new int[]{4, 2, 7, 0},
                new int[]{4, 2, 9, 0},
                new int[]{4, 2, 10, 0},

                new int[]{8, 1, 5, 0},
                new int[]{8, 1, 7, 0},
                new int[]{8, 1, 9, 0},
                new int[]{8, 1, 10, 0}
        );
    }

    @Test
    void availableMovesFromHallway() {
        DayTwentyThree dayTwentyThree = new DayTwentyThree(
                new String[]{
                       //01234567890
                        "...B.D.....",//0
                        "##B#.#C#D##",//1
                        "##A#.#C#A##"}//2
        );
        assertThat(dayTwentyThree.getAvailableMoves()).containsExactlyInAnyOrder(
                //B moves
                new int[]{2, 1, 0, 0},
                new int[]{2, 1, 1, 0},
                new int[]{3, 0, 4, 2},

                //C moves

                //D moves
                new int[]{8, 1, 7, 0},
                new int[]{8, 1, 9, 0},
                new int[]{8, 1, 10, 0}
        );
    }
}
