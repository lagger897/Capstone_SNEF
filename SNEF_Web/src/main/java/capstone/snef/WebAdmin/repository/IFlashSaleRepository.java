/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.snef.WebAdmin.repository;

import capstone.snef.WebAdmin.entity.FlashsaleProduct;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Phuc Nguyen -VN
 */
public interface IFlashSaleRepository extends CrudRepository<FlashsaleProduct, Integer> {

    @Override
    public long count();

    @Override
    public List<FlashsaleProduct> findAll();

    @Override
    public Optional<FlashsaleProduct> findById(Integer id);
    

    @Override
    public boolean existsById(Integer id);
    
    
    public Optional<FlashsaleProduct> findByStoreProductId(Integer storeProductId);
    
    @Query(value="SELECT * FROM FlashsaleProduct f WHERE f.FlashsaleProductId = ?1",nativeQuery = true)
    List<FlashsaleProduct> findAllWithStoreProductId(Integer id);
 
}
