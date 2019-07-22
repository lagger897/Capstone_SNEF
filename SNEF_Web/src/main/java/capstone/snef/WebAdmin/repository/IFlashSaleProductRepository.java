/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.snef.WebAdmin.repository;

import capstone.snef.WebAdmin.entity.FlashsaleProduct;
import capstone.snef.WebAdmin.entity.Flashsales;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Phuc Nguyen -VN
 */
public interface IFlashSaleProductRepository extends CrudRepository<FlashsaleProduct, Integer> {

    @Override
    public long count();

    @Override
    public List<FlashsaleProduct> findAll();

    @Override
    public Optional<FlashsaleProduct> findById(Integer id);

    @Override
    public boolean existsById(Integer id);

    @Override
    public <S extends FlashsaleProduct> S save(S s);

    public Optional<FlashsaleProduct> findByStoreProductId(Integer storeProductId);

    @Query(value = "SELECT * FROM FlashsaleProduct f WHERE f.FlashsaleProductId = ?1", nativeQuery = true)
    public List<FlashsaleProduct> findAllWithStoreProductId(Integer id);

    public List<FlashsaleProduct> findAllByFlashSalesId(Flashsales flashsale);

}
