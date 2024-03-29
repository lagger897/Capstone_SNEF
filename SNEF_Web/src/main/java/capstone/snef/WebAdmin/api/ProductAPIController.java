/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.snef.WebAdmin.api;

import capstone.snef.WebAdmin.dataform.AddProductDataForm;
import capstone.snef.WebAdmin.dataform.FlashSaleForm;
import capstone.snef.WebAdmin.dataform.InStoreProduct;
import capstone.snef.WebAdmin.dataform.Message;
import capstone.snef.WebAdmin.dataform.ProductData;
import capstone.snef.WebAdmin.dataform.FlashSaleProductData;
import capstone.snef.WebAdmin.dataform.StoreProductData;
import capstone.snef.WebAdmin.entity.Product;
import capstone.snef.WebAdmin.entity.StoreProduct;
import capstone.snef.WebAdmin.service.ProductService;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public Map<String, List<FlashSaleProductData>> getAllStoreProductWithFlashsale(@RequestParam("id") Integer storeId) {
        System.out.println(storeId);
        Map<String, List<FlashSaleProductData>> map = new HashMap<String, List<FlashSaleProductData>>();
        map.put("data", pService.getAllStoreProductWithFlashSaleByStoreId(storeId));
        return map;
    }

    @GetMapping("/search")
    public Map<String, List<ProductData>> getProductByName(@RequestParam("name") String productName) {
        List<Product> products = pService.getProductByName(productName);
        List<ProductData> data = new ArrayList<>();
        for (Product product : products) {
            data.add(new ProductData(product.getProductId(), product.getProductName(), product.getImageSrc()));
        }
        Map<String, List<ProductData>> map = new HashMap<String, List<ProductData>>();
        map.put("data", data);
        return map;
    }

    @GetMapping("/getProduct")
    public ProductData getProduct(@RequestParam("id") Integer id) {
        return pService.getProductById(id);
    }

    @PostMapping(value = "/addProduct", consumes = "application/json")
    public Message addProduct(@RequestBody AddProductDataForm data) {
        StoreProduct rs = pService.saveStoreProduct(
                data.getStoreId(), data.getProductId(), data.getName(),
                data.getExpiredDate(), data.getAmmount(), data.getPrice(),
                data.getDescription());
        if (rs != null) {
            return new Message(true, "Success");
        }
        return new Message(false, "Fail");
    }

    @GetMapping("/getAllStoreProductWithoutFlashSale")
    public Map<String, List<InStoreProduct>> getAllStoreProductWithoutFlashSale(@RequestParam("storeId") Integer storeId) {
        Map<String, List<InStoreProduct>> map = new HashMap<String, List<InStoreProduct>>();
        map.put("data", pService.getAllStoreProduct(storeId));
        return map;
    }

    @PostMapping("/saleStoreProduct")
    public Message saleStoreProduct(@RequestBody FlashSaleForm body) {
         
        return pService.saleProduct(body);
    }

    @PutMapping("/deleteStoreProduct")
    public Message deleteStoreProduct(@RequestParam("productId") Integer productId) {
        if (pService.deleteStoreProduct(productId)) {
            return new Message(true, "Delete Success");
        }
        return new Message(false, "Unable to delete store product ");
    }

    @GetMapping("/getStoreProduct")
    public StoreProductData getStoreProduct(@RequestParam("id") Integer productId) {
        return pService.getStoreProduct(productId);
    }

    @PostMapping("/updateStoreProduct")
    public Message saleStoreProduct(@RequestBody StoreProductData body) {
       
        boolean rs = pService.updateStoreProduct(body);
        if (rs) {
            return new Message(true, "Update success");
        } else {
            return new Message(false, "Update fail");
        }
    }
    
}
