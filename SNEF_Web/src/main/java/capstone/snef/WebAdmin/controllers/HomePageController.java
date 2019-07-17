package capstone.snef.WebAdmin.controllers;

import capstone.snef.WebAdmin.api.ProductAPIController;
import capstone.snef.WebAdmin.dataform.StoreProductData;
import capstone.snef.WebAdmin.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomePageController {

    @Autowired
    private ProductService pService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homepage(){
        System.out.println("Vào Đây");
        return "login";
    }

}
