package com.gtdollar.gtserver.dao;


import com.gtdollar.gtserver.model.Account;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("accountDao")
public class AccountDaoImpl extends AbstractDao<Integer, Account> implements AccountDao {
 
    public Account findByEmail( String email ) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("email", email));
        return (Account) criteria.uniqueResult();
    }
 
    public void saveAccount(Account account) {
        persist(account);
    }

    public Account updateccount(Account account) {
        Account rst = (Account) getSession().merge( account );
        return  rst;
    }

}