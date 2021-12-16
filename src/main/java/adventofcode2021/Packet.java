package adventofcode2021;

public class Packet {
    private int value;
    private int versionNumber;
    private int typeId;

    public Packet(int versionNumber, int typeId, int value) {
        this.versionNumber = versionNumber;
        this.typeId = typeId;
        this.value = value;
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
}
