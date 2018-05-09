package com.gtdollar.gtserver.service;


import com.gtdollar.gtserver.controller.TransferController;
import com.gtdollar.gtserver.dao.AccountDao;
import com.gtdollar.gtserver.dao.TransferDao;
import com.gtdollar.gtserver.model.Account;
import com.gtdollar.gtserver.model.Transfer;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;

@Service("transferService")
@Transactional
public class TransferServiceImpl implements TransferService {

    private static Logger log = Logger.getLogger( TransferServiceImpl.class );
 
    @Autowired
    private TransferDao transferDao;

    @Autowired
    private AccountDao accountDao;

    /**
     *
     * @param transfer
     */
    public void saveTransfer(Transfer transfer) throws Exception{

        Account fromAccount = accountDao.findByEmail( transfer.getAccount().getEmail() );
        Account toAccount = accountDao.findByEmail( transfer.getOtherEmail() );

        if( fromAccount == null ) {
            throw new Exception("Can not find email.");
        }

        if( toAccount == null ) {
            throw new Exception("Can not find email.");
        }
        //Collections.sort( fromAccount.getTransferList() );
        //Collections.sort( toAccount.getTransferList() );

        BigDecimal fromBalance = fromAccount.getBalance().subtract(transfer.getTranAmount());
        fromAccount.setBalance( fromBalance );

        BigDecimal toBalance = toAccount.getBalance().add( transfer.getTranAmount() );
        toAccount.setBalance( toBalance );

        Date date = new Date();
        transfer.setBalance( toBalance );
        transfer.setTranType( "transfer" );
        transfer.setDateTime( date );


        Transfer othTransfer = new Transfer( 0, fromAccount.getEmail()
                , "Transfer2", date, toBalance,  transfer.getTranAmount() );
        othTransfer.setAccount( toAccount );

        //
        log.info( fromAccount );
        log.info( toAccount );

        accountDao.updateCcount( fromAccount );
        accountDao.updateCcount( toAccount );

        transferDao.saveTransfer( othTransfer );
        transferDao.saveTransfer( transfer );
    }

     
}

