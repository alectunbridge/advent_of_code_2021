package adventofcode2021;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.assertj.core.api.Assertions.assertThat;

class DaySixTest {

	DaySix daySix = new DaySix();

	String testInput = "3,4,3,1,2";


	@Test
	void solvePart1Example() {
		assertThat(daySix.solvePart1(testInput, 18)).isEqualTo(26);
	}

	@Test
	void solvePart1() throws IOException, URISyntaxException {
		assertThat(daySix.solvePart1(Utils.readInputLinesFromFile("day_six.txt").get(0), 80)).isEqualTo(350917);
	}

	@Test
	void solvePart2() throws IOException, URISyntaxException {
		assertThat(daySix.solvePart1(Utils.readInputLinesFromFile("day_six.txt").get(0), 256)).isEqualTo(1592918715629L);
	}


}
