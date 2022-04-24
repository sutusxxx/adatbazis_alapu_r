package szte.adatb.allaskereses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import szte.adatb.allaskereses.model.Advertiser;
import szte.adatb.allaskereses.model.JobSeeker;
import szte.adatb.allaskereses.model.LoginForm;
import szte.adatb.allaskereses.model.RegistrationForm;
import szte.adatb.allaskereses.service.AuthService;

@RestController
public class AuthController {
    private AuthService service;

    @Autowired
    public AuthController(AuthService service) {
        this.service = service;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/login/jobseeker")
    public JobSeeker loginJobSeeker(@RequestBody LoginForm loginForm) {
        System.out.println("Bejelentkezés álláskeresőként");
        return service.loginJobSeeker(loginForm);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/login/advertiser")
    public Advertiser loginAdvertiser(@RequestBody LoginForm loginForm) {
        System.out.println("Bejelentkezés hirdetőként");
        return service.loginAdvertiser(loginForm);
    }

    @PostMapping("/registration")
    public void registration(@RequestBody RegistrationForm registrationForm) {
        service.registration(registrationForm);
    }
}
