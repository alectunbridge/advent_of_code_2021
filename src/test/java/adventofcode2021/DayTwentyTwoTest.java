package adventofcode2021;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DayTwentyTwoTest {

    @Test
    void part1Example() {
        DayTwentyTwo dayTwentyTwo = new DayTwentyTwo(Utils.readInputLinesFromFile("day_twenty_two_part_one_example.txt"));
        assertThat(dayTwentyTwo.countLitCubes()).isEqualTo(39);
    }

    @Test
    void part1LargeExample() {
        DayTwentyTwo dayTwentyTwo = new DayTwentyTwo(Utils.readInputLinesFromFile("day_twenty_two_part_one_large_example.txt"));
        assertThat(dayTwentyTwo.countLitCubes()).isEqualTo(590784);
    }

    @Test
    void part2Example() {
        DayTwentyTwo dayTwentyTwo = new DayTwentyTwo(Utils.readInputLinesFromFile("day_twenty_two_part_two_example.txt"));
        assertThat(dayTwentyTwo.countLitCubes()).isEqualTo(2758514936282235L);
    }

    @Test
    void part1() {
        DayTwentyTwo dayTwentyTwo = new DayTwentyTwo(Utils.readInputLinesFromFile("day_twenty_two_part_one.txt"));
        assertThat(dayTwentyTwo.countLitCubes()).isEqualTo(610196);
    }

    @Test
    void cuboidIntersection() {
        /*
on x=10..12,y=10..12,z=10..12
on x=11..13,y=11..13,z=11..13
off x=9..11,y=9..11,z=9..11
on x=10..10,y=10..10,z=10..10
         */
        DayTwentyTwoCuboid dayTwentyTwoCuboid1 = new DayTwentyTwoCuboid("on", 10, 12, 10, 12, 10, 12);
        DayTwentyTwoCuboid dayTwentyTwoCuboid2 = new DayTwentyTwoCuboid("on", 11, 13, 11, 13, 11, 13);
        DayTwentyTwoCuboid dayTwentyTwoCuboid3 = new DayTwentyTwoCuboid("on",  9, 11,  9, 11,  0, 11);
        DayTwentyTwoCuboid dayTwentyTwoCuboid4 = new DayTwentyTwoCuboid("on", 10, 10, 10, 10, 10, 10);

        assertThat(dayTwentyTwoCuboid1.intersects(dayTwentyTwoCuboid1)).isTrue();

        assertThat(dayTwentyTwoCuboid1.intersects(dayTwentyTwoCuboid2)).isTrue();
        assertThat(dayTwentyTwoCuboid2.intersects(dayTwentyTwoCuboid1)).isTrue();

        assertThat(dayTwentyTwoCuboid3.intersects(dayTwentyTwoCuboid1)).isTrue();
        assertThat(dayTwentyTwoCuboid3.intersects(dayTwentyTwoCuboid2)).isTrue();

        assertThat(dayTwentyTwoCuboid4.intersects(dayTwentyTwoCuboid1)).isTrue();
        assertThat(dayTwentyTwoCuboid4.intersects(dayTwentyTwoCuboid2)).isFalse();
        assertThat(dayTwentyTwoCuboid4.intersects(dayTwentyTwoCuboid3)).isTrue();
    }

    @Test
    void intersectionStartingWithOnCuboid() {
        DayTwentyTwoCuboid dayTwentyTwoCuboid1 = new DayTwentyTwoCuboid("on", 0, 6, 0, 6, 0, 6);
        DayTwentyTwoCuboid dayTwentyTwoCuboid2 = new DayTwentyTwoCuboid("on", 2, 4, 2, 4, 2, 4);

        assertThat(dayTwentyTwoCuboid1.intersects(dayTwentyTwoCuboid2)).isTrue();

        assertThat(dayTwentyTwoCuboid1.intersection(dayTwentyTwoCuboid2)).isEqualTo(new DayTwentyTwoCuboid("off", 2, 4, 2, 4, 2, 4));
    }

    @Test
    void intersectionStartingWithOffCuboid() {
        DayTwentyTwoCuboid dayTwentyTwoCuboid1 = new DayTwentyTwoCuboid("off", 0, 6, 0, 6, 0, 6);
        DayTwentyTwoCuboid dayTwentyTwoCuboid2 = new DayTwentyTwoCuboid("on", 2, 4, 2, 4, 2, 4);

        assertThat(dayTwentyTwoCuboid1.intersects(dayTwentyTwoCuboid2)).isTrue();

        assertThat(dayTwentyTwoCuboid1.intersection(dayTwentyTwoCuboid2)).isEqualTo(new DayTwentyTwoCuboid("on", 2, 4, 2, 4, 2, 4));
    }

    @Test
    void getVolume() {
        //on x=-5..47,y=-31..22,z=-19..33
        DayTwentyTwoCuboid dayTwentyTwoCuboid1 = new DayTwentyTwoCuboid("on", -5, 47, -31, 22, -19, 33);
        assertThat(dayTwentyTwoCuboid1.getVolume()).isEqualTo(53*54*53);
    }

    @Test
    void part2() {
        DayTwentyTwo dayTwentyTwo = new DayTwentyTwo(Utils.readInputLinesFromFile("day_twenty_two.txt"));
        assertThat(dayTwentyTwo.countLitCubes()).isEqualTo(1282401587270826L);
    }
}
