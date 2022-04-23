package szte.adatb.allaskereses.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import szte.adatb.allaskereses.model.*;
import szte.adatb.allaskereses.repository.UserRepository;

@Service
public class AuthService {

    private UserRepository repository;

    @Autowired
    public AuthService(UserRepository repository) {
        this.repository = repository;
    }

    public JobSeeker loginJobSeeker(LoginForm loginForm) {
        int id = repository.loginUser(loginForm, "allaskereso");
        if (id > -1) {
            return repository.getJobSeeker(id);
        }
        return null;
    }

    public Advertiser loginAdvertiser(LoginForm loginForm) {
        int id = repository.loginUser(loginForm, "hirdeto");
        if (id > -1) {
            return repository.getAdvertiser(id);
        }
        return null;
    }

    public Admin loginAdmin(LoginForm loginForm) {
        int id = repository.loginUser(loginForm, "admin");
        if (id > -1) {
            return repository.getAdmin(id);
        }
        return null;
    }

    public void registration(RegistrationForm registrationForm) {

    }
}
