/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.snef.WebAdmin.repository;

import capstone.snef.WebAdmin.entity.Account;
import capstone.snef.WebAdmin.entity.StoreManager;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Phuc Nguyen -VN
 */
public interface IStoreManagerRepository extends CrudRepository<StoreManager, Integer> {

    public Optional<StoreManager> findByAccountId(Account id);
    
}
