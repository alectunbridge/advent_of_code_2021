package adventofcode2021;

import java.util.List;

public class OperatorPacket extends Packet {
    private int lengthOfSubPackets;
    private int subPacketNumber;
    private List<Packet> subPacketList;

    public OperatorPacket(int versionNumber, int typeId, int length, int subPacketLength, int subPacketNumber, List<Packet> subPacketList) {
        super(versionNumber, typeId, length);
        this.lengthOfSubPackets = subPacketLength;
        this.subPacketNumber = subPacketNumber;
        this.subPacketList = subPacketList;
        System.out.println(this);
    }

    public int getLengthOfSubPackets() {
        return lengthOfSubPackets;
    }

    public int sumVersionNumbers() {
        return getVersionNumber() + subPacketList.stream().mapToInt(Packet::sumVersionNumbers).sum();
    }

    public int getNumberOfSubPackets() {
        return subPacketNumber;
    }

    @Override
    public String toString() {
        return super.toString() + " OperatorPacket " +
                "lengthOfSubPackets=" + lengthOfSubPackets +
                ", subPacketNumber=" + subPacketNumber;
    }


}
