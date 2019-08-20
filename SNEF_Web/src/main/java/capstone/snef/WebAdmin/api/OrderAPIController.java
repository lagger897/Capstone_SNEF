/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.snef.WebAdmin.api;

import capstone.snef.WebAdmin.dataform.CommentData;
import capstone.snef.WebAdmin.dataform.Message;
import capstone.snef.WebAdmin.dataform.OrderData;
import capstone.snef.WebAdmin.dataform.OrderItemData;
import capstone.snef.WebAdmin.dataform.OrderDetailData;
import capstone.snef.WebAdmin.service.OrderDetailService;
import capstone.snef.WebAdmin.service.OrderService;
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
@RequestMapping("/api/order")
public class OrderAPIController {

    @Autowired
    private OrderDetailService orderDetailServ;
    @Autowired
    private OrderService orderServ;

    @GetMapping("/getAll")
    public Map<String, List<OrderData>> getAllProduct(@RequestParam("storeId") Integer storeId) {
        HashMap<String, List<OrderData>> map = new HashMap<String, List<OrderData>>();
        map.put("data", orderServ.getAllOrderByStoreId(storeId));
        return map;
    }

    @GetMapping("/getOrderDetail")
    public OrderDetailData getOrderDetailData(@RequestParam("orderId") Integer orderId) {
        OrderData order = orderServ.getOrderById(orderId);
        if (order != null) {
            List<OrderItemData> orderItems = orderDetailServ.getAllByOrderId(orderId);
            if (orderItems != null && orderItems.size() > 0) {
                return new OrderDetailData(order, orderItems);
            }
        }
        return null;
    }

    @PostMapping("/confirmOrder")
    public Message confirmOrder(@RequestParam("code") String confirmCode) {
        boolean rs = orderServ.checkConfirmCode(confirmCode);
        if (rs == true) {
            return new Message(true, "Success");
        }
        return new Message(false, "Wrong Confirmation Code");
    }

    @GetMapping("/getAllComment")
    public Map<String, List<CommentData>> getAllComment(@RequestParam("storeId") Integer storeId) {
        Map<String, List<CommentData>> map = new HashMap<>();
        map.put("data", orderServ.findAllCommentByStoreId(storeId));
        return map;
    }
}
