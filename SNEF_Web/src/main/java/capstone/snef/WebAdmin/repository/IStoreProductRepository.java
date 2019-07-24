/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.snef.WebAdmin.repository;

import capstone.snef.WebAdmin.entity.StoreProduct;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Phuc Nguyen -VN
 */
public interface IStoreProductRepository extends CrudRepository<StoreProduct, Integer> {

    @Override
    public List<StoreProduct> findAll();

    public List<StoreProduct> findAllByStoreProductId(Integer id);

    @Override
    public boolean existsById(Integer id);

    @Override
    public <S extends StoreProduct> S save(S s);
    
    
}
