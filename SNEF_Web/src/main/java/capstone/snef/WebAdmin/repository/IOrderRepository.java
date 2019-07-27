/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.snef.WebAdmin.repository;

import capstone.snef.WebAdmin.dataform.OrderData;
import capstone.snef.WebAdmin.entity.Order1;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Phuc Nguyen -VN
 */
public interface IOrderRepository extends CrudRepository<Order1, Integer> {
    @Query(value = "select  o.OrderId, o.DateOrder, o.ConfirmationCode, o.Status, o.RatingPoint, ac.Firstname, ac.Lastname "
            + "from snef_part2.Order o, OrderDetail od, FlashsaleProduct fsp, StoreProduct sp, Store s, Account ac ,Customer c "
            + "where o.OrderId = od.OrderOrderId "
            + "and od.FlashSaleProductId = fsp.FlashSaleProductId "
            + "AND fsp.StoreProductId = sp.StoreProductId "
            + "and sp.StoreId = s.StoreId and s.StoreId = ?1 "
            + "and o.CustomerCustomerId =  c.CustomerId "
            + "and c.AccountId =  ac.AccountId "
            + "group by OrderId",nativeQuery = true)
    List<OrderData> getAllOrderByStoreId(Integer storeId);
}
