package adventofcode2021;

import java.util.ArrayList;
import java.util.List;

public class DaySixteen {
    static String previousString = null;

    public static String hexStringToBinary(String input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            int intValue = Integer.parseInt(Character.toString(input.charAt(i)), 16);
            result.append(String.format("%4s", Integer.toBinaryString(intValue)).replaceAll(" ", "0"));
        }
        return result.toString();
    }

    public Packet parsePacket(String binaryString) {
        int versionNumber = Integer.parseInt(binaryString.substring(0, 3), 2);
        int typeId = Integer.parseInt(binaryString.substring(3, 6), 2);
        int count = 6;
        Packet result = null;

        if (typeId == 4) {
            String leadingBitValue = binaryString.substring(count, count + 1);
            String value = "";
            while (leadingBitValue.equals("1")) {
                value += binaryString.substring(count + 1, count + 5);
                count += 5;
                leadingBitValue = binaryString.substring(count, count + 1);
            }
            value += binaryString.substring(count + 1, count + 5);
            count += 5;
            result = new LiteralPacket(versionNumber, typeId, count, Long.parseLong(value, 2));
        } else {
            String lengthTypeId = binaryString.substring(count, count + 1);
            count += 1;
            int subPacketLength = 0;
            int subPacketNumber = 0;
            List<Packet> subPacketList = new ArrayList<>();

            if (lengthTypeId.equals("0")) {
                subPacketLength = Integer.parseInt(binaryString.substring(count, count + 15), 2);
                count += 15;
            } else {
                subPacketNumber = Integer.parseInt(binaryString.substring(count, count + 11), 2);
                count += 11;
            }

            int subPacketCount = 0;
            int subPacketIndex = 0;
            while (subPacketIndex < subPacketLength || subPacketCount < subPacketNumber) {
                Packet subPacket = parsePacket(binaryString.substring(count + subPacketIndex));
                subPacketList.add(subPacket);
                subPacketIndex += subPacket.getLength();
                subPacketCount++;
            }
            subPacketLength = subPacketLength == 0 ? subPacketIndex : subPacketLength;
            subPacketNumber = subPacketNumber == 0 ? subPacketCount : subPacketNumber;
            result = new OperatorPacket(versionNumber, typeId, count + subPacketLength, subPacketLength, subPacketNumber, subPacketList);
        }
        System.out.println(binaryString.substring(0, count));
        return result;
    }
}
