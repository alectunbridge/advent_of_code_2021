package adventofcode2021;

import java.util.*;

public class DayTen {
    private static final Map<Character, Integer> POINTS_LOOKUP = new HashMap<>();
    private static final Map<Character, Integer> POINTS_LOOKUP2 = new HashMap<>();

    static {
        POINTS_LOOKUP.put(')', 3);
        POINTS_LOOKUP.put(']', 57);
        POINTS_LOOKUP.put('}', 1197);
        POINTS_LOOKUP.put('>', 25137);

        POINTS_LOOKUP2.put(')', 1);
        POINTS_LOOKUP2.put(']', 2);
        POINTS_LOOKUP2.put('}', 3);
        POINTS_LOOKUP2.put('>', 4);
    }

    private final List<String> input;
    private Deque<Character> stack = new ArrayDeque<>();
    private Deque<Object> completionStack = new ArrayDeque<>();
    private ArrayList<Character> missingBrackets = new ArrayList<>();

    public DayTen(List<String> input) {
        this.input = input;
    }

    private void processBracket(char c) {
        if (isEndToken(c)) {
            if (stack.peek() == getStartToken(c)) {
                stack.pop();
            } else {
                throw new IllegalArgumentException(String.valueOf(c));
            }
        } else {
            stack.push(c);
        }
    }

    private Character getStartToken(char c) {
        switch (c) {
            case '}':
                return '{';
            case ']':
                return '[';
            case ')':
                return '(';
            case '>':
                return '<';
            default:
                throw new IllegalArgumentException(String.valueOf(c));
        }
    }

    private boolean isEndToken(char c) {
        return Set.of('}', ']', ')', '>').contains(c);
    }

    public int solvePart1() {
        int score = 0;
        for (Iterator<String> iterator = input.iterator(); iterator.hasNext(); ) {
            String line = iterator.next();
            for (char c : line.toCharArray()) {
                try {
                    processBracket(c);
                } catch (IllegalArgumentException e) {
                    score += POINTS_LOOKUP.get(c);
                    iterator.remove();
                    break;
                }
            }
            stack.clear();
        }
        return score;
    }

    public long solvePart2() {
        List<Long> result = new ArrayList<>();
        solvePart1();
        for (String line : input) {
            char[] charArray = line.toCharArray();
            for (int i = charArray.length - 1; i >= 0; i--) {
                char c = charArray[i];
                processBracket2(c);
            }
            System.out.println(missingBrackets);

            result.add(scoreMissingBrackets());
            completionStack.clear();
            missingBrackets.clear();
        }
        Collections.sort(result);
        return result.get((int)Math.ceil(result.size()/2.0)-1);
    }

    private long scoreMissingBrackets() {
        long result = 0;
        for (Character missingBracket : missingBrackets) {
            result = result * 5 + POINTS_LOOKUP2.get(missingBracket);
        }
        return result;
    }

    private void processBracket2(char c) {
        if (!isEndToken(c)) {
            if (completionStack.peek() == getEndToken(c)) {
                completionStack.pop();
            } else {
                missingBrackets.add(getEndToken(c));
            }
        } else {
            completionStack.push(c);
        }
    }

    private Character getEndToken(char c) {
        switch (c) {
            case '{':
                return '}';
            case '[':
                return ']';
            case '(':
                return ')';
            case '<':
                return '>';
            default:
                throw new IllegalArgumentException(String.valueOf(c));
        }
    }
}
