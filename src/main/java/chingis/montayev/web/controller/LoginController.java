package chingis.montayev.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping()
public class LoginController {

    @GetMapping("/login")
    public String login(Model model) {
//        List<String> messages = new ArrayList<>();
//        messages.add("Hello!");
//        messages.add("I'm a SPRING-MVC-SECURITY app.");
//        messages.add("Task springCrudSecurity-242.");
//        model.addAttribute("helloMessages", messages);
        return "login";
    }

}
