/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.snef.WebAdmin.service;

import capstone.snef.WebAdmin.dataform.OrderItemData;
import capstone.snef.WebAdmin.entity.Order1;
import capstone.snef.WebAdmin.entity.OrderDetail;
import capstone.snef.WebAdmin.repository.IOrderDetailRepository;
import capstone.snef.WebAdmin.repository.IOrderRepository;
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
public class OrderDetailService {

    @Autowired
    private IOrderDetailRepository orderDetailRepos;
    @Autowired
    private IOrderRepository orderRepos;

    public List<OrderItemData> getAllByOrderId(Integer orderId) {
        Optional<Order1> orderRs = orderRepos.findById(orderId);
        if (orderRs.isPresent()) {
            List<OrderDetail> orderDetailRs = orderDetailRepos.findAllByOrderOrderId(orderRs.get());
            if (!orderDetailRs.isEmpty()) {
                List<OrderItemData> orderDetails = new ArrayList<>();
                for (OrderDetail orderDetail : orderDetailRs) {
                    orderDetails.add(new OrderItemData(orderDetail.getFlashSaleProductId().getStoreProductId().getProductName(), orderDetail.getQuantity(), orderDetail.getOrderDetailPrice()));
                }
                return orderDetails;
            }
        }
        return null;
    }
}
