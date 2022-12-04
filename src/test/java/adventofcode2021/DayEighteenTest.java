package adventofcode2021;

import org.junit.jupiter.api.Disabled;
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
    @Disabled
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

    @Test
    @Disabled
    void split(){
        DayEighteen dayEighteen = new DayEighteen(List.of(
            "[[[0,7],4],[15,[0,13]]]",
            "[1,1]"
        ));
        assertThat(dayEighteen.solvePart1()).isEqualTo("[[[[0,7],4],[[7,8],[0,13]]],[1,1]]");
    }

    @Test
    void reductionSmallExample(){
        DayEighteen dayEighteen = new DayEighteen(List.of(
            "[[[[4,3],4],4],[7,[[8,4],9]]]",
            "[1,1]" 
        ));
        assertThat(dayEighteen.solvePart1()).isEqualTo("[[[[0,7],4],[[7,8],[6,0]]],[8,1]]");
    }

    @Test
    void reductionLargeExample(){
        DayEighteen dayEighteen = new DayEighteen(List.of(
            "[[[0,[4,5]],[0,0]],[[[4,5],[2,6]],[9,5]]]",
            "[7,[[[3,7],[4,3]],[[6,3],[8,8]]]]",
            "[[2,[[0,8],[3,4]]],[[[6,7],1],[7,[1,6]]]]",
            "[[[[2,4],7],[6,[0,5]]],[[[6,8],[2,8]],[[2,1],[4,5]]]]",
            "[7,[5,[[3,8],[1,4]]]]",
            "[[2,[2,2]],[8,[8,1]]]",
            "[2,9]",
            "[1,[[[9,3],9],[[9,0],[0,7]]]]",
            "[[[5,[7,4]],7],1]",
            "[[[[4,2],2],6],[8,7]]"
        ));
        assertThat(dayEighteen.solvePart1()).isEqualTo("[[[[8,7],[7,7]],[[8,6],[7,7]]],[[[0,7],[6,6]],[8,7]]]");
    }
}
