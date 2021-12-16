package adventofcode2021;

public class DaySixteen {
    public String hexStringToBinary(String input) {
        int intValue = Integer.parseInt(input, 16);
        return Integer.toBinaryString(intValue);
    }

    public Packet parsePacket(String binaryString) {
        int versionNumber = Integer.parseInt(binaryString.substring(0, 3), 2);
        int typeId = Integer.parseInt(binaryString.substring(3, 6), 2);
        int count = 6;
        String leadingBitValue = binaryString.substring(count, count + 1);
        String value = "";
        while (leadingBitValue.equals("1")) {
            value += binaryString.substring(count+1, count + 5);
            count += 5;
            leadingBitValue = binaryString.substring(count, count + 1);
        }
        value += binaryString.substring(count+1, count + 5);

        return new Packet(versionNumber, typeId, Integer.parseInt(value,2));
    }
}
