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

    @Override
    public long getValue() {
        switch (getTypeId()) {
            case 0:
                return subPacketList.stream().mapToLong(Packet::getValue).sum();
            case 1:
                return subPacketList.stream().mapToLong(Packet::getValue).reduce(1, (a, b) -> a * b);
            case 2:
                return subPacketList.stream().mapToLong(Packet::getValue).min().getAsLong();
            case 3:
                return subPacketList.stream().mapToLong(Packet::getValue).max().getAsLong();
            case 5:
                return subPacketList.get(0).getValue() > subPacketList.get(1).getValue() ? 1 : 0;
            case 6:
                return subPacketList.get(0).getValue() < subPacketList.get(1).getValue() ? 1 : 0;
            case 7:
                return subPacketList.get(0).getValue() == subPacketList.get(1).getValue() ? 1 : 0;
            default:
                throw new IllegalArgumentException("Unknown typeId: " + getTypeId());
        }
    }
}
