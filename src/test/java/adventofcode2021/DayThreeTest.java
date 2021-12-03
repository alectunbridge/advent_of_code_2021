package adventofcode2021;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class DayThreeTest {

	DayThree dayThree = new DayThree();

	List<String> inputs = List.of(
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
	void Test1() throws IOException, URISyntaxException {
		assertThat(dayThree.runDiagnostic(Utils.readInputLinesFromFile("day_three.txt"))).isEqualTo(3429254);
	}
}
