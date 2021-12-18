package adventofcode2021;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DaySixteenTest {

    DaySixteen daySixteen = new DaySixteen();

    @Test
    void hexToBinary() {
        assertThat(DaySixteen.hexStringToBinary("D2FE28")).isEqualTo("110100101111111000101000");
    }

    @Test
    void parseLiteralPacket() {
        /*
        110100101111111000101000
        VVVTTTAAAAABBBBBCCCCC
         */
        LiteralPacket packet = (LiteralPacket) daySixteen.parsePacket("110100101111111000101000");
        assertThat(packet.getVersionNumber()).isEqualTo(6);
        assertThat(packet.getTypeId()).isEqualTo(4);
        assertThat(packet.getValue()).isEqualTo(2021);
        assertThat(packet.getLength()).isEqualTo(21);
    }

    @Test
    void parseOperatorPacketLengthTypeId0() {
        /*
        001 110 0 000000000011011 110 10001010 010 10010001001000000000
        VVV TTT I LLLLLLLLLLLLLLL AAA AAAAAAAA BBB BBBBBBBBBBBBB
         */

        OperatorPacket packet = (OperatorPacket) daySixteen.parsePacket("00111000000000000110111101000101001010010001001000000000");
        assertThat(packet.getVersionNumber()).isEqualTo(1);
        assertThat(packet.getTypeId()).isEqualTo(6);
        assertThat(packet.getLengthOfSubPackets()).isEqualTo(27);
        assertThat(packet.getNumberOfSubPackets()).isEqualTo(2);
        assertThat(packet.getLength()).isEqualTo(49);
        assertThat(packet.sumVersionNumbers()).isEqualTo(9);
    }

    @Test
    void parseOperatorPacketLengthTypeId1() {
        /*
        111 011 1 00000000011 010 10000001 100 10000010 001 10000011 00000
        VVV TTT I LLLLLLLLLLL AAAAAAAAAAABBBBBBBBBBBCCCCCCCCCCC
         */
        OperatorPacket packet = (OperatorPacket) daySixteen.parsePacket("11101110000000001101010000001100100000100011000001100000");
        assertThat(packet.getNumberOfSubPackets()).isEqualTo(3);
        assertThat(packet.getLengthOfSubPackets()).isEqualTo(33);
        assertThat(packet.sumVersionNumbers()).isEqualTo(14);
    }

    @Test
    void part1Example1() {
        String hexString = "8A004A801A8002F478";
        OperatorPacket packet = (OperatorPacket) daySixteen.parsePacket(DaySixteen.hexStringToBinary(hexString));
        assertThat(packet.getNumberOfSubPackets()).isEqualTo(1);
        assertThat(packet.sumVersionNumbers()).isEqualTo(16);
    }

    @Test
    void part1Example2() {
        String hexString = "620080001611562C8802118E34";
        OperatorPacket packet = (OperatorPacket) daySixteen.parsePacket(DaySixteen.hexStringToBinary(hexString));
        assertThat(packet.getNumberOfSubPackets()).isEqualTo(2);
        assertThat(packet.sumVersionNumbers()).isEqualTo(12);
    }

    @Test
    void part1Example3() {
        String hexString = "C0015000016115A2E0802F182340";
        String binaryString = DaySixteen.hexStringToBinary(hexString);
        OperatorPacket packet = (OperatorPacket) daySixteen.parsePacket(binaryString);
        assertThat(packet.getNumberOfSubPackets()).isEqualTo(2);
        assertThat(packet.sumVersionNumbers()).isEqualTo(23);
    }

    @Test
    void part1Example4() {
        String hexString = "A0016C880162017C3686B18A3D4780";
        String binaryString = DaySixteen.hexStringToBinary(hexString);
        OperatorPacket packet = (OperatorPacket) daySixteen.parsePacket(binaryString);
        assertThat(packet.getNumberOfSubPackets()).isEqualTo(1);
        assertThat(packet.sumVersionNumbers()).isEqualTo(31);
    }

    @Test
    void part1Solution() {
        String hexString = Utils.readInputLinesFromFile("day_sixteen.txt").get(0);
        String binaryString = DaySixteen.hexStringToBinary(hexString);
        OperatorPacket packet = (OperatorPacket) daySixteen.parsePacket(binaryString);
        assertThat(packet.sumVersionNumbers()).isEqualTo(940);
    }
}
