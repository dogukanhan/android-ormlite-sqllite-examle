package com.dogukanhan.ormlitetest;

import java.sql.SQLException;
import java.util.Random;


import android.os.Bundle;
import android.util.Log;

import com.dogukanhan.ormlitetest.config.DatabaseHelper;
import com.dogukanhan.ormlitetest.model.Category;
import com.dogukanhan.ormlitetest.model.Product;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;

public class MainActivity extends OrmLiteBaseActivity<DatabaseHelper> {

    private final String LOG_TAG = getClass().getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(LOG_TAG, "creating " + getClass() + " at " + System.currentTimeMillis());

        try {

            Category category = new Category();
            category.setName("test" + new Random().nextInt());

            getHelper().getCategoryDao().create(category);

            Product product = new Product();
            product.setName("dogukan han");
            product.setCategory(category);

            getHelper().getProductDao().create(product);

            String out = getHelper().getCategoryDao().queryForAll().get(0).getProducts().iterator().next().getName();

            Log.d("test", "finishes");
            Log.d("test1", "The name is =" + out);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}

