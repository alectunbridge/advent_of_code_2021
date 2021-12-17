package adventofcode2021;

public abstract class Packet {
    private int versionNumber;
    private int typeId;
    private int length;

    public Packet(int versionNumber, int typeId, int length) {
        this.versionNumber = versionNumber;
        this.typeId = typeId;
        this.length = length;
    }

    public int getVersionNumber() {
        return versionNumber;
    }

    public int getTypeId() {
        return typeId;
    }

    public int getLength() {
        return length;
    }
}
