package com.github.sebastianmann.betriebsstellenrestapi.web;

import com.github.sebastianmann.betriebsstellenrestapi.data.Betriebsstelle;
import com.github.sebastianmann.betriebsstellenrestapi.data.BetriebsstellenProvider;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/betriebsstelle/")
public class BetriebsstellenController {

    private final BetriebsstellenProvider betriebsstellenProvider;

    @GetMapping("/{abbreviation}")
    public ResponseEntity<Betriebsstelle> getBetriebsstelle(@PathVariable String abbreviation) {
        Betriebsstelle betriebsstelle = betriebsstellenProvider.getByID(abbreviation);
//        System.out.println(betriebsstelle);

        if (betriebsstelle == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(betriebsstelle, HttpStatus.OK);
    }

}
