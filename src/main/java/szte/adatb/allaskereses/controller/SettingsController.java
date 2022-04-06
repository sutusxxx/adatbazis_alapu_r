package szte.adatb.allaskereses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import szte.adatb.allaskereses.model.JobSeeker;
import szte.adatb.allaskereses.service.SettingsService;

@RestController
public class SettingsController {
    private SettingsService service;

    @Autowired
    public SettingsController(SettingsService service) {
        this.service = service;
    }

    @PostMapping("/jobSeeker/update")
    public void updateJobSeeker(JobSeeker jobSeeker) {

    }
}