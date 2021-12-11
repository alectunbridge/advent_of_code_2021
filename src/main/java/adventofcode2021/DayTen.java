package adventofcode2021;

import java.util.*;

public class DayTen {
    private static final Map<Character,Integer> POINTS_LOOKUP = new HashMap<>();
    static {
        POINTS_LOOKUP.put(')',3);
        POINTS_LOOKUP.put(']',57);
        POINTS_LOOKUP.put('}',1197);
        POINTS_LOOKUP.put('>',25137);
    }

    private final List<String> input;
    private Deque<Character> stack = new ArrayDeque<>();
    private int score = 0;

    public DayTen(List<String> input) {
            this.input = input;
    }

    private void processBracket(char c) {
        if(isEndToken(c)) {
            if(stack.peek() == getStartToken(c)) {
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
        for (String line : input) {
            for (char c : line.toCharArray()) {
                try {
                    processBracket(c);
                } catch (IllegalArgumentException e) {
                   score += POINTS_LOOKUP.get(c);
                   break;
                }
            }
            stack.clear();
        }
        return score;
    }
}
