/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.snef.WebAdmin.dataform;

import java.util.List;

/**
 *
 * @author Phuc Nguyen -VN
 */
public class OrderDetailData {
    private OrderData order;
    private List<OrderItemData> orderItems;

    public OrderDetailData(OrderData order, List<OrderItemData> orderItems) {
        this.order = order;
        this.orderItems = orderItems;
    }

    public OrderDetailData() {
    }

    public OrderData getOrder() {
        return order;
    }

    public void setOrder(OrderData order) {
        this.order = order;
    }

    public List<OrderItemData> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemData> orderItems) {
        this.orderItems = orderItems;
    }
    
}
