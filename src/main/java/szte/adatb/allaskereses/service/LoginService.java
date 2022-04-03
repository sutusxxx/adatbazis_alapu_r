package szte.adatb.allaskereses.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import szte.adatb.allaskereses.model.User;
import szte.adatb.allaskereses.repository.UserRepository;

@Service
public class LoginService {

    private UserRepository repository;

    @Autowired
    public LoginService(UserRepository repository) {
    }

    public void login(String username, String password) {
        User user = repository.findByUsername(username);
        if(canLogin(user, password)) {
            System.out.println("Siker");
        } else {
            System.out.println(":(((((");
        }
    }

    private boolean canLogin(User user, String password) {
        if (user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}
