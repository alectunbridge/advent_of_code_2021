package adventofcode2021;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DaySixteenTest {

    DaySixteen daySixteen = new DaySixteen();

    @Test
    void exampleHex() {
        assertThat(daySixteen.hexStringToBinary("D2FE28")).isEqualTo("110100101111111000101000");
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
        assertThat(packet.getLength()).isEqualTo(49);
        assertThat(packet.sumVersionNumbers()).isEqualTo(9);
    }

    @Test
    void parseOperatorPacketLengthTypeId1() {
        /*
        111 011 1 00000000011 010 10000001 100 10000010 001 10000011 00000
        VVV TTT I LLLLLLLLLLL AAA AAAAAAAA BBB BBBBBBBB CCC CCCCCCCC
         */
        OperatorPacket packet = (OperatorPacket) daySixteen.parsePacket("11101110000000001101010000001100100000100011000001100000");
        assertThat(packet.getNumberOfSubPackests()).isEqualTo(3);
        assertThat(packet.sumVersionNumbers()).isEqualTo(14);
    }
}
