package ml.sadriev.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/welcome.html")
public class WelcomeController {

    @RequestMapping(value="/welcome")
    public String index(Model model) {
        return "welcome";
    }
}