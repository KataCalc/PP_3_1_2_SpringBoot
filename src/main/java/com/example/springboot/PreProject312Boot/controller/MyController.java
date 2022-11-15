package com.example.springboot.PreProject312Boot.controller;


import com.example.springboot.PreProject312Boot.model.User;
import com.example.springboot.PreProject312Boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class MyController {

    private UserService userService;

    @Autowired
    public MyController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String showAllUsers(Model model) {
        List<User> users = userService.allUsers();
        model.addAttribute("users", users);
        return "users/index";
    }

    @GetMapping("/{id}")
    public String showOneUserById(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "users/show";
    }

    @GetMapping(value = "/new")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "users/new";
    }

    @PostMapping()
    public String getUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String editUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUser(id));
        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.updateUserEndSave(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUserByID(@PathVariable(name = "id") int id) {
        userService.delete(id);
        return "redirect:/users";
    }

}
