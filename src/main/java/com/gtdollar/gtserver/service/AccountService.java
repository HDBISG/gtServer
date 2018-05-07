package com.gtdollar.gtserver.service;


import com.gtdollar.gtserver.model.Account;

import java.util.List;

public interface AccountService {
 
    public Account findByEmail(String email );

    public void saveAccount(Account account);
     
}