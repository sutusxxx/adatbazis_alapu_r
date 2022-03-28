package szte.adatb.allaskereses.repository;

import szte.adatb.allaskereses.model.Szekhely;

import java.util.List;

public interface SzekhelyRepository {
    List<Szekhely> findAll();
}
