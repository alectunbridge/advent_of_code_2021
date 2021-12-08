package adventofcode2021;

import java.util.*;
import java.util.stream.Collectors;

public class DayEight {
    public int solve(List<String> input) {
        int identifiedDigits = 0;
        for (String line : input) {
            String[] split = line.split("\\|");
            String messageOutput = split[1].trim();
            String[] digits = messageOutput.split(" ");
            for (String digit : digits) {
                int length = digit.length();
                Set<Integer> identifiableDigits = Set.of(2, 4, 3, 7);
                if (identifiableDigits.contains(length)) {
                    identifiedDigits++;
                }
            }
        }

        return identifiedDigits;
    }

    public int solvePart2(List<String> input) {
        int answer = 0;
        for (String line : input) {
            String[] split = line.split("\\|");

            List<Set<String>> inputDigits = Arrays.stream(split[0].trim().split(" ")).map(s -> Set.of(s.split(""))).collect(Collectors.toList());

            String messageOutput = split[1].trim();
            String[] outputDigits = messageOutput.split(" ");

            Map<Integer, Set<String>> knownDigits = new HashMap<>();
            for (Iterator<Set<String>> it = inputDigits.iterator(); it.hasNext(); ) {
                Set<String> inputDigitSegments = it.next();
                int length = inputDigitSegments.size();
                switch (length) {
                    case 2:
                        knownDigits.put(1, inputDigitSegments);
                        it.remove();
                        break;
                    case 3:
                        knownDigits.put(7, inputDigitSegments);
                        it.remove();
                        break;
                    case 4:
                        knownDigits.put(4, inputDigitSegments);
                        it.remove();

                        break;
                    case 7:
                        knownDigits.put(8, inputDigitSegments);
                        it.remove();
                        break;
                    default:
                        System.out.println("Not a number we know from the off");

                }
            }

            for (Iterator<Set<String>> it = inputDigits.iterator(); it.hasNext(); ) {
                Set<String> inputDigitSegments = it.next();
                switch (inputDigitSegments.size()) {
                    case 5:
                        if (inputDigitSegments.containsAll(knownDigits.get(1))) {
                            knownDigits.put(3, inputDigitSegments);
                            it.remove();
                        }
                }
            }

            for (Iterator<Set<String>> it = inputDigits.iterator(); it.hasNext(); ) {
                Set<String> inputDigitSegments = it.next();
                switch (inputDigitSegments.size()) {
                    case 6:
                        if (!inputDigitSegments.containsAll(knownDigits.get(1))) {
                            knownDigits.put(6, inputDigitSegments);
                            it.remove();
                        }
                }
            }

            for (Iterator<Set<String>> it = inputDigits.iterator(); it.hasNext(); ) {
                Set<String> inputDigitSegments = it.next();
                switch (inputDigitSegments.size()) {
                    case 6:
                        if (inputDigitSegments.containsAll(knownDigits.get(4))) {
                            knownDigits.put(9, inputDigitSegments);
                            it.remove();
                        }
                }
            }

            for (Iterator<Set<String>> it = inputDigits.iterator(); it.hasNext(); ) {
                Set<String> inputDigitSegments = it.next();
                switch (inputDigitSegments.size()) {
                    case 6:
                        knownDigits.put(0, inputDigitSegments);
                        it.remove();
                }
            }

            for (Iterator<Set<String>> it = inputDigits.iterator(); it.hasNext(); ) {
                Set<String> inputDigitSegments = it.next();
                switch (inputDigitSegments.size()) {
                    case 5:
                        //4-1
                        Set<String> elementsToMatchOn = new HashSet<>(knownDigits.get(4));
                        elementsToMatchOn.removeAll(knownDigits.get(1));
                        if (inputDigitSegments.containsAll(elementsToMatchOn)) {
                            knownDigits.put(5, inputDigitSegments);
                            it.remove();
                        }
                }
            }

            if(inputDigits.size()==1){
                knownDigits.put(2,inputDigits.get(0));
                inputDigits.remove(0);
            } else {
                throw new RuntimeException("we shouldn't get here");
            }


            System.out.println(inputDigits);
            System.out.println(knownDigits);

            String result = "";
            for (String outputDigit : outputDigits) {
                for (Map.Entry<Integer, Set<String>> entry : knownDigits.entrySet()) {
                    Integer k = entry.getKey();
                    Set<String> v = entry.getValue();
                    if (v.equals(Set.of(outputDigit.split("")))) {
                        result += k;
                        break;
                    }
                }
            }
            answer+=Integer.parseInt(result);



    /*
    a
    c/f?
    e/g?

    we know:
    1
    4
    7
    8
    3 = 5 segments including those from 1 (cf)
    6 = 6 segments not including those from 1 (cf)
    9 = 6 segments include those from 4 (bcdf)
    0 = 6 segments by deduction
    5 = 5 segments including those from 4-1 (bd)
    2 = by deduction

    1 2*    c  f
    7 3*  a c  f
    4 4*   bcd f
    2 5-  a cde g
    5 5-  ab d fg
    3 5-  a cd fg
    0 6-  abc efg
    9 6-  abcd fg
    6 6-  ab defg
    8 7*  abcdefg
     */
        }

        return answer;
    }
}
