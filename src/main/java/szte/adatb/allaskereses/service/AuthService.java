package szte.adatb.allaskereses.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import szte.adatb.allaskereses.model.JobSeeker;
import szte.adatb.allaskereses.model.LoginForm;
import szte.adatb.allaskereses.model.RegistrationForm;
import szte.adatb.allaskereses.repository.JobSeekerRepository;

@Service
public class AuthService {

    private JobSeekerRepository repository;

    @Autowired
    public AuthService(JobSeekerRepository repository) {
        this.repository = repository;
    }

    public void login(LoginForm loginForm) {

    }

    public void registration(RegistrationForm registrationForm) {

    }

    private boolean canLogin(JobSeeker user, String password) {
        if (user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}
