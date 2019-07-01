/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.snef.WebAdmin.api;

import capstone.snef.WebAdmin.entity.Product;
import capstone.snef.WebAdmin.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Phuc Nguyen -VN
 */
@RestController
@RequestMapping("/api/product")
public class ProductAPIController {
    @Autowired
    private ProductService pService;
    
    @PostMapping("/getAll")
    public List<Product> getAllProduct(){
        return pService.getAllProduct();
    }
}
