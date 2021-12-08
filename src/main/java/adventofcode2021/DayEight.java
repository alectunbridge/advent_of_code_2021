package adventofcode2021;

import java.util.List;
import java.util.Set;

public class DayEight {
    public int solve(List<String> input) {
        int identifiedDigits=0;
        for (String line : input) {
            String[] split = line.split("\\|");
            String messageOutput = split[1].trim();
            String[] digits = messageOutput.split(" ");
            for (String digit : digits) {
                int length = digit.length();
                Set<Integer> identifiableDigits = Set.of(2,4,3,7);
                if(identifiableDigits.contains(length)){
                    identifiedDigits++;
                }
            }
        }

        return identifiedDigits;
    }
}
