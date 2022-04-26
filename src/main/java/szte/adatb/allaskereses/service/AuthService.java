package szte.adatb.allaskereses.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import szte.adatb.allaskereses.model.*;
import szte.adatb.allaskereses.repository.UserRepository;

import java.util.List;
import java.util.Map;

@Service
public class AuthService {

    private UserRepository repository;

    @Autowired
    public AuthService(UserRepository repository) {
        this.repository = repository;
    }

    public JobSeeker loginJobSeeker(LoginForm loginForm) {
        JobSeeker jobSeeker = repository.loginJobSeeker(loginForm);
        if (jobSeeker != null) {
            Map<String, String> applications = repository.findApplicationsForUser(jobSeeker.getId());
            jobSeeker.setApplications(applications);
        }
        return jobSeeker;
    }

    public Advertiser loginAdvertiser(LoginForm loginForm) {
        Advertiser advertiser = repository.loginAdvertiser(loginForm);
        return advertiser;
    }

    public Admin loginAdmin(LoginForm loginForm) {
        return null;
    }

    public boolean registrationForJobSeeker(CreateJobSeeker jobSeeker) {
        return repository.createJobSeeker(jobSeeker);
    }

    public boolean registrationForAdvertiser(CreateAdvertiser advertiser) {
        return repository.createAdvertiser(advertiser);
    }
}
