package szte.adatb.allaskereses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import szte.adatb.allaskereses.model.LoginForm;
import szte.adatb.allaskereses.service.LoginService;

@RestController
public class LoginController {
    private LoginService service;

    @Autowired
    public LoginController(LoginService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public void login(@RequestBody LoginForm loginForm) {
        service.login(loginForm.getUsername(), loginForm.getPassword());
    }
}
