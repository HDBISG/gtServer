package com.gtdollar.gtserver.bean;

import com.gtdollar.gtserver.model.Transfer;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by ok on 8/5/18.
 */
public class TransferResponseJson {

    int id;
    String from;
    String to;
    String type;
    BigDecimal amount;
    Date datetime;
    ////////////////
    public TransferResponseJson() {

    }

    public TransferResponseJson( Transfer transfer) {
        this.id = transfer.getId();
        this.from = transfer.getAccount().getEmail();
        this.to = transfer.getOtherEmail();
        this.type = transfer.getTranType();
        this.amount = transfer.getTranAmount();
        this.datetime = transfer.getDateTime();
    }

    //////////////////////
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
}
