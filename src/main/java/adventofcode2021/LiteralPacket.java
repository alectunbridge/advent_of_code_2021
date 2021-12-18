package adventofcode2021;

public class LiteralPacket extends Packet {
    private int value;

    public LiteralPacket(int versionNumber, int typeId, int length, int value) {
        super(versionNumber, typeId, length);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int sumVersionNumbers() {
        return getVersionNumber();
    }
}
