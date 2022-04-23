package szte.adatb.allaskereses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import szte.adatb.allaskereses.model.Job;
import szte.adatb.allaskereses.model.JobSeeker;
import szte.adatb.allaskereses.service.JobService;

import java.util.List;

@RestController
public class JobController {
    JobService service;

    @Autowired
    public JobController(JobService service) {
        this.service = service;
    }

    @GetMapping("/jobs")
    public List<Job> getJobList() {
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

    public void deleteJob(@PathVariable("jobId") int id, @PathVariable("userId") int userId) {
        service.deleteJob(id, userId);
    }
}
