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

    /**
     * @param abbreviation MUST be the RL100Code of the requested Betriebsstelle
     * @return <b>200 OK</b> will be returned if the requested
     * {@link com.github.sebastianmann.betriebsstellenrestapi.data.Betriebsstelle} was found. The response will contain
     * the {@link com.github.sebastianmann.betriebsstellenrestapi.data.Betriebsstelle}-object.
     * <br><b>404 Not Found</b> will be returned if the requested
     * {@link com.github.sebastianmann.betriebsstellenrestapi.data.Betriebsstelle} was not found.
     */
    @GetMapping("/{abbreviation}")
    public ResponseEntity<Betriebsstelle> getBetriebsstelle(@PathVariable String abbreviation) {
        Betriebsstelle betriebsstelle = BetriebsstellenProvider.getByID(abbreviation);
//        System.out.println(betriebsstelle);

        if (betriebsstelle == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(betriebsstelle, HttpStatus.OK);
    }


}
