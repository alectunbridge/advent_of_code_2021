package adventofcode2021;

import java.util.ArrayList;
import java.util.List;

public class DayThree {

    public int powerConsumption(List<String> inputs) {

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


        gammaRate = Integer.parseInt(sb.toString(), 2);
        String gammaSeq = sb.toString();

        gammaSeq = gammaSeq.replaceAll("0", "x");
        gammaSeq = gammaSeq.replaceAll("1", "0");
        gammaSeq = gammaSeq.replaceAll("x", "1");

        epsilonRate = Integer.parseInt(gammaSeq, 2);

        return gammaRate * epsilonRate;
    }



    public int lifeSupportRatingMostCommon(List<String> input, int digitIndex) {
        if(input.size() == 1){
            return Integer.parseInt(input.get(0),2);
        }
        int countOfOnesAtThisPosition = 0;
        for (String line : input) {
            if (line.charAt(digitIndex) == '1') {
                countOfOnesAtThisPosition++;
            }
        }

        char mostCommonCharacter = Character.MIN_VALUE;
        if (countOfOnesAtThisPosition >= input.size() / 2.0) {
            mostCommonCharacter = '1';
        } else {
            mostCommonCharacter = '0';
        }
        //filter only the most common values for the next iteration
        List<String> stringsMatchingMostCommonCharacter = new ArrayList<>();
        for (String line : input) {
            if (line.charAt(digitIndex) == mostCommonCharacter) {
                stringsMatchingMostCommonCharacter.add(line);
            }
        }
        int mostCommonResult = lifeSupportRatingMostCommon(stringsMatchingMostCommonCharacter, digitIndex + 1);
        return mostCommonResult;
    }

    public int lifeSupportRatingLeastCommon(List<String> input, int digitIndex) {
        if(input.size() == 1){
            return Integer.parseInt(input.get(0),2);
        }
        int countOfOnesAtThisPosition = 0;
        for (String line : input) {
            if (line.charAt(digitIndex) == '1') {
                countOfOnesAtThisPosition++;
            }
        }

        char leastCommonCharacter = Character.MIN_VALUE;
        if (countOfOnesAtThisPosition < input.size() / 2.0) {
            leastCommonCharacter = '1';
        } else {
            leastCommonCharacter = '0';
        }
        //filter only the most common values for the next iteration
        List<String> stringsMatchingLeastCommonCharacter = new ArrayList<>();
        for (String line : input) {
            if (line.charAt(digitIndex) == leastCommonCharacter) {
                stringsMatchingLeastCommonCharacter.add(line);
            }
        }
        int leastCommonResult = lifeSupportRatingLeastCommon(stringsMatchingLeastCommonCharacter, digitIndex + 1);
        return leastCommonResult;
    }
}
