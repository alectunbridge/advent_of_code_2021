package adventofcode2021;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DaySixteen {
    public String hexStringToBinary(String input) {
        int intValue = Integer.parseInt(input, 16);
        return Integer.toBinaryString(intValue);
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
            result = new LiteralPacket(versionNumber, typeId, count, Integer.parseInt(value,2));
        } else {
            String lengthTypeId = binaryString.substring(count, count+1);
            count +=1;
            int subPacketLength = 0;
            if (lengthTypeId.equals("0")) {
                subPacketLength = Integer.parseInt(binaryString.substring(count, count + 15), 2);
                count += 15;
            }
            //parse subpackets here
            int subPacketIndex = 0;
            List<Packet> subPacketList = new ArrayList<>();
            while(subPacketIndex < subPacketLength) {
                Packet subPacket = parsePacket(binaryString.substring(count+subPacketIndex));
                subPacketList.add(subPacket);
                subPacketIndex += subPacket.getLength();
            }
            result = new OperatorPacket(versionNumber, typeId, count+subPacketLength, subPacketLength, subPacketList);
        }
        return result;
    }
}
