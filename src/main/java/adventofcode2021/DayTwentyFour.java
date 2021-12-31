package adventofcode2021;

import java.util.*;

class DayTwentyFourInstruction {
    private final String type;
    private final String operand1;
    private String operand2;

    public DayTwentyFourInstruction(String[] tokens) {
        type = tokens[0];
        operand1 = tokens[1];
        if (tokens.length == 3) {
            operand2 = tokens[2];
        }
    }

    public void execute(DayTwentyFour alu) {
        Long register1Value = alu.getRegister(operand1);
        Long register2Value = alu.getRegister(operand2);
        switch (type) {
            case "inp":
                alu.setRegister(operand1, alu.processArgument());
                break;
            case "mul":
                alu.setRegister(operand1, register1Value * register2Value);
                break;
            case "eql":
                alu.setRegister(operand1, register1Value == register2Value ? 1 : 0);
                break;
            case "add":
                alu.setRegister(operand1, register1Value + register2Value);
                break;
            case "mod":
                if (register1Value < 0 || register2Value <= 0){
                    throw new IllegalArgumentException("invalid modulo operation: " + this);
                }
                alu.setRegister(operand1, register1Value % register2Value);
                break;
            case "div":
                if (register2Value == 0) {
                    throw new IllegalArgumentException("invalid division operation: " + this);
                }
                alu.setRegister(operand1, register1Value / register2Value);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
    }

    @Override
    public String toString() {
        return type + " " + operand1 + " " + operand2;
    }
}

public class DayTwentyFour {
    private List<DayTwentyFourInstruction> instructions = new ArrayList<>();
    Deque<Integer> arguments = new ArrayDeque<>();
    private Map<String, Long> registers = new HashMap<>();

    public DayTwentyFour(List<String> input) {
        resetRegisters();
        for (String line : input) {
            String[] tokens = line.split(" ");
            instructions.add(new DayTwentyFourInstruction(tokens));
        }
    }

    @Override
    public String toString() {
        return "DayTwentyFour{" +
                "arguments=" + arguments +
                ", registers=" + registers +
                '}';
    }

    private void resetRegisters() {
        registers.put("w", 0L);
        registers.put("x", 0L);
        registers.put("y", 0L);
        registers.put("z", 0L);
    }


    public void execute(Integer... args) {
        arguments.addAll(List.of(args));
        instructions.forEach(instr -> instr.execute(this));
    }

    public int processArgument() {
        return arguments.remove();
    }

    public Long getRegister(String registerName) {
        Long value = registers.get(registerName);
        if (value == null && registerName != null) {
            return Long.parseLong(registerName);
        }
        return value;
    }

    public void setRegister(String registerName, long value) {
        registers.put(registerName, value);
    }

    public void reset() {
        arguments.clear();
        resetRegisters();
    }
}
