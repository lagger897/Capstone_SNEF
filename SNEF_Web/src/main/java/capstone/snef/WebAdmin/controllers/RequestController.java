/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.snef.WebAdmin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Phuc Nguyen -VN
 */
@Controller
public class RequestController {
    @RequestMapping("/")
    public String home(){
        return "homepage.jsp";
    }
    @RequestMapping("/test")
    public String layout(){
        return "Layout/layout.jsp";
    }
}
