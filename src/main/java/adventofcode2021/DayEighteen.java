package adventofcode2021;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class DayEighteen {
    public static final Pattern SIMPLE_PAIR_PATTERN = Pattern.compile("\\[(\\d+),(\\d+)](.*)");
    public static final Pattern LEFT_STRING_PATTERN = Pattern.compile("(.*\\D)(\\d+)(\\D)*");
    private List<String> input;

    public DayEighteen(List<String> input) {
        this.input = input;
    }


    public String solvePart1() {
        String previousLine = null;
        for (String line : input
        ) {
            previousLine = add(previousLine,line);
        }
        return previousLine;
    }

    private String add(String number1, String number2) {
        if(number1 == null){
            return number2;
        }
        String result = String.format("[%s,%s]",number1,number2);
        result = explode(result);
        return result;
    }

    private String explode(String number) {
        int nesting = 0;
        for (int i = 0; i < number.length(); i++) {
            char currrentChar = number.charAt(i);
            if(nesting == 5) {
                if (Character.isDigit(currrentChar)){
                    String leftString = number.substring(0,i-1);
                    String rightString = number.substring(i-1);
                    Matcher pairMatcher = SIMPLE_PAIR_PATTERN.matcher(rightString);
                    pairMatcher.matches();
                    Matcher leftStringMatcher = LEFT_STRING_PATTERN.matcher(leftString);
                    if(leftStringMatcher.matches()){
                        int newNumber = parseInt(leftStringMatcher.group(2)) + parseInt(pairMatcher.group(1));
                        leftString = leftStringMatcher.group(1)+newNumber+leftStringMatcher.group(3);
                    }
                    Pattern rightStringPattern = Pattern.compile("(\\D*)(\\d+)(.*)");
                    Matcher rightStringMatcher = rightStringPattern.matcher(pairMatcher.group(3));
                    if(rightStringMatcher.matches()){
                        int newNumber = parseInt(rightStringMatcher.group(2)) + parseInt(pairMatcher.group(2));
                        rightString = rightStringMatcher.group(1) + newNumber + rightStringMatcher.group(3);
                    } else {
                        rightString = pairMatcher.group(3);
                    }

                    return leftString + 0 + rightString;
                }
            }
            switch (currrentChar){
                case '[' -> nesting++;
                case ']' -> nesting--;
            }

        }
        return null;
    }
}
