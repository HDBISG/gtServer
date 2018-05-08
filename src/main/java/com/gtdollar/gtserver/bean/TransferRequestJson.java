package com.gtdollar.gtserver.bean;

import com.gtdollar.gtserver.model.Account;
import com.gtdollar.gtserver.model.Transfer;

import java.math.BigDecimal;

/**
 * Created by ok on 8/5/18.
 */

public class TransferRequestJson {
    String email;
    String transferee;
    BigDecimal amount;

    @Override
    public String toString() {
        return "TransferRequestJson{" +
                "email='" + email + '\'' +
                ", transferee='" + transferee + '\'' +
                ", amount=" + amount +
                '}';
    }

    public Transfer toTransfer(Transfer transfer) {

        transfer.setTranAmount( getAmount() );
        transfer.setOtherEmail( getTransferee() );
        Account account = new Account();
        account.setEmail( getEmail() );
        transfer.setAccount( account );

        return transfer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTransferee() {
        return transferee;
    }

    public void setTransferee(String transferee) {
        this.transferee = transferee;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
