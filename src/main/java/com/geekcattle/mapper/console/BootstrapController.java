package com.geekcattle.mapper.console;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BootstrapController {

    @RequestMapping("/")
    public String index() {
        try {
            Boolean isAuth = SecurityUtils.getSubject().isAuthenticated();
            if (isAuth) {
                return "redirect:/console/index";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "console/login";
    }

}
