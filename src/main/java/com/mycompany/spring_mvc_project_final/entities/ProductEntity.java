package com.mycompany.spring_mvc_project_final.entities;

import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId")
    private long productId;
    @Column(name = "productName")
    private String productName;
    @Column(name = "product_img")
    private String productImg;
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private Set<AuctionEntity> auctions;


    public ProductEntity() {
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<AuctionEntity> getAuctions() {
        return auctions;
    }

    public void setAuctions(Set<AuctionEntity> auctions) {
        this.auctions = auctions;
    }
}