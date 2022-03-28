package szte.adatb.allaskereses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import szte.adatb.allaskereses.model.Szekhely;
import szte.adatb.allaskereses.service.SzekhelyService;

import java.util.List;

@RestController
public class SzekhelyController {
    private final SzekhelyService service;

    @Autowired
    public SzekhelyController(SzekhelyService service) {
        this.service = service;
    }

    @GetMapping("/szekhelyek")
    public List<Szekhely> getAllSzekhely() {
        return this.service.getAll();
    }
}
