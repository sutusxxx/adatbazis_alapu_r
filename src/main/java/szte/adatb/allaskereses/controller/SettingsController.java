package szte.adatb.allaskereses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import szte.adatb.allaskereses.model.user.Advertiser;
import szte.adatb.allaskereses.model.user.JobSeeker;
import szte.adatb.allaskereses.service.SettingsService;

@RestController
public class SettingsController {
    private SettingsService service;

    @Autowired
    public SettingsController(SettingsService service) {
        this.service = service;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/jobSeeker/get")
    public JobSeeker getJobSeeker(int id) {
        return service.getJobSeeker(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/advertiser/get")
    public Advertiser getAdvertiser(@RequestParam int id) {
        return service.geAdvertiser(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/jobSeeker/update")
    public void updateJobSeeker(JobSeeker jobSeeker) {

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/advertiser/update")
    public void updateAdvertiser(Advertiser advertiser) {

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/application/delete")
    public boolean deleteApplication(@RequestParam(name = "job") int jobId, @RequestParam(name = "user") int userId) {
        return service.deleteApplication(userId, jobId);
    }
}
