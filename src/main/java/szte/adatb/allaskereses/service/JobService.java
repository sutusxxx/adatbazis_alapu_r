package szte.adatb.allaskereses.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import szte.adatb.allaskereses.model.*;
import szte.adatb.allaskereses.model.job.CreateJob;
import szte.adatb.allaskereses.model.job.Job;
import szte.adatb.allaskereses.model.job.JobDetails;
import szte.adatb.allaskereses.model.job.UpdateJob;
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
        return this.repository.findAll();
    }

    public List<Job> getJobListForAdvertiser(int userId) {
        return this.repository.findAllForUser(userId);
    }

    public Job getJob(int id) {
        return this.repository.getJob(id);
    }

    public JobDetails getJobDetails(int id) {
        JobDetails jd = this.repository.getJobDetails(id);
        if (jd != null) {
            List<String> workType = this.repository.getWorkTypesForJob(jd.getId());
            jd.setWorkType(workType);
        }
        return jd;
    }

    public boolean createJob(CreateJob job) {
        return this.repository.create(job);
    }

    public boolean updateJob(UpdateJob job) {
        return this.repository.update(job);
    }

    public boolean applyJob(int jobId, int jobSeekerId) {
        return this.repository.applyJob(jobId, jobSeekerId);
    }

    public boolean deleteJob(int id, int userId) {
        return this.repository.delete(id, userId);
    }

    public boolean createCV(CreateCV cv) {
        return this.repository.create(cv);
    }
}
