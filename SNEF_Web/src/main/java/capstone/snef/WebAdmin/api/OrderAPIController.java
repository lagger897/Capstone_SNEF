/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.snef.WebAdmin.api;

import capstone.snef.WebAdmin.entity.OrderDetail;
import capstone.snef.WebAdmin.service.OrderDetailService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Phuc Nguyen -VN
 */
@RestController
@RequestMapping("/api/order")
public class OrderAPIController {
    @Autowired
    private OrderDetailService oService;
    
    @GetMapping("/getAll")
    public List<OrderDetail> getAllProduct(@RequestParam Integer storeId){
        return oService.getAllOrderByStoreId(storeId);
    }
}
