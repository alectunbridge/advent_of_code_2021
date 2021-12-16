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
    void parsePacket(){
        /*
        110100101111111000101000
        VVVTTTAAAAABBBBBCCCCC
         */
        Packet packet = daySixteen.parsePacket("110100101111111000101000");
        assertThat(packet.getVersionNumber()).isEqualTo(6);
        assertThat(packet.getTypeId()).isEqualTo(4);
        assertThat(packet.getValue()).isEqualTo(2021);
    }
}
