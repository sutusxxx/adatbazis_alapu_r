package szte.adatb.allaskereses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import szte.adatb.allaskereses.service.LoginService;

@Controller
public class LoginController {
    private LoginService service;

    @Autowired
    public LoginController(LoginService service) {
    }

    @RequestMapping("/login")
    public String getLoginPage(Model model) {
        return "login";
    }
}
