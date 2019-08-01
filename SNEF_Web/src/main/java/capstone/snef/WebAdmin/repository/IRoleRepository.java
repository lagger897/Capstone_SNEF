/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.snef.WebAdmin.repository;

import capstone.snef.WebAdmin.entity.Role;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Phuc Nguyen -VN
 */
public interface IRoleRepository extends CrudRepository<Role, Integer> {

    @Override
    public Optional<Role> findById(Integer id);
    
}
