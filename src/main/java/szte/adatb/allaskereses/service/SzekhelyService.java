package szte.adatb.allaskereses.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import szte.adatb.allaskereses.model.Szekhely;
import szte.adatb.allaskereses.repository.SzekhelyRepository;

import java.util.List;

@Service
public class SzekhelyService {

    @Autowired
    SzekhelyRepository repository;

    public List<Szekhely> getAll() {
        return repository.findAll();
    }
}
