package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolioId;

    private LocalDateTime creationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @OneToMany(
            mappedBy = "portfolio",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<Security> securities = new ArrayList<>();

    //No-args constructor
    protected Portfolio() {}

    //Required-args constructor
    public Portfolio(Client client) {
        this.creationDate = LocalDateTime.now();
        this.client = client;
    }

    //Methods for add/remove security/portfolio
    public void addSecurity(Security security) {
        securities.add(security);
        security.setPortfolio(this);
    }
    public void removeSecurity(Security security) {
        securities.remove(security);
        security.setPortfolio(null);
    }

    //Will set current date on first time persistence of the entity
    @PrePersist
    protected void onCreate() {
        if (creationDate == null) {
            creationDate = LocalDateTime.now();
        }
    }

    //Getters
    public Long getPortfolioId() {
        return portfolioId;
    }
    public LocalDateTime getCreationDate() {
        return creationDate;
    }
    public Client getClient() {
        return client;
    }
    public List<Security> getSecurities() {
        return securities;
    }

    //Setters
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public void setSecurity(List<Security> securities) {
        this.securities = securities;
    }
}
