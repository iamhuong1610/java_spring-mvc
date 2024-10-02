package vn.hoidanit.laptopshop.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import ch.qos.logback.core.model.Model;
import vn.hoidanit.laptopshop.domain.Product;

import vn.hoidanit.laptopshop.service.UserService;

@Controller
public class HomePageController {

    @GetMapping("/")
    public String getHomePage() {
        return "client/homepage/show";
    }

}
