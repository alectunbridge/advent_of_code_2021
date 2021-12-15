package adventofcode2021;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DayFourteenAledJoeTest {

	DayFourteenAledJoe dayFourteenAledJoe = new DayFourteenAledJoe();

	@Test
	void Test() {
		assertThat(dayFourteenAledJoe.solve(Utils.readInputLinesFromFile("day_fourteen.txt"))).isEqualTo(3776553567525L);
	}
}
