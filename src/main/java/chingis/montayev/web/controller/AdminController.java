package chingis.montayev.web.controller;

import chingis.montayev.web.model.Role;
import chingis.montayev.web.model.User;
import chingis.montayev.web.services.RoleService;
import chingis.montayev.web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;


    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String user(Principal principal,Model model){
        final String name = principal.getName();
        final User admin = userService.getByName(name);
        model.addAttribute("admin",admin);
        model.addAttribute("roles", admin.getRoles());
        return "admin";
    }

    @GetMapping("/users/{id}")
    public String getUserById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("admin", userService.getUserById(id).getRoles());
        return "userById";
    }

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/users/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("rolesNames", roleService.getAll());
        return "new";
    }

    @PostMapping("/users")
    public String addUser(@ModelAttribute("user") User user,@RequestParam(value = "rolesNames") String[] roles) {
        Set<Role> roleSet = new HashSet<>();
        for (String role:roles) {
            roleSet.add(roleService.getByName(role));
        }
        user.setRoles(roleSet);
        userService.add(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/users/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("rolesNames", roleService.getAll());
        return "edit";
    }

    @PatchMapping("/users/{id}")
    public String update(@PathVariable("id") Long id,
                         @ModelAttribute("user") User user,
                         @RequestParam(value = "rolesNames")String[]roles) {
        Set<Role> roleSet = new HashSet<>();
        for (String role:roles) {
            roleSet.add(roleService.getByName(role));
        }
        user.setRoles(roleSet);
        userService.update(user);
        return "redirect:/admin/users";
    }

    @DeleteMapping("/users/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/admin/users";
    }

    @ModelAttribute("headerMessage")
    public String header() {
        return "spring-crud-2.3.1";
    }
}





