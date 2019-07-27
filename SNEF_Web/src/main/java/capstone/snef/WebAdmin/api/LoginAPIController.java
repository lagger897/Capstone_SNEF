package capstone.snef.WebAdmin.api;


import capstone.snef.WebAdmin.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api")
public class LoginAPIController {

    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String checkLogin(@RequestParam(value = "name") String username,
                              @RequestParam(value = "password") String password){
//        List<StoreManager> list = loginService.checkLogin(username, password);
//        ProductAPIController api = new ProductAPIController();
//        if (list.size() >0){
//            for ( StoreManager lists: list){
//                api.getAllStoreProduct(lists.getStoreManagerId());
//                System.out.println("api: " + api.getAllStoreProduct(lists.getStoreManagerId()));
//            }
//
            int storeID = loginService.checkLogin(username, password);

            return "homepage";
//
    }

}
