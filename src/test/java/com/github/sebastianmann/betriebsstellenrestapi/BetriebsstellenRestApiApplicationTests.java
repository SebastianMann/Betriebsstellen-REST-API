package com.github.sebastianmann.betriebsstellenrestapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.sebastianmann.betriebsstellenrestapi.data.Betriebsstelle;
import com.github.sebastianmann.betriebsstellenrestapi.data.BetriebsstellenProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BetriebsstellenRestApiApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private BetriebsstellenProvider betriebsstellenProvider;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testSimpleBetriebsstelle() {
        assertThat(
                this.restTemplate
                        .withBasicAuth("user", "password")
                        .getForObject("http://localhost:" + port + "/betriebsstelle/aa", String.class))
                .isEqualTo("{" +
                        "\"plc\":\"DE14421\"," +
                        "\"rl100Code\":\"AA\"," +
                        "\"rl100NameLong\":\"Hamburg-Altona\"," +
                        "\"rl100NameShort\":\"Hamburg-Altona\"," +
                        "\"typeShort\":\"BF\"," +
                        "\"typeLong\":\"Bf\"," +
                        "\"operationCondition\":\"Betrieb\"," +
                        "\"dateFrom\":20200401," +
                        "\"branch\":2," +
                        "\"region\":\"Nord\"," +
                        "\"lastChange\":20201029" +
                        "}");
    }

    @Test
    void testBetriebstelleWithWhitespaces() {
        assertThat(
                this.restTemplate
                        .withBasicAuth("user", "password")
                        .getForObject("http://localhost:" + port + "/betriebsstelle/aa  g", String.class))
                .isEqualTo("{" +
                        "\"plc\":\"DE14423\"," +
                        "\"rl100Code\":\"AA  G\"," +
                        "\"rl100NameLong\":\"Hamburg-Altona Gbf\"," +
                        "\"rl100NameShort\":\"Hmb-Altona Gbf\"," +
                        "\"typeShort\":\"BFT\"," +
                        "\"typeLong\":\"Bft\"," +
                        "\"operationCondition\":\"Betrieb\"," +
                        "\"dateFrom\":20081214," +
                        "\"branch\":2," +
                        "\"region\":\"Nord\"," +
                        "\"lastChange\":20201029" +
                        "}");
    }

    @Test
    void testRandomBetriebsstelle() throws JsonProcessingException {
        Betriebsstelle betriebsstelle = betriebsstellenProvider.getRandomBetriebstelle();
        assertThat(
                this.restTemplate
                        .withBasicAuth("user", "password")
                        .getForObject("http://localhost:" + port + "/betriebsstelle/" + betriebsstelle.getRl100Code(), String.class)
        ).isEqualTo(new ObjectMapper().writeValueAsString(betriebsstelle));

    }

}
