package vn.hoidanit.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.hoidanit.laptopshop.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//mô hình mvc
// @Controller

// public class UserController {

//     @RequestMapping("/")
//     public String getHomPage() {

//         return "hello from controller";
//     }

// mô hình restful api
@RestController

public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String getHomPage() {

        return this.userService.handleHello();
    }
}
