package com.gtdollar.gtserver.service;


import com.gtdollar.gtserver.dao.AccountDao;
import com.gtdollar.gtserver.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService {
 
    @Autowired
    private AccountDao dao;

    public Account findByEmail(String email ) {
        return dao.findByEmail( email );
    }

    public void saveAccount(Account account) {
        dao.saveAccount( account );
    }

     
}

