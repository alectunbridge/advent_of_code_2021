package adventofcode2021;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DaySeventeenTest {

    @Test
    void examplePart1(){
        DaySeventeen daySeventeen = new DaySeventeen(20, 30, -10, -5);
        assertThat(daySeventeen.findHighestYValue()).isEqualTo(45);
    }


    @Test
    void solvePart1() {
        DaySeventeen daySeventeen = new DaySeventeen(150,193,-136,-86);
        assertThat(daySeventeen.findHighestYValue()).isEqualTo(9180);
    }


    @Test
    void plotTrajectory() {
        PositionAndVelocity positionAndVelocity0 = new PositionAndVelocity(0,0,7,2);
        PositionAndVelocity positionAndVelocity1 = new PositionAndVelocity(7, 2, 6, 1);
        PositionAndVelocity positionAndVelocity2 = new PositionAndVelocity(13, 3, 5, 0);
        PositionAndVelocity positionAndVelocity3 = new PositionAndVelocity(18, 3, 4, -1);
        PositionAndVelocity positionAndVelocity4 = new PositionAndVelocity(22, 2, 3, -2);

        assertThat(positionAndVelocity0.incrementPosition()).isEqualTo(positionAndVelocity1);
        assertThat(positionAndVelocity1.incrementPosition()).isEqualTo(positionAndVelocity2);
        assertThat(positionAndVelocity2.incrementPosition()).isEqualTo(positionAndVelocity3);
        assertThat(positionAndVelocity3.incrementPosition()).isEqualTo(positionAndVelocity4);
    }

    @Test
    void isHit() {
        DaySeventeen daySeventeen = new DaySeventeen(20,30,-10,-5);
        assertThat(daySeventeen.isHit(7,2)).isTrue();
        assertThat(daySeventeen.isHit(6,3)).isTrue();
        assertThat(daySeventeen.isHit(9,0)).isTrue();
        assertThat(daySeventeen.isHit(17,-4)).isFalse();
    }

    @Test
    void solveExamplePart2() {
        DaySeventeen daySeventeen = new DaySeventeen(20,30,-10,-5);
        assertThat(daySeventeen.solvePart2()).isEqualTo(112);
    }

    @Test
    void solvePart2() {
        DaySeventeen daySeventeen = new DaySeventeen(150,193,-136,-86);
        assertThat(daySeventeen.solvePart2()).isEqualTo(3767);
    }
}


