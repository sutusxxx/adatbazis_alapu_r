package szte.adatb.allaskereses.repository;

import szte.adatb.allaskereses.model.Admin;

import java.util.List;

public interface AdminRepository {
    List<Admin> findAll();
}
