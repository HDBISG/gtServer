package com.gtdollar.gtserver.bean;

import java.math.BigDecimal;

/**
 * Created by ok on 7/5/18.
 */
public class JsonResponseBean {

    boolean success;
    BigDecimal balance;

    public JsonResponseBean(boolean success, BigDecimal balance) {
        this.success = success;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "JsonResponseBean{" +
                "success=" + success +
                ", balance=" + balance +
                '}';
    }
/////////////////////


    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
