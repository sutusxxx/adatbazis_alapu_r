package szte.adatb.allaskereses.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import szte.adatb.allaskereses.model.Allaskereso;
import szte.adatb.allaskereses.repository.AllaskeresoRepository;

import java.util.List;

@Service
public class AllaskeresoService {

    @Autowired
    AllaskeresoRepository repository;

    public List<Allaskereso> getAll() {
        return repository.findAll();
    }
}
