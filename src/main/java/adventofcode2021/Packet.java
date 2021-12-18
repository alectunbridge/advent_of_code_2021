package adventofcode2021;

public abstract class Packet {
    private static int packetId = 0;

    private int versionNumber;
    private int typeId;
    private int length;

    public Packet(int versionNumber, int typeId, int length) {
        this.versionNumber = versionNumber;
        this.typeId = typeId;
        this.length = length;
        packetId++;
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

    @Override
    public String toString() {
        return "Packet: " +
                "id=" + packetId +
                ", versionNumber=" + versionNumber +
                ", typeId=" + typeId +
                ", length=" + length;
    }

    abstract public int sumVersionNumbers();

    public abstract long getValue();
}
