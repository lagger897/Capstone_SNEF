package capstone.snef.WebAdmin.service;

import capstone.snef.WebAdmin.entity.Account;
import capstone.snef.WebAdmin.entity.Store;
import capstone.snef.WebAdmin.entity.StoreManager;
import capstone.snef.WebAdmin.repository.IAccountRepository;
import capstone.snef.WebAdmin.repository.IStoreManagerRepository;
import capstone.snef.WebAdmin.repository.IStoreRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    IAccountRepository accountResp;
    @Autowired
    IStoreManagerRepository storeManagerResp;
    @Autowired
    IStoreRepository storeResp;

    public Store checkLoginManager(String username, String password) {

        Optional<Account> userId = accountResp.checkLogin(username, password);
        if (userId.isPresent()) {
            Optional<StoreManager> storeManager = storeManagerResp.findByAccountId(userId.get());
            if(storeManager.isPresent()){
                Optional<Store> store = storeResp.findByStoreManagerId(storeManager.get());
                if(store.isPresent()){
                    return store.get();
                }
            }
        }
        return null;
    }
}
