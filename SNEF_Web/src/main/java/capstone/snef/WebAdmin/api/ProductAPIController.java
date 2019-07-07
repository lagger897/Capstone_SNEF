/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.snef.WebAdmin.api;

import capstone.snef.WebAdmin.dataform.ProductData;
import capstone.snef.WebAdmin.dataform.StoreProductData;
import capstone.snef.WebAdmin.entity.Product;
import capstone.snef.WebAdmin.service.ProductService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public List<Product> getAllProduct() {
        return pService.getAllProduct();
    }
//    @GetMapping("/getAllStoreProduct")
//    public StoreProductDataForm getAllStoreProduct(@RequestParam("id") Integer storeId){
//        System.out.println(storeId);
//        return new StoreProductDataForm(pService.getAllStoreProductById(storeId));
//    }

    @GetMapping("/getAllStoreProduct")
    public Map<String, List<StoreProductData>> getAllStoreProduct(@RequestParam("id") Integer storeId) {
        System.out.println(storeId);
        Map<String, List<StoreProductData>> map = new HashMap<String, List<StoreProductData>>();
        map.put("data", pService.getAllStoreProductByStoreId(storeId));
        return map;
    }

    @GetMapping("/search")
    public  Map<String,List<ProductData>> getProductByName(@RequestParam("name") String productName) {
        List<Product> products = pService.getProductByName(productName);
        List<ProductData> data= new ArrayList<>();
        for (Product product : products) {
            data.add(new ProductData(product.getProductId(), product.getProductName(), product.getImageSrc()));
        }
        Map<String, List<ProductData>> map = new HashMap<String, List<ProductData>>();
        map.put("data", data);
        return map;
    }
    @GetMapping("/getProduct")
    public ProductData getProduct(@RequestParam("id") Integer id){
        return pService.getProductById(id);
    };
    
}
