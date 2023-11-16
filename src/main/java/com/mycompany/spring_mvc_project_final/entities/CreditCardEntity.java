package com.mycompany.spring_mvc_project_final.entities;

import org.springframework.security.core.userdetails.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "CreditCard")
public class CreditCardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer creditCardId;

    @ManyToOne
    @JoinColumn(name = "accountId")
    private AccountEntity account;

    private String cardNumber;
    private LocalDateTime expirationDate;
    private Integer cvv;
    private String cardHolder;

// getter and setter methods

    public Integer getCreditCardId() {
        return creditCardId;
    }

    public void setCreditCardId(Integer creditCardId) {
        this.creditCardId = creditCardId;
    }

    public AccountEntity getAccount() {
        return account;
    }

    public void setAccount(AccountEntity account) {
        this.account = account;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Integer getCvv() {
        return cvv;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }
}
