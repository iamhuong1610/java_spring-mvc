package vn.hoidanit.laptopshop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.hoidanit.laptopshop.domain.Product;

import org.springframework.ui.Model;

@Controller
public class ProductController {

    @GetMapping("/admin/product")

    public String getProduct() {
        return "admin/product/show";
    }

    @GetMapping("/admin/product/create")
    public String getMethodName(Model model) {
        model.addAttribute("new Product", new Product());
        return "admin/product/create";
    }

}
