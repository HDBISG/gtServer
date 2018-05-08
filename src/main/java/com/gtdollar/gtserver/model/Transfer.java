package com.gtdollar.gtserver.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity(name="GT_TRANSFER")
public class Transfer implements Cloneable, Serializable {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min=5, max=50)
    @Column(name = "other_email", nullable = false)
    private String otherEmail;


    @Size(min=5, max=50)
    @Column(name = "tran_type", nullable = false)
    private String tranType;

    @NotNull
    @Column(name = "date_Time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;
 
    @NotNull
    @Digits(integer=8, fraction=2)
    @Column(name = "BALANCE", nullable = false)
    private BigDecimal balance;

    @NotNull
    @Digits(integer=8, fraction=2)
    @Column(name = "tran_amount", nullable = false)
    private BigDecimal tranAmount;

    @JsonIgnore
    @ManyToOne(cascade = { CascadeType.REFRESH },fetch = FetchType.EAGER)
    @JoinColumn(name = "email")
    private Account account;

    /////////////////


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }

    public String getOtherEmail() {
        return otherEmail;
    }

    public void setOtherEmail(String otherEmail) {
        this.otherEmail = otherEmail;
    }

    public String getTranType() {
        return tranType;
    }

    public void setTranType(String tranType) {
        this.tranType = tranType;
    }
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mmzzz",timezone = "GMT+8")
    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public BigDecimal getTranAmount() {
        return tranAmount;
    }

    public void setTranAmount(BigDecimal tranAmount) {
        this.tranAmount = tranAmount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}