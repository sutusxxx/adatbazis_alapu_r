package szte.adatb.allaskereses.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import szte.adatb.allaskereses.model.CreateJob;
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
        return this.repository.findAll();
    }

    public List<Job> getJobListForAdvertiser(int userId) {
        return this.repository.findAllForUser(userId);
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

    public boolean applyJob(int jobId, int jobSeekerId) {
        return this.repository.applyJob(jobId, jobSeekerId);
    }

    public boolean deleteJob(int id, int userId) {
        return this.repository.delete(id, userId);
    }
}
