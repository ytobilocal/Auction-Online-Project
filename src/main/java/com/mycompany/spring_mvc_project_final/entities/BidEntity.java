package com.mycompany.spring_mvc_project_final.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Bid")
public class BidEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bidId;

    @ManyToOne
    @JoinColumn(name = "auctionId")
    private AuctionEntity auction;

    @ManyToOne
    @JoinColumn(name = "accountId")
    private AccountEntity account;

    private BigDecimal amount;
    private LocalDateTime timestamp;

    // getter and setter methods

    public Integer getBidId() {
        return bidId;
    }

    public void setBidId(Integer bidId) {
        this.bidId = bidId;
    }

    public AuctionEntity getAuction() {
        return auction;
    }

    public void setAuction(AuctionEntity auction) {
        this.auction = auction;
    }

    public AccountEntity getAccount() {
        return account;
    }

    public void setAccount(AccountEntity account) {
        this.account = account;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}


