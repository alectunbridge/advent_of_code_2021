package adventofcode2021;

public class Packet {
    private int value;
    private int versionNumber;
    private int typeId;
    private int subPacketLength;

    public Packet(int versionNumber, int typeId, int value) {
        this.versionNumber = versionNumber;
        this.typeId = typeId;
        this.value = value;
    }

    public Packet(int versionNumber, int typeId, int value, int subPacketLength) {
        this(versionNumber, typeId, value);
        this.subPacketLength = subPacketLength;
    }

    public int getVersionNumber() {
        return versionNumber;
    }

    public int getTypeId() {
        return typeId;
    }

    public int getValue() {
        return value;
    }

    public int getSubPacketLength() {
        return subPacketLength;
    }
}
