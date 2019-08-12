package capstone.snef.WebAdmin.controllers;

import capstone.snef.WebAdmin.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpSession;

@Controller
public class HomePageController {
    @Autowired
    private ProductService pService;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homepage(HttpSession session){
        if(session.getAttribute("user")!=null){
            return "homepage";
        }
        return "login";
    }

}
