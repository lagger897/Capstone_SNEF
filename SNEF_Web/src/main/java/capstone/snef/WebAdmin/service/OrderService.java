/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.snef.WebAdmin.service;

import capstone.snef.WebAdmin.dataform.OrderData;
import capstone.snef.WebAdmin.entity.Order1;
import capstone.snef.WebAdmin.entity.Store;
import capstone.snef.WebAdmin.repository.IAccountRepository;
import capstone.snef.WebAdmin.repository.IOrderRepository;
import capstone.snef.WebAdmin.repository.IStoreRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Phuc Nguyen -VN
 */
@Service
public class OrderService {

    @Autowired
    private IOrderRepository orderRepos;

    @Autowired
    private IStoreRepository storeRepos;

    @Autowired
    private IAccountRepository accountRepos;

    public List<OrderData> getAllOrderByStoreId(Integer storeId) {
        Optional<Store> storeRs = storeRepos.findById(storeId);
        if (storeRs.isPresent()) {
            List<Order1> orders = orderRepos.findAllByStoreid(storeRs.get());
            List<OrderData> ordersData = new ArrayList<>();
            for (Order1 order : orders) {
                OrderData data = new OrderData();
                data.setOrderId(order.getOrderId());
                data.setDateOrder(order.getDateOrder());
                data.setConfirmationCode(order.getConfirmationCode());
                data.setRatingPoint(order.getRatingPoint());
                data.setFirstname(order.getAccountId().getFirstName());
                data.setLastname(order.getAccountId().getLastName());
                data.setStatus(order.getStatus());
                ordersData.add(data);
            }
            return ordersData;
        }
        return null;
    }

    public OrderData getOrderById(Integer orderId) {
        Optional<Order1> orderRs = orderRepos.findById(orderId);
        if (orderRs.isPresent()) {
            Order1 order = orderRs.get();
            return new OrderData(orderId, order.getDateOrder(), order.getConfirmationCode(),
                    order.getStatus(), order.getRatingPoint(), order.getAccountId().getFirstName(),
                    order.getAccountId().getLastName());
        }
        return null;
    }

    public boolean checkConfirmCode(String confirmCode) {
        Optional<Order1> orderRs = orderRepos.findByConfirmationCode(confirmCode);
        if (orderRs.isPresent()){
            Order1 order = orderRs.get();
            order.setStatus(true);
            if (orderRepos.save(order)!=null){
                return true;
            }
        }
        return false;
    }

}
