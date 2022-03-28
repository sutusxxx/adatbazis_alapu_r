package szte.adatb.allaskereses.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import szte.adatb.allaskereses.model.Admin;
import szte.adatb.allaskereses.repository.AdminRepository;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    AdminRepository repository;

    public List<Admin> getAll() {
        return repository.findAll();
    }
}
