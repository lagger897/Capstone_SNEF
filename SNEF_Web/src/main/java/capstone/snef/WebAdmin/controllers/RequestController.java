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
@RequestMapping("/")
public class RequestController {
   @RequestMapping("/storeProduct")
   public String storeProductPage(){
       return "storeproduct";
   }
   @RequestMapping("/addStoreProduct")
   public String addStoreProductPage(){
       return "addProduct";
   }
   @RequestMapping("/order")
   public String orderPage(){
       return "order";
   }
   @RequestMapping("/homepage")
   public String homepage(){
       return "homepage";
   }
}
