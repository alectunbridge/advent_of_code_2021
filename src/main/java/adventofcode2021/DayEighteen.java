package adventofcode2021;

import java.util.List;
import java.util.function.IntPredicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class DayEighteen {
    public static final Pattern SIMPLE_PAIR_PATTERN = Pattern
            .compile("\\[(?<number1>\\d+),(?<number2>\\d+)](?<postfix>.*)");
    public static final Pattern LEFT_STRING_PATTERN = Pattern
            .compile("(?<prefix>.*\\D)(?<number>\\d+)(?<postfix>\\D*)");
    public static final Pattern RIGHT_STRING_PATTERN = Pattern.compile("(?<prefix>\\D*)(?<number>\\d+)(?<postfix>.*)");
    private List<String> input;

    public DayEighteen(List<String> input) {
        this.input = input;
    }

    public String solvePart1() {
        String previousLine = null;
        for (String line : input) {
            previousLine = add(previousLine, line);
        }
        return previousLine;
    }

    private String add(String number1, String number2) {
        if (number1 == null) {
            return number2;
        }
        String result = String.format("[%s,%s]", number1, number2);
        while (true) {
            String explodedResult = explode(result);
            if (!explodedResult.equals(result)) {
                result = explodedResult;
                continue;
            }
            String splitResult = split(result);
            if (splitResult.equals(result)) {
                break;
            } else {
                result = splitResult;
            }
        }
        return result;
    }

    private String split(String number) {
        Pattern doubleDigitPattern = Pattern.compile("\\d\\d");
        Matcher doubleDigitMatcher = doubleDigitPattern.matcher(number);
        if (doubleDigitMatcher.find()) {
            int leftNumber = parseInt(doubleDigitMatcher.group(0)) / 2;
            int rightNumber = (int) Math.ceil(parseInt(doubleDigitMatcher.group(0)) / 2.0);
            number = number.substring(0, doubleDigitMatcher.start()) + "[" + leftNumber + "," + rightNumber + "]"
                    + number.substring(doubleDigitMatcher.end());
        }
        return number;
    }

    private String explode(String number) {
        int nesting = 0;
        for (int i = 0; i < number.length(); i++) {
            char currrentChar = number.charAt(i);
            if (nesting == 5) {
                if (Character.isDigit(currrentChar)) {
                    String leftString = number.substring(0, i - 1);
                    String rightString = number.substring(i - 1);
                    Matcher pairMatcher = SIMPLE_PAIR_PATTERN.matcher(rightString);
                    pairMatcher.matches();
                    Matcher leftStringMatcher = LEFT_STRING_PATTERN.matcher(leftString);
                    if (leftStringMatcher.matches()) {
                        int newNumber = parseInt(leftStringMatcher.group("number"))
                                + parseInt(pairMatcher.group("number1"));
                        leftString = leftStringMatcher.group("prefix") + newNumber + leftStringMatcher.group("postfix");
                    }
                    Matcher rightStringMatcher = RIGHT_STRING_PATTERN.matcher(pairMatcher.group("postfix"));
                    if (rightStringMatcher.matches()) {
                        int newNumber = parseInt(rightStringMatcher.group("number"))
                                + parseInt(pairMatcher.group("number2"));
                        rightString = rightStringMatcher.group("prefix") + newNumber
                                + rightStringMatcher.group("postfix");
                    } else {
                        rightString = pairMatcher.group("postfix");
                    }

                    return leftString + 0 + rightString;
                }
            }
            switch (currrentChar) {
                case '[' -> nesting++;
                case ']' -> nesting--;
            }

        }
        return number;
    }

    public static int magnitude(String number) {
        Pattern pattern = Pattern.compile("\\[(?<number1>\\d+),(?<number2>\\d+)]");

        while (true) {
            Matcher matcher = pattern.matcher(number);
            StringBuffer sb = new StringBuffer();
            while (matcher.find()) {
                int i = 3 * parseInt(matcher.group("number1"));
                int j = 2 * parseInt(matcher.group("number2"));
                matcher.appendReplacement(sb, String.valueOf(i + j));
            }
            matcher.appendTail(sb);

            String newResult = sb.toString();
            if (!newResult.contains(",")) {
                return parseInt(newResult);
            } else {
                number = newResult;
            }
        }
    }
}
