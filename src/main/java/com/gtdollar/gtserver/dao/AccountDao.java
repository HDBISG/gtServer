package com.gtdollar.gtserver.dao;

import com.gtdollar.gtserver.model.Account;


import java.util.List;

public interface AccountDao {


    public Account findByEmail(String email );

    public void saveAccount(Account account);

    public Account updateCcount(Account account);
    
}