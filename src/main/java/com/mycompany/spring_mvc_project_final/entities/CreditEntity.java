package com.mycompany.spring_mvc_project_final.entities;

import org.springframework.security.core.userdetails.User;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Credit")
public class CreditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer creditId;

    @ManyToOne
    @JoinColumn(name = "accountId")
    private AccountEntity account;

    private BigDecimal balance;
// getter and setter methods
    public Integer getCreditId() {
        return creditId;
    }

    public void setCreditId(Integer creditId) {
        this.creditId = creditId;
    }

    public AccountEntity getAccount() {
        return account;
    }

    public void setAccount(AccountEntity account) {
        this.account = account;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
