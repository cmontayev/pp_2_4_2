package chingis.montayev.web.controller;

import chingis.montayev.web.model.User;
import chingis.montayev.web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String user(Principal principal,Model model){
        final String name = principal.getName();
        User user = userService.getByName(name);
        model.addAttribute("user", user);
        return "user";
    }



//    @GetMapping()
//    public String getAllUsers(Model model) {
//        model.addAttribute("users", userService.getAllUsers());
//        return "users/index";
//    }
//
//    @GetMapping("/{id}")
//    public String getUserById(@PathVariable("id") Long id, Model model) {
//        model.addAttribute("user", userService.getUserById(id));
//        return "users/userById";
//    }
//
//
//    @GetMapping("/newUser")
//    public String newUser(@ModelAttribute("user") User user) {
//        return "users/newUser";
//    }
//
//    @PostMapping()
//    public String addUser(@ModelAttribute("user") User user) {
//        userService.add(user);
//        return "redirect:/users";
//    }

//    @GetMapping("/{id}/edit")
//    public String edit(Model model, @PathVariable("id") Long id) {
//        model.addAttribute("user", userService.getUserById(id));
//        return "users/edit";
//    }

//    @PatchMapping("/{id}")
//    public String update(@ModelAttribute("user") User user) {
//        userService.update(user);
//        return "redirect:/users";
//    }

//    @DeleteMapping("/{id}")
//    public String delete(@PathVariable("id") Long id) {
//        userService.delete(id);
//        return "redirect:/users";
//    }

    @ModelAttribute("headerMessage")
    public String header() {
        return "spring-crud-2.3.1";
    }
}





