/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.snef.WebAdmin.service;

import capstone.snef.WebAdmin.dataform.OrderData;
import capstone.snef.WebAdmin.repository.IOrderRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Phuc Nguyen -VN
 */
@Service
public class OrderService {
    @Autowired
    private IOrderRepository orderService;
    public List<OrderData> getAllOrderByStoreId(Integer storeId) {
        List<OrderData> orders =orderService.getAllOrderByStoreId(storeId);
        return orders;
    }

}
