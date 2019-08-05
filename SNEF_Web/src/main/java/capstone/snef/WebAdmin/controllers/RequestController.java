/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.snef.WebAdmin.controllers;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

/**
 *
 * @author Phuc Nguyen -VN
 */
@Controller
@RequestMapping("/")
public class RequestController {

    @RequestMapping("/storeProduct")
    public String storeProductPage(HttpSession session) {
        if(!isLogin(session)){
            return "login";
        }
        return "storeproduct";
    }

    @RequestMapping("/addStoreProduct")
    public String addStoreProductPage(HttpSession session) {
         if(!isLogin(session)){
            return "login";
        }
        return "addProduct";
    }

    @RequestMapping("/order")
    public String orderPage(HttpSession session) {
         if(!isLogin(session)){
            return "login";
        }
        return "order";
    }

    @RequestMapping("/homepage")
    public String homepage(HttpSession session) {
         if(!isLogin(session)){
            return "login";
        }
        return "homepage";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
         if(isLogin(session)){
        session.invalidate();
        }
        return "login";
    }

    public boolean isLogin(HttpSession session) {
        return (session.getAttribute("user") != null);
    }
}
