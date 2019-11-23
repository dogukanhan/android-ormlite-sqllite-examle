package com.dogukanhan.myapplication.model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;

import java.math.BigDecimal;

public class Purchase {

    @DatabaseField(generatedId = true)
    private Long id;

    @DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "product_id")
    private Product product;

    @DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "wholesaler_id")
    private Wholesaler wholesaler;

    @DatabaseField
    private BigDecimal amount;

    @DatabaseField
    private BigDecimal cost;

    @ForeignCollectionField
    private ForeignCollection<Payout> payouts;

    public Purchase() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Wholesaler getWholesaler() {
        return wholesaler;
    }

    public void setWholesaler(Wholesaler wholesaler) {
        this.wholesaler = wholesaler;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public ForeignCollection<Payout> getPayouts() {
        return payouts;
    }

    public void setPayouts(ForeignCollection<Payout> payouts) {
        this.payouts = payouts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
