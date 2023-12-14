package ute.ecommerce_fe.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
    @GetMapping(value = "/admin")
	public String admin() {
        return "admin/index";
    }
}
