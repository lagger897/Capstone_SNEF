/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.snef.WebAdmin.repository;

import capstone.snef.WebAdmin.entity.Order1;
import capstone.snef.WebAdmin.entity.Store;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Phuc Nguyen -VN
 */
public interface IOrderRepository extends CrudRepository<Order1, Integer> {
   List<Order1> findAllByStoreid(Store storeId);

    @Override
    public Optional<Order1> findById(Integer id);

    public Optional<Order1> findByConfirmationCode(String confirmationCode);
   
}
