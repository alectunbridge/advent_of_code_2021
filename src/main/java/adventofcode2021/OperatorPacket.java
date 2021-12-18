package adventofcode2021;

import java.util.List;

public class OperatorPacket extends Packet {
    private int lengthOfSubPackets;
    private List<Packet> subPacketList;

    public OperatorPacket(int versionNumber, int typeId, int length, int subPacketLength, List<Packet> subPacketList) {
        super(versionNumber, typeId, length);
        this.lengthOfSubPackets = subPacketLength;
        this.subPacketList = subPacketList;
    }

    public int getLengthOfSubPackets() {
        return lengthOfSubPackets;
    }

    public int sumVersionNumbers() {
        return getVersionNumber() + subPacketList.stream().mapToInt(Packet::sumVersionNumbers).sum();
    }
}
