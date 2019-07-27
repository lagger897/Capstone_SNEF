package capstone.snef.WebAdmin.repository;

import capstone.snef.WebAdmin.entity.Store;
import capstone.snef.WebAdmin.entity.StoreManager;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ILoginRepository extends CrudRepository<Store, Integer> {

    //Select * from Admin Where accountId = (Select accountid from Account where username = 'TinLM' and password = '123')

    @Query(value = " SELECT StoreId FROM Store " +
            "WHERE StoreManagerId = " +
            "(SELECT StoreManagerId FROM StoreManager " +
            "WHERE accountId = " +
            "(SELECT accountid FROM Account WHERE username = ? AND password = ?))",
            nativeQuery = true)
    int checkLogin(String username, String password);
}
