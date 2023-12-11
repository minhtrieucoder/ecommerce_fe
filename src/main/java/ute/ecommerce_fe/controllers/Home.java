package ute.ecommerce_fe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {
    @GetMapping(value = "/")
    public String Hello() {
        return "app";
    }
}
