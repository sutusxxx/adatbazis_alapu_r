package szte.adatb.allaskereses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import szte.adatb.allaskereses.model.Admin;
import szte.adatb.allaskereses.service.AdminService;

import java.util.List;

@RestController
public class AdminController {
    private final AdminService service;

    @Autowired
    public AdminController(AdminService service) {
        this.service = service;
    }

    @GetMapping("/adminok")
    public List<Admin> getAllAdmin() {
        return this.service.getAll();
    }
}
