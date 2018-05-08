package com.gtdollar.gtserver.dao;


import com.gtdollar.gtserver.model.Account;
import com.gtdollar.gtserver.model.Transfer;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("transferDao")
public class TransferDaoImpl extends AbstractDao<Integer, Transfer> implements TransferDao {


    public void saveTransfer(Transfer transfer) {
        persist( transfer );
    }



}