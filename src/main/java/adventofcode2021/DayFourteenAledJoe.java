package adventofcode2021;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DayFourteenAledJoe {
    static long counter = 0;
    static Map<String, Long> letterCount = new HashMap<>();

    private Map<String, Instruction> instructions = new HashMap<>();

    class Instruction {
        long count;
        String pairOne;
        String pairTwo;
        String additionalLetter;

        public Instruction(String pairOne, String pairTwo, String additionalLetter) {
            this.pairOne = pairOne;
            this.pairTwo = pairTwo;
            this.additionalLetter = additionalLetter;
        }

        void process(Map<String, Instruction> instructionMap) {
            instructionMap.get(pairOne).count += count;
            instructionMap.get(pairTwo).count += count;
            letterCount.put(additionalLetter, letterCount.getOrDefault(additionalLetter, 0L) + count);
            instructionMap.get(getName()).count -= count;
        }

        public String getName() {
            return "" + pairOne.charAt(0) + pairTwo.charAt(1);
        }

        public Instruction copy() {
            Instruction result = new Instruction(pairOne, pairTwo, additionalLetter);
            result.count = count;
            return result;
        }
    }

    public long solve(List<String> input) {

        String initialPolymer = input.get(0);

        for (int i = 2; i < input.size(); i++) {
            String[] line = input.get(i).split(" -> ");
            String key = line[0];
            instructions.put(key, new Instruction(line[0].charAt(0) + line[1], line[1] + line[0].charAt(1), line[1]));
        }

        for (int i = 0; i < initialPolymer.length() - 1; i++) {
            String letterPair = initialPolymer.substring(i, i + 2);
            instructions.get(letterPair).count++;
            letterCount.put(letterPair.substring(0, 1), letterCount.getOrDefault(letterPair.substring(0, 1), 0L) + 1);
            letterCount.put(letterPair.substring(1, 2), letterCount.getOrDefault(letterPair.substring(1, 2), 0L) + 1);
        }

        for (int iterationIndex = 0; iterationIndex < 40; iterationIndex++) {
            HashMap<String, Instruction> newInstructionMap = new HashMap<>();
            instructions.forEach((k, v) -> newInstructionMap.put(k, v.copy()));
            for (Instruction instruction : instructions.values()) {
                instruction.process(newInstructionMap);
            }
            instructions = newInstructionMap;
        }
        List<Long> letterCountsAsList = letterCount.values().stream().sorted().collect(Collectors.toList());
        return letterCountsAsList.get(letterCountsAsList.size() - 1) - letterCountsAsList.get(0);
    }


}
