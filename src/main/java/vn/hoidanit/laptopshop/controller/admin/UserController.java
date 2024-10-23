package vn.hoidanit.laptopshop.controller.admin;

import vn.hoidanit.laptopshop.domain.User;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import vn.hoidanit.laptopshop.service.UpLoadService;
import vn.hoidanit.laptopshop.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;

// mô hình mvc
@Controller

public class UserController {

    private final UserService userService;
    private final UpLoadService upLoadService;

    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, UpLoadService upLoadService,
            PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.upLoadService = upLoadService;
        this.passwordEncoder = passwordEncoder;

    }

    @RequestMapping("/")

    public String getHomPage(Model model) {
        List<User> arrUsers = this.userService.getAllUsersByEmail("huongthienbinh2003@gmail.com");
        System.out.println(arrUsers);

        model.addAttribute("eric", "test");
        model.addAttribute("huong", "from controller with model");

        return "hello";
    }

    @RequestMapping("/admin/user") // get
    public String getUserPage(Model model) {
        List<User> users = this.userService.getAllUsers();
        System.out.println(">>> check user: " + users);
        model.addAttribute("user1", users);
        return "admin/user/show";
    }

    @RequestMapping("/admin/user/{id}") // get
    public String getDetailUserPage(Model model, @PathVariable long id) {
        System.out.println("Check path id: " + id);
        User user = this.userService.findUserById(id);
        model.addAttribute("user1", user);
        model.addAttribute("id", id);
        return "admin/user/detail";
    }

    @RequestMapping("/admin/user/update/{id}") // get
    public String getUpdateUserPage(Model model, @PathVariable long id) {
        System.out.println("Check path id: " + id);
        User currentUser = this.userService.findUserById(id);
        model.addAttribute("newUser", currentUser);

        return "admin/user/update";
    }

    @PostMapping("/admin/user/update")
    public String postUpdateUser(Model model, @ModelAttribute("newUser") User huong) {
        User currentUser = this.userService.findUserById(huong.getId());
        if (currentUser != null) {
            System.out.println("run here: ");
            currentUser.setAddress(huong.getAddress());
            currentUser.setFullName(huong.getFullName());
            currentUser.setPhone(huong.getPhone());
            this.userService.handleSaveUser(currentUser);

        }

        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user/create")

    // get
    public String getCreateUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @PostMapping(value = "/admin/user/create")

    public String createUserPage(Model model, @ModelAttribute("newUser") @Valid User huong,
            BindingResult newUserBindingResult,
            @RequestParam("hoidanitFile") MultipartFile file) {

        // List<FieldError> errors = newUserBindingResult.getFieldErrors();
        // for (FieldError error : errors) {
        // System.out.println(error.getField() + " - " + error.getDefaultMessage());
        // }
        if (newUserBindingResult.hasErrors()) {
            return "admin/user/create";
        }

        String avatar = this.upLoadService.handleSaveUploadFile(file, "avatar");
        String hashPassword = this.passwordEncoder.encode(huong.getPassword());

        huong.setPassword(hashPassword);
        huong.setAvatar(avatar);
        huong.setRole(this.userService.getRoleByName(huong.getRole().getName()));
        this.userService.handleSaveUser(huong);

        System.out.println("run here" + huong);
        // this.userService.handleSaveUser(huong);
        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user/delete/{id}")
    public String deleteUserPage(Model model, @PathVariable long id) {

        model.addAttribute("id", id);
        model.addAttribute("newUser", new User());

        return "admin/user/delete";
    }

    @PostMapping("/admin/user/delete")
    public String postDeleteUser(Model model, @ModelAttribute("newUser") User huong) {
        this.userService.deleteAUser(huong.getId());
        System.out.println("run here: ");
        return "redirect:/admin/user";
    }

}
