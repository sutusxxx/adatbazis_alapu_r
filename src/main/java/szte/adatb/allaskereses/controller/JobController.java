package szte.adatb.allaskereses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import szte.adatb.allaskereses.model.Job;
import szte.adatb.allaskereses.model.JobSeeker;
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
        System.out.println("jobs called");
        if (id.isPresent()) {
            return service.getJobListForAdvertiser(id.get());
        }
        return service.getJobs();
    }

    @GetMapping("job/{id}")
    public Job getJobDetails(@PathVariable("id") int id) {
        return service.getJobDetails(id);
    }

    @PutMapping("job/apply/{id}")
    public void applyJob(@PathVariable("id") int jobId, int jobSeekerId) {
        service.applyJob(jobId, jobSeekerId);
    }

    @DeleteMapping("/job/delete/{id}")
    public void deleteJob(@PathVariable("id") int id, @PathVariable("userId") int userId) {
        service.deleteJob(id, userId);
    }
}
