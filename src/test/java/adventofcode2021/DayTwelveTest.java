package adventofcode2021;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class DayTwelveTest {

    @Test
    void parse() {

        DayTwelve dayTwelve = new DayTwelve(List.of(
                "start-A",
                "start-b",
                "A-end",
                "A-c",
                "A-b",
                "b-d",
                "b-end"));

        Map<String, Set<String>> expectedEdges = Map.of(
                "start", Set.of("A", "b"),
                "A", Set.of("end", "c", "b"),
                "b", Set.of("d", "end", "A"),
                "c", Set.of("A"),
                "d", Set.of("b"));

        assertThat(dayTwelve.getEdges()).containsExactlyInAnyOrderEntriesOf(expectedEdges);
    }

    @Test
    void findPathsPart1ShortExample() {
        DayTwelve dayTwelve = new DayTwelve(List.of(
                "start-A",
                "start-b",
                "A-end",
                "A-c",
                "A-b",
                "b-d",
                "b-end"));

        assertThat(dayTwelve.findPaths()).containsExactlyInAnyOrder(
                List.of("start", "A", "b", "A", "c", "A", "end"),
                List.of("start", "A", "b", "A", "end"),
                List.of("start", "A", "b", "end"),
                List.of("start", "A", "c", "A", "b", "A", "end"),
                List.of("start", "A", "c", "A", "b", "end"),
                List.of("start", "A", "c", "A", "end"),
                List.of("start", "A", "end"),
                List.of("start", "b", "A", "c", "A", "end"),
                List.of("start", "b", "A", "end"),
                List.of("start", "b", "end")
        );
    }

    @Test
    void partOne(){
            DayTwelve dayTwelve = new DayTwelve(Utils.readInputLinesFromFile("day_twelve.txt"));
            assertThat(dayTwelve.findPaths()).hasSize(3497);
    }

    @Test
    void partTwoSmallExample(){

        DayTwelve dayTwelve = new DayTwelve(List.of(
                "start-A",
                "start-b",
                "A-end",
                "A-c",
                "A-b",
                "b-d",
                "b-end"));

                assertThat(dayTwelve.findPaths()).hasSize(36);
    }

    @Test
    void partTwoLargerExample(){
            DayTwelve dayTwelve = new DayTwelve(List.of(
                "dc-end",
                "HN-start",
                "start-kj",
                "dc-start",
                "dc-HN",
                "LN-dc",
                "HN-end",
                "kj-sa",
                "kj-HN",
                "kj-dc"
            ));

            assertThat(dayTwelve.findPaths()).hasSize(103);
    }

    @Test
    void partTwo(){
        DayTwelve dayTwelve = new DayTwelve(Utils.readInputLinesFromFile("day_twelve.txt"));
        List<List<String>> paths = dayTwelve.findPaths();
        assertThat(paths.size()).isEqualTo(93686);
    }
}
