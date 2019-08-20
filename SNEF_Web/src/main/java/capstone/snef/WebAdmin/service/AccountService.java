/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.snef.WebAdmin.service;

import capstone.snef.WebAdmin.entity.Account;
import capstone.snef.WebAdmin.repository.IAccountRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Phuc Nguyen -VN
 */
@Service
public class AccountService {

    @Autowired
    private IAccountRepository accRepos;

    public Account checkLogin(String username, String password) {
        Optional<Account> rs = accRepos.checkLogin(username, password);
        if (rs.isPresent()) {
            return rs.get();
        }
        return null;
    }

}
