package com.sdpm.sf.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * @author shirukai
 */
@Controller
public class IndexController {
    @GetMapping("/")
    public String index(HttpServletResponse response) {
        return "index";
    }
}
