/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.snef.WebAdmin.repository;

import capstone.snef.WebAdmin.entity.StoreProductImage;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Phuc Nguyen -VN
 */
public interface IStoreProductImageRepository extends CrudRepository<StoreProductImage, Integer> {

    @Override
    public <S extends StoreProductImage> S save(S s);

    @Override
    public <S extends StoreProductImage> Iterable<S> saveAll(Iterable<S> itrbl);
    
}
