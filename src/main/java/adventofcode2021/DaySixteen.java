package adventofcode2021;

import java.util.ArrayList;
import java.util.List;

public class DaySixteen {
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

        if (typeId == 4) {
            return parseLiteralPacket(binaryString, versionNumber, typeId);
        } else {
            return parseOperatorPacket(binaryString, versionNumber, typeId);
        }
    }

    private Packet parseOperatorPacket(String binaryString, int versionNumber, int typeId) {
        int stringIndex = 6;
        String lengthTypeId = binaryString.substring(stringIndex, stringIndex + 1);
        stringIndex += 1;
        int subPacketLength = 0;
        int subPacketNumber = 0;
        List<Packet> subPacketList = new ArrayList<>();

        if (lengthTypeId.equals("0")) {
            subPacketLength = Integer.parseInt(binaryString.substring(stringIndex, stringIndex + 15), 2);
            stringIndex += 15;
        } else {
            subPacketNumber = Integer.parseInt(binaryString.substring(stringIndex, stringIndex + 11), 2);
            stringIndex += 11;
        }

        int subPacketCount = 0;
        int subPacketIndex = 0;
        while (subPacketIndex < subPacketLength || subPacketCount < subPacketNumber) {
            Packet subPacket = parsePacket(binaryString.substring(stringIndex + subPacketIndex));
            subPacketList.add(subPacket);
            subPacketIndex += subPacket.getLength();
            subPacketCount++;
        }
        subPacketLength = subPacketLength == 0 ? subPacketIndex : subPacketLength;
        subPacketNumber = subPacketNumber == 0 ? subPacketCount : subPacketNumber;
        int length = stringIndex + subPacketLength;
        return new OperatorPacket(versionNumber, typeId, length, subPacketLength, subPacketNumber, subPacketList);
    }

    private Packet parseLiteralPacket(String binaryString, int versionNumber, int typeId) {
        Packet result;
        int stringIndex = 6;
        String leadingBitValue = binaryString.substring(stringIndex, stringIndex + 1);
        String value = "";
        while (leadingBitValue.equals("1")) {
            value += binaryString.substring(stringIndex + 1, stringIndex + 5);
            stringIndex += 5;
            leadingBitValue = binaryString.substring(stringIndex, stringIndex + 1);
        }
        value += binaryString.substring(stringIndex + 1, stringIndex + 5);
        stringIndex += 5;
        result = new LiteralPacket(versionNumber, typeId, stringIndex, Long.parseLong(value, 2));
        return result;
    }
}
