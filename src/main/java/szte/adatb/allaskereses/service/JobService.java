package szte.adatb.allaskereses.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import szte.adatb.allaskereses.model.Job;
import szte.adatb.allaskereses.model.JobDetails;
import szte.adatb.allaskereses.repository.JobRepository;

import java.util.List;

@Service
public class JobService {
    JobRepository repository;

    @Autowired
    public JobService(JobRepository repository) {
        this.repository = repository;
    }

    public List<Job> getJobs() {
        return repository.findAll();
    }

    public List<Job> getJobListForAdvertiser(int userId) {
        return repository.findAllForUser(userId);
    }

    public JobDetails getJobDetails(int id) {
        return repository.getJobDetails(id);
    }

    public void applyJob(int jobId, int jobSeekerId) {
        repository.applyJob(jobId, jobSeekerId);
    }

    public void deleteJob(int id, int userId) {
        repository.delete(id, userId);
    }
}
