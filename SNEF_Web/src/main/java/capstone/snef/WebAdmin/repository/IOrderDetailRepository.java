/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.snef.WebAdmin.repository;

import capstone.snef.WebAdmin.entity.FlashsaleProduct;
import capstone.snef.WebAdmin.entity.Order1;
import capstone.snef.WebAdmin.entity.OrderDetail;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Phuc Nguyen -VN
 */
public interface IOrderDetailRepository extends CrudRepository<OrderDetail, Integer> {

    @Override
    public List<OrderDetail> findAll();

    @Override
    public Optional<OrderDetail> findById(Integer id);

    public List<OrderDetail> findAllByFlashSaleProductId(FlashsaleProduct id);
    
    @Query(value="SELECT * FROM FlashsaleProduct f WHERE f.FlashsaleProductId = ?1",nativeQuery = true)
    public List<OrderDetail> findAllWithFlashSaleProductId(Integer id);

    public List<OrderDetail> findAllByOrderOrderId(Order1 order);
   
}
