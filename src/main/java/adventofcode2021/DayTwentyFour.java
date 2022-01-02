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
                if (register1Value < 0 || register2Value <= 0) {
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

    public String toJava(DayTwentyFour alu) {
        StringBuilder sb = new StringBuilder();
        switch (type) {
            case "inp":
                sb.append(operand1 + "=" + alu.getNextArgumentLetter() + ";");
                break;
            case "mul":
                sb.append(operand1 + "=" + operand1 + "*" + operand2 + ";");
                break;
            case "eql":
                sb.append(operand1 + "=" + operand1 + "==" + operand2 + "?1:0;");
                break;
            case "add":
                sb.append(operand1 + "=" + operand1 + "+" + operand2 + ";");
                break;
            case "mod":
                sb.append(operand1 + "=" + operand1 + "%" + operand2 + ";");
                break;
            case "div":
                sb.append(operand1 + "=" + operand1 + "/" + operand2 + ";");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }

        return sb.toString();
    }
}

public class DayTwentyFour {
    private List<DayTwentyFourInstruction> instructions = new ArrayList<>();
    Deque<Integer> arguments = new ArrayDeque<>();
    private Map<String, Long> registers = new HashMap<>();
    private String[] argumentLetters = new String[14];
    private int argumentCounter = 0;
    private long w, x, y, z;

