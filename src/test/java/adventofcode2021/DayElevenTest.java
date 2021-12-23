package adventofcode2021;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class DayElevenTest {
    @Test
    void createBoard() {
        DayEleven dayEleven = new DayEleven(
                List.of(
                        "11111",
                        "19991",
                        "19191",
                        "19991",
                        "11111"
                )
        );

        assertThat(dayEleven).asString().isEqualTo(
                "11111\n"+
                "19991\n"+
                "19191\n"+
                "19991\n"+
                "11111\n"
        );
    }

    @Test
    void smallExampleFirstTwoSteps() {
        DayEleven dayEleven = new DayEleven(
                List.of(
                        "11111",
                        "19991",
                        "19191",
                        "19991",
                        "11111"
                ));

        dayEleven.step();

        assertThat(dayEleven).asString().isEqualTo(
                "34543\n"+
                "40004\n"+
                "50005\n"+
                "40004\n"+
                "34543\n");

        dayEleven.step();

        assertThat(dayEleven).asString().isEqualTo(
                "45654\n" +
                "51115\n" +
                "61116\n" +
                "51115\n" +
                "45654\n");
    }

    @Test
    void partOneLargerExample() {
        DayEleven dayEleven = new DayEleven(List.of(
        "5483143223",
        "2745854711",
        "5264556173",
        "6141336146",
        "6357385478",
        "4167524645",
        "2176841721",
        "6882881134",
        "4846848554",
        "5283751526"));

        dayEleven.step();
        //After step 1:
        assertThat(dayEleven).asString().isEqualTo(
        "6594254334\n"+
        "3856965822\n"+
        "6375667284\n"+
        "7252447257\n"+
        "7468496589\n"+
        "5278635756\n"+
        "3287952832\n"+
        "7993992245\n"+
        "5957959665\n"+
        "6394862637\n");

        //After step 2:
        dayEleven.step();
        assertThat(dayEleven).asString().isEqualTo(
        "8807476555\n"+
        "5089087054\n"+
        "8597889608\n"+
        "8485769600\n"+
        "8700908800\n"+
        "6600088989\n"+
        "6800005943\n"+
        "0000007456\n"+
        "9000000876\n"+
        "8700006848\n");

        //After step 3:
        dayEleven.step();
        assertThat(dayEleven).asString().isEqualTo(
        "0050900866\n"+
        "8500800575\n"+
        "9900000039\n"+
        "9700000041\n"+
        "9935080063\n"+
        "7712300000\n"+
        "7911250009\n"+
        "2211130000\n"+
        "0421125000\n"+
        "0021119000\n");

        //After step 4:
        dayEleven.step();
        assertThat(dayEleven).asString().isEqualTo(
        "2263031977\n"+
        "0923031697\n"+
        "0032221150\n"+
        "0041111163\n"+
        "0076191174\n"+
        "0053411122\n"+
        "0042361120\n"+
        "5532241122\n"+
        "1532247211\n"+
        "1132230211\n");

        //After step 5:
        dayEleven.step();
        assertThat(dayEleven).asString().isEqualTo(
        "4484144000\n"+
        "2044144000\n"+
        "2253333493\n"+
        "1152333274\n"+
        "1187303285\n"+
        "1164633233\n"+
        "1153472231\n"+
        "6643352233\n"+
        "2643358322\n"+
        "2243341322\n");

        //After step 10:
        IntStream.range(0,5).forEach(i->dayEleven.step());
        assertThat(dayEleven).asString().isEqualTo(
        "0481112976\n"+
        "0031112009\n"+
        "0041112504\n"+
        "0081111406\n"+
        "0099111306\n"+
        "0093511233\n"+
        "0442361130\n"+
        "5532252350\n"+
        "0532250600\n"+
        "0032240000\n");

        IntStream.range(0,90).forEach(i->dayEleven.step());
        assertThat(dayEleven.getFlashCount()).isEqualTo(1656);
        IntStream.range(0,100).forEach(i->dayEleven.step());
    }

    @Test
    void partOneSolution() {
        DayEleven dayEleven = new DayEleven(List.of(
                "6111821767",
                "1763611615",
                "3512683131",
                "8582771473",
                "8214813874",
                "2325823217",
                "2222482823",
                "5471356782",
                "3738671287",
                "8675226574"
        ));
        IntStream.range(0,100).forEach(i->dayEleven.step());
        assertThat(dayEleven.getFlashCount()).isEqualTo(1793);
        IntStream.range(0,500).forEach(i->dayEleven.step());
    }
}