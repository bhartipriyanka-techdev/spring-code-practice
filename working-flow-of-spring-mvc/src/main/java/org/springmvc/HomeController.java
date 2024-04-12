package org.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping(value = "/open-home")
    public String openHomePage(Model model){
        model.addAttribute("username", "Piya");
        return "home";
    }
}
