package com.matrix.locale.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {
    @RequestMapping("/locale")
    public String locale() {
        return "locale";
    }

    /**
     * 登陆页面
     */
    @GetMapping("/")
    public ModelAndView index() {
        return new ModelAndView("user/login");
    }

}
