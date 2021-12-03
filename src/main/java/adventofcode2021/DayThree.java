package adventofcode2021;

import java.util.List;

public class DayThree {

	public int runDiagnostic(List<String> inputs) {

		int ones = 0;
		int zeros = 0;
		int gammaRate;
		int epsilonRate;

		StringBuilder sb = new StringBuilder();


		for (int i = 0; i < inputs.get(0).length(); i++) {
			for (String input : inputs) {
				if (input.charAt(i) == '1') {
					ones++;
				} else if (input.charAt(i) == '0') {
					zeros++;
				}
			}
			if (ones > zeros) {
				sb.append("1");
			} else {
				sb.append("0");
			}

			//reset the counts
			ones = 0;
			zeros = 0;
		}


		gammaRate = Integer.parseInt(sb.toString(),2);
		String gammaSeq = sb.toString();

		gammaSeq = gammaSeq.replaceAll("0", "x");
		gammaSeq = gammaSeq.replaceAll("1", "0");
		gammaSeq = gammaSeq.replaceAll("x", "1");

		epsilonRate = Integer.parseInt(gammaSeq, 2);

		return gammaRate * epsilonRate;
	}
}
