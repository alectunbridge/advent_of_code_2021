package adventofcode2021;

public class DaySixteen {
    public String hexStringToBinary(String input) {
        int intValue = Integer.parseInt(input, 16);
        return Integer.toBinaryString(intValue);
    }

    public Packet parsePacket(String binaryString) {
        int versionNumber = Integer.parseInt(binaryString.substring(0,3),2);
        Packet packet = new Packet(versionNumber);
        return packet;
    }
}
