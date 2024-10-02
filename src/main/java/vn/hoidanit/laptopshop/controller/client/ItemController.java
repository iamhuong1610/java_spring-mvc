package vn.hoidanit.laptopshop.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ch.qos.logback.core.model.Model;
import vn.hoidanit.laptopshop.domain.Product;

@Controller
public class ItemController {

    @GetMapping("/product/{id}")
    public String getDetailProductPage(Model model, @PathVariable long id) {

        return "client/product/detail";
    }
}