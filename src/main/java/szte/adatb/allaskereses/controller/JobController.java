package szte.adatb.allaskereses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import szte.adatb.allaskereses.model.CreateJob;
import szte.adatb.allaskereses.model.Job;
import szte.adatb.allaskereses.model.JobDetails;
import szte.adatb.allaskereses.service.JobService;

import java.util.List;
import java.util.Optional;

@RestController
public class JobController {
    JobService service;

    @Autowired
    public JobController(JobService service) {
        this.service = service;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/jobs")
    public List<Job> getJobList(@RequestParam Optional<Integer> id) {
        System.out.println("getJobList called");
        if (id.isPresent()) {
            return service.getJobListForAdvertiser(id.get());
        }
        return service.getJobs();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("job/{id}")
    public JobDetails getJobDetails(@PathVariable("id") int id) {
        System.out.println("getJobDetails called");
        return service.getJobDetails(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("jobs/create")
    public boolean createJob(@RequestBody CreateJob job) {
        System.out.println("createJob called");
        return service.createJob(job);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("job/apply")
    public boolean applyJob(@RequestParam(name = "job") int id, @RequestParam(name = "user") int userId) {
        System.out.println("applyJob called");
        return service.applyJob(id, userId);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/job/delete")
    public boolean deleteJob(@RequestParam(name = "job") int id, @RequestParam(name = "user") int userId) {
        System.out.println("deleteJob called");
        return service.deleteJob(id, userId);
    }
}
