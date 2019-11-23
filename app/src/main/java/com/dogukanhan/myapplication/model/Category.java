package com.dogukanhan.myapplication.model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "category")
public class Category {

    @DatabaseField(id = true)
    private String name;

    @ForeignCollectionField
    private ForeignCollection<Product> products;

    public Category() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ForeignCollection<Product> getProducts() {
        return products;
    }

    public void setProducts(ForeignCollection<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                '}';
    }
}
