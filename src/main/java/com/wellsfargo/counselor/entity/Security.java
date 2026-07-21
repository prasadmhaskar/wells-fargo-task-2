package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Security {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long securityId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private BigDecimal purchasePrice;

    @Column(nullable = false, precision = 19, scale = 4)
    private LocalDateTime purchaseDate;

    @Column(nullable = false)
    private Long quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_id", nullable = false)
    private Portfolio portfolio;

    //No-args constructor
    protected Security() {}

    //Required-args constructor
    public Security(String name, String category, BigDecimal purchasePrice, LocalDateTime purchaseDate, long quantity, Portfolio portfolio) {
        this.name = name;
        this.category = category;
        this.purchasePrice = purchasePrice;
        this.purchaseDate = purchaseDate;
        this.quantity = quantity;
        this.portfolio = portfolio;
    }

    //Getters
    public Long getSecurityId() {
        return securityId;
    }
    public String getName() {
        return name;
    }
    public String getCategory() {
        return category;
    }
    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }
    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }
    public long getQuantity() {
        return quantity;
    }
    public Portfolio getPortfolio() {
        return portfolio;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }
}
