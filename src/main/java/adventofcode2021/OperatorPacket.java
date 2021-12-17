package adventofcode2021;

public class OperatorPacket extends Packet {
    private int lengthOfSubPackets;

    public OperatorPacket(int versionNumber, int typeId, int length, int subPacketLength) {
        super(versionNumber, typeId, length);
        this.lengthOfSubPackets = subPacketLength;
    }

    public int getLengthOfSubPackets() {
        return lengthOfSubPackets;
    }
}
