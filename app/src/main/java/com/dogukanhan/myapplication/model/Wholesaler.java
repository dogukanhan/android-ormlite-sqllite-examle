package com.dogukanhan.myapplication.model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "wholesaler")
public class Wholesaler {

    @DatabaseField(generatedId = true)
    private Long id;

    @DatabaseField
    private String name;

    @DatabaseField
    private String surname;

    @DatabaseField
    private String address;

    @DatabaseField
    private String phone;

    @DatabaseField
    private String email;

    @ForeignCollectionField
    private ForeignCollection<Purchase> purchases;

    public Wholesaler() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ForeignCollection<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(ForeignCollection<Purchase> purchases) {
        this.purchases = purchases;
    }

    @Override
    public String toString() {
        return "Wholesaler{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


}
