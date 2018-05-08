package com.gtdollar.gtserver.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    // zzz 2018-05-08T21:32GMT+08:00
    // Z 2018-05-08T21:32+0800
    //http://www.java2s.com/Code/Java/Data-Type/ISO8601dateparsingutility.htm

    //@JsonFormat(pattern="yyyy-MM-dd'T'HH:mmZ",timezone = "GMT+8")
    public String getDatetime() {
        return Utility.formatDateTime( datetime ) ;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
}
