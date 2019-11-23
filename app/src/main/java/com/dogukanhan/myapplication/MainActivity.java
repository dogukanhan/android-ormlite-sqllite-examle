package com.dogukanhan.myapplication;

import java.sql.SQLException;


import android.os.Bundle;
import android.util.Log;

import com.dogukanhan.myapplication.config.DatabaseHelper;
import com.dogukanhan.myapplication.model.Category;
import com.dogukanhan.myapplication.model.Product;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;

public class MainActivity extends OrmLiteBaseActivity<DatabaseHelper> {

    private final String LOG_TAG = getClass().getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(LOG_TAG, "creating " + getClass() + " at " + System.currentTimeMillis());

        try {

            Category category = new Category();
            category.setName("test");

            getHelper().getCategoryDAO().create(category);

            Product product = new Product();
            product.setName("dogukan han");
            product.setCategory(category);

            getHelper().getProductDAO().create(product);

            String out = getHelper().getCategoryDAO().queryForAll().get(0).getProducts().iterator().next().getName();

            Log.d("test", "finishes");
            Log.d("test1", "The name is =" + out);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}

