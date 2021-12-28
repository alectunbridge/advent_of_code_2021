package adventofcode2021;

import org.junit.jupiter.api.Disabled;
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
                new int[]{2, 1, 0, 0},
                new int[]{2, 1, 1, 0},
                new int[]{2, 1, 3, 0},
                new int[]{2, 1, 5, 0},
                new int[]{2, 1, 7, 0},
                new int[]{2, 1, 9, 0},
                new int[]{2, 1, 10, 0},
                //C moves
                new int[]{4, 1, 0, 0},
                new int[]{4, 1, 1, 0},
                new int[]{4, 1, 3, 0},
                new int[]{4, 1, 5, 0},
                new int[]{4, 1, 7, 0},
                new int[]{4, 1, 9, 0},
                new int[]{4, 1, 10, 0},
                //more B moves
                new int[]{6, 1, 0, 0},
                new int[]{6, 1, 1, 0},
                new int[]{6, 1, 3, 0},
                new int[]{6, 1, 5, 0},
                new int[]{6, 1, 7, 0},
                new int[]{6, 1, 9, 0},
                new int[]{6, 1, 10, 0},
                //D moves
                new int[]{8, 1, 0, 0},
                new int[]{8, 1, 1, 0},
                new int[]{8, 1, 3, 0},
                new int[]{8, 1, 5, 0},
                new int[]{8, 1, 7, 0},
                new int[]{8, 1, 9, 0},
                new int[]{8, 1, 10, 0}
        );
    }

    @Test
    void availableMovesConsideringBurrows() {
        DayTwentyThree dayTwentyThree = new DayTwentyThree(
                new String[]{
                        //01234567890
                        "...B.......",//0
                        "##B#C#.#D##",//1
                        "##A#D#C#A##"}//2
        );

        assertThat(dayTwentyThree.getAvailableMoves()).containsExactlyInAnyOrder(
                //B moves
                new int[]{2, 1, 0, 0},
                new int[]{2, 1, 1, 0},

                //C moves
                new int[]{4, 1, 6, 1},
                new int[]{4, 1, 5, 0},
                new int[]{4, 1, 7, 0},
                new int[]{4, 1, 9, 0},
                new int[]{4, 1, 10, 0},

                //D moves
                new int[]{8, 1, 5, 0},
                new int[]{8, 1, 7, 0},
                new int[]{8, 1, 9, 0},
                new int[]{8, 1, 10, 0}
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

    @Test
    void test1() {
        DayTwentyThree dayTwentyThree = new DayTwentyThree(
                new String[]{
                        //01234567890
                        ".....D.....",//0
                        "##B#.#C#D##",//1
                        "##A#B#C#A##"}//2
        );
        assertThat(dayTwentyThree.getAvailableMoves()).containsExactlyInAnyOrder(
                //B moves
                new int[]{2, 1, 0, 0},
                new int[]{2, 1, 1, 0},
                new int[]{2, 1, 3, 0},
                new int[]{2, 1, 4, 1},

                //C moves

                //D moves
                new int[]{8, 1, 7, 0},
                new int[]{8, 1, 9, 0},
                new int[]{8, 1, 10, 0}
        );
    }

    @Test
    void test2() {
        DayTwentyThree dayTwentyThree = new DayTwentyThree(
                new String[]{
                        //01234567890
                        ".....D.....",//0
                        "##.#B#C#D##",//1
                        "##A#B#C#A##"}//2
        );
        assertThat(dayTwentyThree.getAvailableMoves()).containsExactlyInAnyOrder(
                //B moves

                //C moves

                //D moves
                new int[]{8, 1, 7, 0},
                new int[]{8, 1, 9, 0},
                new int[]{8, 1, 10, 0}
        );
    }

    @Test
    void test3() {
        DayTwentyThree dayTwentyThree = new DayTwentyThree(
                new String[]{
                        //01234567890
                        ".....D.D...",//0
                        "##.#B#C#.##",//1
                        "##A#B#C#A##"}//2
        );
        assertThat(dayTwentyThree.getAvailableMoves()).containsExactlyInAnyOrder(
                //A moves
                new int[]{8, 2, 9, 0},
                new int[]{8, 2, 10, 0}

                //B moves

                //C moves

                //D moves
        );
    }

    @Test
    void test4() {
        DayTwentyThree dayTwentyThree = new DayTwentyThree(
                new String[]{
                       //01234567890
                        ".....D.D.A.",//0
                        "##.#B#C#.##",//1
                        "##A#B#C#.##"}//2
        );
        assertThat(dayTwentyThree.getAvailableMoves()).containsExactlyInAnyOrder(
                //A moves


                //B moves

                //C moves

                //D moves
                new int[]{7, 0, 8, 2}
        );
    }

    @Test
    void test5() {
        DayTwentyThree dayTwentyThree = new DayTwentyThree(
                new String[]{
                        //01234567890
                        ".....D...A.",//0
                        "##.#B#C#.##",//1
                        "##A#B#C#D##"}//2
        );
        assertThat(dayTwentyThree.getAvailableMoves()).containsExactlyInAnyOrder(
                //A moves

                //B moves

                //C moves

                //D moves
                new int[]{5, 0, 8, 1}
        );
    }

    @Test
    void test6() {
        DayTwentyThree dayTwentyThree = new DayTwentyThree(
                new String[]{
                        //01234567890
                        ".........A.",//0
                        "##.#B#C#D##",//1
                        "##A#B#C#D##"}//2
        );
        assertThat(dayTwentyThree.getAvailableMoves()).containsExactlyInAnyOrder(
                //A moves
                new int[]{9, 0, 2, 1}

                //B moves

                //C moves

                //D moves
        );
    }

    @Test
    void test7() {
        DayTwentyThree dayTwentyThree = new DayTwentyThree(
                new String[]{
                        //01234567890
                        "...........",//0
                        "##A#B#C#D##",//1
                        "##A#B#C#D##"}//2
        );
        assertThat(dayTwentyThree.getAvailableMoves()).isEmpty();
    }

    @Test
    void calculateMoveCosts() {
        DayTwentyThree dayTwentyThree = new DayTwentyThree(new String[0]);
        assertThat(dayTwentyThree.getMoveCost('A', new int[]{9, 0, 2, 1})).isEqualTo(8);
        assertThat(dayTwentyThree.getMoveCost('B', new int[]{2, 1, 0, 0})).isEqualTo(30);
        assertThat(dayTwentyThree.getMoveCost('C', new int[]{4, 1, 6, 1})).isEqualTo(400);
        assertThat(dayTwentyThree.getMoveCost('D', new int[]{8, 1, 7, 0})).isEqualTo(2000);
    }

    @Test
    void makeMove1() {
        DayTwentyThree startState = new DayTwentyThree(
                new String[]{
                        //01234567890
                        "...........",//0
                        "##B#C#B#D##",//1
                        "##A#D#C#A##"}//2
        );

        DayTwentyThree endState = new DayTwentyThree(
                new String[]{
                        //01234567890
                        "...B.......",//0
                        "##B#C#.#D##",//1
                        "##A#D#C#A##"}//2
                , 40
        );

        assertThat(startState.makeMove(6, 1, 3, 0)).isEqualTo(endState);
    }

    @Test
    void makeMove2() {
        DayTwentyThree startState = new DayTwentyThree(
                new String[]{
                       //01234567890
                        "...B.......",//0
                        "##B#C#.#D##",//1
                        "##A#D#C#A##"}//2
                , 40
        );

        DayTwentyThree endState = new DayTwentyThree(
                new String[]{
                       //01234567890
                        "...B.......",//0
                        "##B#.#C#D##",//1
                        "##A#D#C#A##"}//2
                , 440
        );
        assertThat(startState.makeMove(4, 1, 6, 1)).isEqualTo(endState);
    }

    @Test
    void makeMove3() {
        DayTwentyThree startState = new DayTwentyThree(
                new String[]{
                       //01234567890
                        "...B.......",//0
                        "##B#.#C#D##",//1
                        "##A#D#C#A##"}//2
                , 440
        );

        DayTwentyThree endState = new DayTwentyThree(
                new String[]{
                       //01234567890
                        "...........",//0
                        "##A#B#C#D##",//1
                        "##A#B#C#D##"}//2
                , 12521
        );
        assertThat(startState
                .makeMove(4, 2, 5, 0)
                .makeMove(3, 0, 4, 2)
                .makeMove(2, 1, 4, 1)
                .makeMove(8, 1, 7, 0)
                .makeMove(8, 2, 9, 0)

                .makeMove(7, 0, 8, 2)
                .makeMove(5, 0, 8, 1)
                .makeMove(9, 0, 2, 1)
        ).isEqualTo(endState);
    }

    @Test
    void solvePartOneExample(){
        DayTwentyThree dayTwentyThree = new DayTwentyThree(
                new String[]{
                       //01234567890
                        "...........",//0
                        "##B#C#B#D##",//1
                        "##A#D#C#A##"}//2
        );

        assertThat(dayTwentyThree.findMinimumCostToSolve()).isEqualTo(12521);
    }

    @Test
    @Disabled
    void solvePartOne() {
        DayTwentyThree dayTwentyThree = new DayTwentyThree(
                new String[]{
                        "...........",
                        "##A#D#C#A##",
                        "##C#D#B#B##"
                }
        );
        assertThat(dayTwentyThree.findMinimumCostToSolve()).isEqualTo(15365);
        System.out.println(DayTwentyThree.getMoveCount());
    }

    @Test
    @Disabled
    void solvePartTwoExample() {
        DayTwentyThree dayTwentyThree = new DayTwentyThree(
                new String[]{
                        //01234567890
                        "...........",//0
                        "##B#C#B#D##",//1
                        "##D#C#B#A##",//2
                        "##D#B#A#C##",//3
                        "##A#D#C#A##"}//4
        );

        int minimumCostToSolve = dayTwentyThree.findMinimumCostToSolve();
        assertThat(minimumCostToSolve).isEqualTo(44169);
        System.out.println(DayTwentyThree.getMoveCount());
    }

    @Test
    @Disabled
    void solvePartTwo() {
        DayTwentyThree dayTwentyThree = new DayTwentyThree(
                new String[]{
                        //01234567890
                        "...........",//0
                        "##A#D#C#A##",
                        "##D#C#B#A##",//2
                        "##D#B#A#C##",//3
                        "##C#D#B#B##"}//4
        );

        int minimumCostToSolve = dayTwentyThree.findMinimumCostToSolve();
        assertThat(minimumCostToSolve).isGreaterThan(47065);
        System.out.println(DayTwentyThree.getMoveCount());
    }
}
