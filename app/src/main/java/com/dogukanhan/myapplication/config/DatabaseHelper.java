package com.dogukanhan.myapplication.config;


import java.sql.SQLException;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.dogukanhan.myapplication.model.Category;
import com.dogukanhan.myapplication.model.Customer;
import com.dogukanhan.myapplication.model.Income;
import com.dogukanhan.myapplication.model.Payout;
import com.dogukanhan.myapplication.model.Product;
import com.dogukanhan.myapplication.model.Purchase;
import com.dogukanhan.myapplication.model.Sale;
import com.dogukanhan.myapplication.model.SimpleData;
import com.dogukanhan.myapplication.model.Wholesaler;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;


public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "7.db";

    private static final int DATABASE_VERSION = 1;

    private Dao<SimpleData, Integer> simpleDao = null;
    private RuntimeExceptionDao<SimpleData, Integer> simpleRuntimeDao = null;

    private Dao<Category, String> categoryDAO = null;
    private Dao<Wholesaler, Long> wholesalerDAO = null;
    private Dao<Product, Long> productDAO = null;


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {
            Log.i(DatabaseHelper.class.getName(), "onCreate");

            TableUtils.createTable(connectionSource, SimpleData.class);
            TableUtils.createTable(connectionSource, Category.class);
            TableUtils.createTable(connectionSource, Wholesaler.class);
            TableUtils.createTable(connectionSource, Product.class);
            TableUtils.createTable(connectionSource, Purchase.class);
            TableUtils.createTable(connectionSource, Payout.class);
            TableUtils.createTable(connectionSource, Income.class);
            TableUtils.createTable(connectionSource, Sale.class);
            TableUtils.createTable(connectionSource, Customer.class);

        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        }

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            Log.i(DatabaseHelper.class.getName(), "onUpgrade");
            TableUtils.dropTable(connectionSource, SimpleData.class, true);
            // after we drop the old databases, we create the new ones
            onCreate(db, connectionSource);
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't drop databases", e);
            throw new RuntimeException(e);
        }
    }

    public Dao<Wholesaler, Long> getWholaselerDAO() throws SQLException {
        if (wholesalerDAO == null) {
            wholesalerDAO = getDao(Wholesaler.class);
        }
        return wholesalerDAO;
    }

    public Dao<Category, String> getCategoryDAO() throws SQLException {
        if (categoryDAO == null) {
            categoryDAO = getDao(Category.class);
        }
        return categoryDAO;
    }


    public Dao<Product, Long> getProductDAO() throws SQLException {
        if (productDAO == null) {
            productDAO = getDao(Product.class);
        }
        return productDAO;
    }

    public RuntimeExceptionDao<SimpleData, Integer> getSimpleDataDao() {
        if (simpleRuntimeDao == null) {
            simpleRuntimeDao = getRuntimeExceptionDao(SimpleData.class);
        }
        return simpleRuntimeDao;
    }

    @Override
    public void close() {
        super.close();
        simpleDao = null;
        simpleRuntimeDao = null;
    }
}