package adventofcode2021;

public class LiteralPacket extends Packet {
    private long value;

    public LiteralPacket(int versionNumber, int typeId, int length, long value) {
        super(versionNumber, typeId, length);
        this.value = value;
        if((length - 6)%5 != 0) {
            throw new IllegalArgumentException("Invalid length for literal packet: " + length);
        }
        System.out.println(this);
    }

    public long getValue() {
        return value;
    }

    @Override
    public int sumVersionNumbers() {
        return getVersionNumber();
    }

    @Override
    public String toString() {
        return super.toString() + " Literal packet: " + getValue();
    }
}
