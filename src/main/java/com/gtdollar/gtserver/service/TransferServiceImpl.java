package com.gtdollar.gtserver.service;


import com.gtdollar.gtserver.dao.AccountDao;
import com.gtdollar.gtserver.dao.TransferDao;
import com.gtdollar.gtserver.model.Account;
import com.gtdollar.gtserver.model.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

@Service("transferService")
@Transactional
public class TransferServiceImpl implements TransferService {
 
    @Autowired
    private TransferDao dao;


    public void saveTransfer(Transfer transfer) {

        transfer.setBalance( new BigDecimal(10) );
        transfer.setTranType( "transfer" );
        transfer.setDateTime( new Date() );

        dao.saveTransfer( transfer );
    }

     
}

