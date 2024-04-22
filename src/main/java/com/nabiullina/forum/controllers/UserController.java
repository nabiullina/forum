package com.nabiullina.forum.controllers;

import com.nabiullina.forum.models.User;
import com.nabiullina.forum.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "users";
    }

//    @GetMapping("/users/{name}")
//    public String users(@RequestParam(name="name", required = false) @PathVariable String name, Model model) {
//        model.addAttribute("users", userService.getUsersByName(name));
//
//        return "users";
//    }

    @PostMapping("/user/create")
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @PostMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
