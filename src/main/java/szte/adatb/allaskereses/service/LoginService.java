package szte.adatb.allaskereses.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import szte.adatb.allaskereses.model.JobSeeker;
import szte.adatb.allaskereses.repository.JobSeekerRepository;

@Service
public class LoginService {

    private JobSeekerRepository repository;

    @Autowired
    public LoginService(JobSeekerRepository repository) {
        this.repository = repository;
    }

    public void login(String username, String password) {
        JobSeeker user = repository.findByUsername(username);
        if(canLogin(user, password)) {
            System.out.println("Siker");
        } else {
            System.out.println(":(((((");
        }
    }

    private boolean canLogin(JobSeeker user, String password) {
        if (user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}
