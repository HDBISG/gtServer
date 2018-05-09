package com.gtdollar.gtserver.service;


import com.gtdollar.gtserver.model.Account;
import com.gtdollar.gtserver.model.Transfer;

public interface TransferService {

    public void saveTransfer(Transfer transfer) throws Exception;
     
}