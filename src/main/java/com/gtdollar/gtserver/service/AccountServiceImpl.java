package com.gtdollar.gtserver.service;


import com.gtdollar.gtserver.dao.AccountDao;
import com.gtdollar.gtserver.model.Account;
import com.gtdollar.gtserver.model.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService {
 
    @Autowired
    private AccountDao dao;

    public static BigDecimal initBalance = new BigDecimal("10000");

    public Account findByEmail(String email ) {
        return dao.findByEmail( email );
    }

    /**
     * Save account and save one transfer as Signup credits.
     * @param account
     */
    public void saveAccount(Account account) {

        Date date = new Date();
        account.setCreateTime( date );
        account.setBalance(initBalance);
        account.setTransferList( new ArrayList<Transfer>());

        Transfer transfer = new Transfer( 0, account.getEmail()
                , "Signup credits", date, initBalance,  initBalance );
        transfer.setAccount( account );
        account.getTransferList().add( transfer );

        dao.saveAccount( account );
    }

     
}

