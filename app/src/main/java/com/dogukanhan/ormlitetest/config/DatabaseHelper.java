package com.dogukanhan.ormlitetest.config;


import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.dogukanhan.ormlitetest.model.Category;
import com.dogukanhan.ormlitetest.model.Customer;
import com.dogukanhan.ormlitetest.model.Income;
import com.dogukanhan.ormlitetest.model.Payout;
import com.dogukanhan.ormlitetest.model.Product;
import com.dogukanhan.ormlitetest.model.Purchase;
import com.dogukanhan.ormlitetest.model.Sale;
import com.dogukanhan.ormlitetest.model.Wholesaler;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;


public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "10.db";

    private static final int DATABASE_VERSION = 1;

    private static final Set<Class> entities = new HashSet<Class>(
            Arrays.asList(Category.class, Customer.class, Income.class, Payout.class, Product.class,
                    Purchase.class, Sale.class, Wholesaler.class)
    );

    public final DAOMapper DAO = new DAOMapper();

    public class DAOMapper {

        private DAOMapper() {

        }

        private final Map<Class, Object> daos = new HashMap<>();

        private Object getOrAdd(Class clazz) throws SQLException {

            if (!entities.contains(clazz))
                throw new SQLException("This class is not in the entities set please add");

            if (!daos.containsKey(clazz)) {
                daos.put(clazz, getDao(clazz));
            }
            return daos.get(clazz);
        }

        public Dao<Category, String> Category() throws SQLException {
            return (Dao<Category, String>) getDao(Category.class);
        }

        public Dao<Customer, Long> Customer() throws SQLException {
            return (Dao<Customer, Long>) getDao(Customer.class);
        }

        public Dao<Payout, Long> Payout() throws SQLException {
            return (Dao<Payout, Long>) getDao(Payout.class);
        }

        public Dao<Product, Long> Product() throws SQLException {
            return (Dao<Product, Long>) getDao(Product.class);
        }

        public Dao<Purchase, Long> Purchase() throws SQLException {
            return (Dao<Purchase, Long>) getDao(Purchase.class);
        }

        public Dao<Income, Long> Income() throws SQLException {
            return (Dao<Income, Long>) getDao(Income.class);
        }

        public Dao<Sale, Long> Sale() throws SQLException {
            return (Dao<Sale, Long>) getDao(Sale.class);
        }

        public Dao<Wholesaler, Long> Wholesaler() throws SQLException {
            return (Dao<Wholesaler, Long>) getDao(Wholesaler.class);
        }

        private void clear() {
            daos.clear();
        }

    }


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {
            Log.i(DatabaseHelper.class.getName(), "onCreate");

            for (Class entity : entities) {
                TableUtils.createTable(connectionSource, entity);
            }

        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        }

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            Log.i(DatabaseHelper.class.getName(), "onUpgrade");

            for (Class entity : entities) {
                TableUtils.dropTable(connectionSource, entity, true);
            }
            onCreate(db, connectionSource);

        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't drop databases", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {
        super.close();
        DAO.clear();
    }
}