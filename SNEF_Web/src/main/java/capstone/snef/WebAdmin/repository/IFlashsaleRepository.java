/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.snef.WebAdmin.repository;

import capstone.snef.WebAdmin.entity.Flashsales;
import capstone.snef.WebAdmin.entity.Store;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Phuc Nguyen -VN
 */
public interface IFlashsaleRepository extends CrudRepository<Flashsales, Integer> {

    @Override
    public void delete(Flashsales t);

    @Override
    public <S extends Flashsales> S save(S s);

    @Override
    public boolean existsById(Integer id);

    public List<Flashsales> findAllByStoreId(Store storeId);

}
