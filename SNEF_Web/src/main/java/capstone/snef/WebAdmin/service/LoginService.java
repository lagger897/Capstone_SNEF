package capstone.snef.WebAdmin.service;

import capstone.snef.WebAdmin.entity.Admin;
import capstone.snef.WebAdmin.entity.StoreManager;
import capstone.snef.WebAdmin.repository.ILoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    ILoginRepository iLoginResp;

    public int checkLogin(String username, String password){

        System.out.println(username + password);
        int storeId = iLoginResp.checkLogin(username, password);
        if (storeId > 0){
            return storeId;
        }
        return 0;
    }
}
