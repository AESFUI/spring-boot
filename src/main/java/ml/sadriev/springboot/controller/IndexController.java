package ml.sadriev.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/index.html")
public class IndexController {

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        return "index";
    }
}