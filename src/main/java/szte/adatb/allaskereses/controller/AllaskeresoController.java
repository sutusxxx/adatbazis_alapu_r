package szte.adatb.allaskereses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import szte.adatb.allaskereses.model.Allaskereso;
import szte.adatb.allaskereses.service.AllaskeresoService;

import java.util.List;

@RestController
public class AllaskeresoController {
    private final AllaskeresoService service;

    @Autowired
    public AllaskeresoController(AllaskeresoService service) {
        this.service = service;
    }

    @GetMapping("/allaskeresok")
    public List<Allaskereso> getAllAllaskereso() {
        return this.service.getAll();
    }
}
