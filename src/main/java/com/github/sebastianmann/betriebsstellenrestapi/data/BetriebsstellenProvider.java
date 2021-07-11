package com.github.sebastianmann.betriebsstellenrestapi.data;

import com.github.sebastianmann.betriebsstellenrestapi.BetriebsstellenRestApiApplication;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BetriebsstellenProvider {

    private final Map<String, Betriebsstelle> betriebsstellen;

    public BetriebsstellenProvider() {
        betriebsstellen = new HashMap<>();
    }

    @PostConstruct
    public void populateMap() {
        InputStream file = BetriebsstellenRestApiApplication.class.getResourceAsStream("/betriebsstellen.csv");

        BufferedReader br = new BufferedReader(new InputStreamReader(file));
        List<String> lines = br.lines().skip(1).toList();

        for (String line : lines) {
            String[] columns = line.split(";");
//            System.out.println(Arrays.toString(columns));
            betriebsstellen.put(
                    columns[1],//.replaceAll(" ", "_").replaceAll("__", "_"),
                    new Betriebsstelle(
                            columns[0],
                            columns[1],
                            columns[2],
                            columns[3],
                            columns[4],
                            columns[5],
                            columns[6],
                            tryParseInt(columns[7]),
                            tryParseInt(columns[8]),
                            tryParseInt(columns[9]),
                            columns[10],
                            tryParseInt(columns[11])
                    )
            );
        }
    }

    private Integer tryParseInt(String input) {
//        System.out.println("Input: " + input);
        Integer output = null;
        if (input != null) {
            try {
                output = Integer.parseInt(input);
            } catch (NumberFormatException ignored) {
            }
        }
        return output;
    }

    public Betriebsstelle getByID(String id) {
//        System.out.println(id.toUpperCase());
        return betriebsstellen.get(id.toUpperCase());
    }

}
