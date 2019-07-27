package capstone.snef.WebAdmin.api;

import capstone.snef.WebAdmin.entity.Store;
import capstone.snef.WebAdmin.service.LoginService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginAPIController {

    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView checkLogin(@RequestParam(value = "name") String username,
            @RequestParam(value = "password") String password, HttpSession session) {
//        List<StoreManager> list = loginService.checkLoginManager(username, password);
//        ProductAPIController api = new ProductAPIController();
//        if (list.size() >0){
//            for ( StoreManager lists: list){
//                api.getAllStoreProduct(lists.getStoreManagerId());
//                System.out.println("api: " + api.getAllStoreProduct(lists.getStoreManagerId()));
//            }
//
        Store store = loginService.checkLoginManager(username, password);
        if (store != null) {
            session.setAttribute("store", store);
            return new ModelAndView("homepage");
        }

        return new ModelAndView("login");
//
    }

}