    public DayTwentyFour(List<String> input) {
        for (int i = 0; i < 14; i++) {
            argumentLetters[i] = "" + Character.toString('a' + i);
        }
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

    public String translateToJava() {
        StringBuilder sb = new StringBuilder();
        for (DayTwentyFourInstruction instruction : instructions) {
            sb.append(instruction.toJava(this));
            sb.append("\n");
        }
        return sb.toString();
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

    public String getNextArgumentLetter() {
        return argumentLetters[argumentCounter++];
    }

    public long skunkWerks(long a, long b, long c, long d, long e, long f, long g,
                           long h, long i, long j, long k, long l, long m, long n) {
        w = a;
        x = x * 0;
        x = x + z;
        x = x % 26;
        z = z / 1;
        x = x + 13;
        x = x == w ? 1 : 0;
        x = x == 0 ? 1 : 0;
        y = y * 0;
        y = y + 25;
        y = y * x;
        y = y + 1;
        z = z * y;
        y = y * 0;
        y = y + w;
        y = y + 14;
        y = y * x;
        z = z + y;
        w = b;
        x = x * 0;
        x = x + z;
        x = x % 26;
        z = z / 1;
        x = x + 12;
        x = x == w ? 1 : 0;
        x = x == 0 ? 1 : 0;
        y = y * 0;
        y = y + 25;
        y = y * x;
        y = y + 1;
        z = z * y;
        y = y * 0;
        y = y + w;
        y = y + 8;
        y = y * x;
        z = z + y;
        w = c;
        x = x * 0;
        x = x + z;
        x = x % 26;
        z = z / 1;
        x = x + 11;
        x = x == w ? 1 : 0;
        x = x == 0 ? 1 : 0;
        y = y * 0;
        y = y + 25;
        y = y * x;
        y = y + 1;
        z = z * y;
        y = y * 0;
        y = y + w;
        y = y + 5;
        y = y * x;
        z = z + y;
        w = d;
        x = x * 0;
        x = x + z;
        x = x % 26;
        z = z / 26;
        x = x + 0;
        x = x == w ? 1 : 0;
        x = x == 0 ? 1 : 0;
        y = y * 0;
        y = y + 25;
        y = y * x;
        y = y + 1;
        z = z * y;
        y = y * 0;
        y = y + w;
        y = y + 4;
        y = y * x;
        z = z + y;
        w = e;
        x = x * 0;
        x = x + z;
        x = x % 26;
        z = z / 1;
        x = x + 15;
        x = x == w ? 1 : 0;
        x = x == 0 ? 1 : 0;
        y = y * 0;
        y = y + 25;
        y = y * x;
        y = y + 1;
        z = z * y;
        y = y * 0;
        y = y + w;
        y = y + 10;
        y = y * x;
        z = z + y;
        w = f;
        x = x * 0;
        x = x + z;
        x = x % 26;
        z = z / 26;
        x = x + -13;
        x = x == w ? 1 : 0;
        x = x == 0 ? 1 : 0;
        y = y * 0;
        y = y + 25;
        y = y * x;
        y = y + 1;
        z = z * y;
        y = y * 0;
        y = y + w;
        y = y + 13;
        y = y * x;
        z = z + y;
        w = g;
        x = x * 0;
        x = x + z;
        x = x % 26;
        z = z / 1;
        x = x + 10;
        x = x == w ? 1 : 0;
        x = x == 0 ? 1 : 0;
        y = y * 0;
        y = y + 25;
        y = y * x;
        y = y + 1;
        z = z * y;
        y = y * 0;
        y = y + w;
        y = y + 16;
        y = y * x;
        z = z + y;
        w = h;
        x = x * 0;
        x = x + z;
        x = x % 26;
        z = z / 26;
        x = x + -9;
        x = x == w ? 1 : 0;
        x = x == 0 ? 1 : 0;
        y = y * 0;
        y = y + 25;
        y = y * x;
        y = y + 1;
        z = z * y;
        y = y * 0;
        y = y + w;
        y = y + 5;
        y = y * x;
        z = z + y;
        w = i;
        x = x * 0;
        x = x + z;
        x = x % 26;
        z = z / 1;
        x = x + 11;
        x = x == w ? 1 : 0;
        x = x == 0 ? 1 : 0;
        y = y * 0;
        y = y + 25;
        y = y * x;
        y = y + 1;
        z = z * y;
        y = y * 0;
        y = y + w;
        y = y + 6;
        y = y * x;
        z = z + y;
        w = j;
        x = x * 0;
        x = x + z;
        x = x % 26;
        z = z / 1;
        x = x + 13;
        x = x == w ? 1 : 0;
        x = x == 0 ? 1 : 0;
        y = y * 0;
        y = y + 25;
        y = y * x;
        y = y + 1;
        z = z * y;
        y = y * 0;
        y = y + w;
        y = y + 13;
        y = y * x;
        z = z + y;
        w = k;
        x = x * 0;
        x = x + z;
        x = x % 26;
        z = z / 26;
        x = x + -14;
        x = x == w ? 1 : 0;
        x = x == 0 ? 1 : 0;
        y = y * 0;
        y = y + 25;
        y = y * x;
        y = y + 1;
        z = z * y;
        y = y * 0;
        y = y + w;
        y = y + 6;
        y = y * x;
        z = z + y;
        w = l;
        x = x * 0;
        x = x + z;
        x = x % 26;
        z = z / 26;
        x = x + -3;
        x = x == w ? 1 : 0;
        x = x == 0 ? 1 : 0;
        y = y * 0;
        y = y + 25;
        y = y * x;
        y = y + 1;
        z = z * y;
        y = y * 0;
        y = y + w;
        y = y + 7;
        y = y * x;
        z = z + y;
        w = m;
        x = x * 0;
        x = x + z;
        x = x % 26;
        z = z / 26;
        x = x + -2;
        x = x == w ? 1 : 0;
        x = x == 0 ? 1 : 0;
        y = y * 0;
        y = y + 25;
        y = y * x;
        y = y + 1;
        z = z * y;
        y = y * 0;
        y = y + w;
        y = y + 13;
        y = y * x;
        z = z + y;
        w = n;
        x = x * 0;
        x = x + z;
        x = x % 26;
        z = z / 26;
        x = x + -14;
        x = x == w ? 1 : 0;
        x = x == 0 ? 1 : 0;
        y = y * 0;
        y = y + 25;
        y = y * x;
        y = y + 1;
        z = z * y;
        y = y * 0;
        y = y + w;
        y = y + 3;
        y = y * x;
        z = z + y;
        return z;
    }

    public long skunkWerks(Integer[] digits) {
        return skunkWerks(digits[0], digits[1], digits[2], digits[3], digits[4], digits[5], digits[6],
                digits[7], digits[8], digits[9], digits[10], digits[11], digits[12], digits[13]);
    }

    public static Map<Long, String> generateUniqueZValues(Map<Long,String> zValues, long digitIndex) {
        DayTwentyFour dayTwentyFour = new DayTwentyFour(Utils.readInputLinesFromFile("day_twenty_four_" + (char) ('a' + digitIndex)));
        Map<Long,String> result = new HashMap<>();
        zValues.forEach( (oldZ,inputSoFar) -> {
            for (int currentDigit = 1; currentDigit < 10; currentDigit++) {
                dayTwentyFour.reset();
                dayTwentyFour.setRegister("z", oldZ);
                dayTwentyFour.execute(currentDigit);
                Long newZ = dayTwentyFour.getRegister("z");
                String previousInputToGetToZ = result.get(newZ);
                if(previousInputToGetToZ == null ||
                        Long.parseLong(previousInputToGetToZ) > Long.parseLong(inputSoFar+currentDigit)) {
                    result.put(newZ, inputSoFar + currentDigit);
                }
            }
        });
        return result;
    }
}
