package adventofcode2021;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.assertj.core.api.Assertions.assertThat;

class DaySixTest {

	DaySix daySix = new DaySix();

	String testInput = "3,4,3,1,2";


	@Test
	void Test1DaySix() throws IOException, URISyntaxException {

		assertThat(daySix.solve(Utils.readInputLinesFromFile("day_six.txt").get(0), 256)).isEqualTo(5934);
	}
}
