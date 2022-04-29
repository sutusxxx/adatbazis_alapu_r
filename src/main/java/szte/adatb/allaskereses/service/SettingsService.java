package szte.adatb.allaskereses.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import szte.adatb.allaskereses.model.user.Advertiser;
import szte.adatb.allaskereses.model.user.JobSeeker;
import szte.adatb.allaskereses.repository.UserRepository;

import java.util.Map;

@Service
public class SettingsService {
    UserRepository repository;

    @Autowired
    public SettingsService(UserRepository repository) {
        this.repository = repository;
    }

    public JobSeeker getJobSeeker(int id) {
        JobSeeker jobSeeker = repository.findJobSeeker(id);
        if (jobSeeker != null) {
            Map<String, String> applications = repository.findApplicationsForUser(jobSeeker.getId());
            jobSeeker.setApplications(applications);
        }
        return jobSeeker;
    }

    public Advertiser geAdvertiser(int id) {
        return repository.findAdvertiser(id);
    }

    public boolean deleteApplication(int userId, int jobId) {
        return repository.deleteApplication(userId, jobId);
    }
}
