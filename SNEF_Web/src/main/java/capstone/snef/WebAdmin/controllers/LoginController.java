package capstone.snef.WebAdmin.controllers;

import capstone.snef.WebAdmin.entity.Account;
import capstone.snef.WebAdmin.entity.Store;
import capstone.snef.WebAdmin.service.AccountService;
import capstone.snef.WebAdmin.service.LoginService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;
    
    @Autowired
    private AccountService accService;
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView checkLogin(@RequestParam(value = "name") String username,
            @RequestParam(value = "password") String password, HttpSession session) {
        ModelAndView mv=new ModelAndView("login");
        Store store = loginService.checkLoginManager(username, password);
        Account acc = accService.checkLogin(username, password);
        if (store != null) {
            session.setAttribute("store", store);
            session.setAttribute("user", username);
            session.setAttribute("userAvatar", acc.getAvatar());
            return new ModelAndView("homepage");
        }else{
        mv.addObject("error","Invalid username or password");
        }
        return mv;
    }

}
