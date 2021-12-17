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
    void parseLiteralPacket(){
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
    void parseOperatorPacket() {
        /*
        00111000000000000110111101000101001010010001001000000000
        VVVTTTILLLLLLLLLLLLLLLAAAAAAAAAAABBBBBBBBBBBBBBBB
         */

        OperatorPacket packet = (OperatorPacket) daySixteen.parsePacket("00111000000000000110111101000101001010010001001000000000");
        assertThat(packet.getVersionNumber()).isEqualTo(1);
        assertThat(packet.getTypeId()).isEqualTo(6);
        assertThat(packet.getLengthOfSubPackets()).isEqualTo(27);
        assertThat(packet.getLength()).isEqualTo(49);
    }
}
