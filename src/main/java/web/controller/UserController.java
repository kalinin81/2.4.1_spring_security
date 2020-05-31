package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import javax.servlet.http.HttpServlet;

@Controller
@RequestMapping("/")
public class UserController extends HttpServlet {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @GetMapping(value = "login")
    public String loginGet() {
        return "login";
    }
    @GetMapping(value = "admin")
    public String usersGet(ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());
        return "admin";
    }
    @GetMapping(value = "user")
    public String userGet() {
        return "user";
    }

    @GetMapping(value = "edit")
    public String editGet(ModelMap model, User user) {
        model.addAttribute("user", user);
        return "edit";
    }
    @PostMapping(value = "edit")
    public String editPost(User user) {
        userService.update(user);
        return "redirect:/admin";
    }

    @PostMapping(value = "add")
    public String addPost(ModelMap model, @RequestParam("login") String login, @RequestParam("password") String password, @RequestParam("email") String email) {
        userService.insert(login, password, email);
        //model.addAttribute("users", userService.getAllUsers());
        return "redirect:/admin";
    }

    @PostMapping(value = "delete")
    public String deletePost(User user) {
        userService.deleteUser(user);
        return "redirect:/admin";
    }

}
