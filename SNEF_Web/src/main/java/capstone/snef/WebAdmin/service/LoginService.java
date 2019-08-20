package capstone.snef.WebAdmin.service;

import capstone.snef.WebAdmin.entity.Account;
import capstone.snef.WebAdmin.entity.Store;
import capstone.snef.WebAdmin.repository.IAccountRepository;
import capstone.snef.WebAdmin.repository.IStoreRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private IAccountRepository accountResp;
    @Autowired
    IStoreRepository storeResp;

    public Store checkLoginManager(String username, String password) {

        Optional<Account> userId = accountResp.checkLogin(username, password);

        if (userId.isPresent()) {
            Account user = userId.get();
            if (user.getRoleId().getRoleName().equalsIgnoreCase("Store Manager") && user.getIsActive() == 1) {
                List<Store> store = storeResp.findAllByaccountId(user);
                if (store.size() > 0) {
                    return store.get(0);
                }
            }
        }
        return null;
    }
}
