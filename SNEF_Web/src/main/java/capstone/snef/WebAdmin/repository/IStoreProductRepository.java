/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.snef.WebAdmin.repository;

import capstone.snef.WebAdmin.entity.Store;
import capstone.snef.WebAdmin.entity.StoreProduct;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Phuc Nguyen -VN
 */
public interface IStoreProductRepository extends JpaRepository<StoreProduct, Integer> {

    @Override
    public List<StoreProduct> findAll();

    public List<StoreProduct> findAllByStoreProductId(Integer id);
    public List<StoreProduct> findAllByStoreId(Store storeId);

    @Override
    public boolean existsById(Integer id);

    @Override
    public <S extends StoreProduct> S save(S s);

    
    
}
