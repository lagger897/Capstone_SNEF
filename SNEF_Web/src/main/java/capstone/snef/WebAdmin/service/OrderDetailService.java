/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.snef.WebAdmin.service;

import capstone.snef.WebAdmin.entity.FlashsaleProduct;
import capstone.snef.WebAdmin.entity.OrderDetail;
import capstone.snef.WebAdmin.repository.IFlashSaleRepository;
import capstone.snef.WebAdmin.repository.IOrderDetailRepository;
import java.util.List;
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
    private IFlashSaleRepository flashSaleRepos;

    public List<OrderDetail> getAllOrderByStoreId(Integer id) {
        List<FlashsaleProduct> fsp = flashSaleRepos.findAllWithStoreProductId(id);
        for (FlashsaleProduct flashsaleProduct : fsp) {
            List<OrderDetail> orderDetail = orderDetailRepos.findAllByFlashSaleProductId(flashsaleProduct);
            return orderDetail;
        }
        return null;

    }
}
