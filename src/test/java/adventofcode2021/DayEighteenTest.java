package adventofcode2021;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
public class DayEighteenTest {

    @Test
    void addSnailFish() {
        DayEighteen dayEighteen = new DayEighteen(List.of(
                "[1,2]",
                "[[3,4],5]"
        ));
        assertThat(dayEighteen.solvePart1()).isEqualTo("[[1,2],[[3,4],5]]");
    }

    @Test
    void explodeRight() {
        DayEighteen dayEighteen = new DayEighteen(List.of(
                "[[[[9,8],1],2],3]"
                ,"4"));
        assertThat(dayEighteen.solvePart1()).isEqualTo("[[[[0,9],2],3],4]");
    }

    @Test
    void explodeLeft() {
        DayEighteen dayEighteen = new DayEighteen(List.of(
                "7",
                "[6,[5,[4,[3,2]]]]"));
        assertThat(dayEighteen.solvePart1()).isEqualTo("[7,[6,[5,[7,0]]]]");
    }
    
    @Test
    void explodeLeftAndRight() {
        DayEighteen dayEighteen = new DayEighteen(List.of(
            "[6,[5,[4,[3,2]]]]",
            "1"));
        assertThat(dayEighteen.solvePart1()).isEqualTo("[[6,[5,[7,0]]],3]");
    }

    @Test
    void explodeMultipleMatches(){
        DayEighteen dayEighteen = new DayEighteen(List.of(
            "[3,[2,[1,[7,3]]]]",
            "[6,[5,[4,[3,2]]]]"
        ));
        assertThat(dayEighteen.solvePart1()).isEqualTo("[[3,[2,[8,0]]],[9,[5,[4,[3,2]]]]]");
    }

    @Test
    void explodeMatchAtEnd(){
        DayEighteen dayEighteen = new DayEighteen(List.of(
            "[3,[2,[8,0]]]",
            "[9,[5,[4,[3,2]]]]"
        ));
        assertThat(dayEighteen.solvePart1()).isEqualTo("[[3,[2,[8,0]]],[9,[5,[7,0]]]]");
    }
}
