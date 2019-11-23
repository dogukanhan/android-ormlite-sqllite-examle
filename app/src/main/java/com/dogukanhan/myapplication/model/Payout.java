package com.dogukanhan.myapplication.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.math.BigDecimal;

@DatabaseTable(tableName = "payout")
public class Payout {

    @DatabaseField(generatedId = true)
    private Long id;

    @DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "purchase_id")
    private Purchase purchase;

    @DatabaseField
    private BigDecimal amount;

    public Payout() {
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
