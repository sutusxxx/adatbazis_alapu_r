package szte.adatb.allaskereses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
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

    @PostMapping("/login")
    public void login(@RequestBody LoginForm loginForm) {
        service.login(loginForm);
    }

    @PostMapping("/registration")
    public void registration(@RequestBody RegistrationForm registrationForm) {
        service.registration(registrationForm);
    }
}
