package adventofcode2021;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class DayThreeTest {

	private DayThree dayThree = new DayThree();

	private static final List<String> testInput = List.of(
			"00100",
			"11110",
			"10110",
			"10111",
			"10101",
			"01111",
			"00111",
			"11100",
			"10000",
			"11001",
			"00010",
			"01010"
	);

	@Test
	void partOneSolution() throws IOException, URISyntaxException {
		assertThat(dayThree.powerConsumption(Utils.readInputLinesFromFile("day_three.txt"))).isEqualTo(3429254);
	}

	@Test
	void partTwoExample() {
		assertThat(dayThree.lifeSupportRatingMostCommon(testInput, 0)).isEqualTo(23);
		assertThat(dayThree.lifeSupportRatingLeastCommon(testInput, 0)).isEqualTo(10);
		assertThat(dayThree.lifeSupportRatingLeastCommon(testInput, 0)* dayThree.lifeSupportRatingLeastCommon(testInput,0)).isEqualTo(230);
	}

	@Test
	void partTwoSolution() throws IOException, URISyntaxException {
		//too high
		assertThat(dayThree.lifeSupportRatingMostCommon(Utils.readInputLinesFromFile("day_three.txt"),0)
		* dayThree.lifeSupportRatingLeastCommon(Utils.readInputLinesFromFile("day_three.txt"),0)).isEqualTo(5410338);
	}
}
