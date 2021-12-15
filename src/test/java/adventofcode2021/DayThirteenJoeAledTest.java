package adventofcode2021;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DayThirteenJoeAledTest {


	DayThirteenJoeAled dayThirteenJoeAled = new DayThirteenJoeAled();

	@Test
	void Test1() {

		assertThat(dayThirteenJoeAled.Solve(Utils.readInputLinesFromFile("day_thirteen.txt"))).isEqualTo(0);
	}
}
