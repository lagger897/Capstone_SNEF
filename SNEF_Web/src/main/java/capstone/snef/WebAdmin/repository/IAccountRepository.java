package capstone.snef.WebAdmin.repository;

import capstone.snef.WebAdmin.entity.Account;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface IAccountRepository extends CrudRepository<Account, Integer> {
    @Query(value = "Select * From Account Where UserName = ?1 And Password = ?2 ",nativeQuery = true)
    Optional<Account> checkLogin(String username,String password);  
}
