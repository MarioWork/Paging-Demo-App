package com.example.paging_demo_app.Repository;

import androidx.annotation.NonNull;
import androidx.paging.DataSource;

import com.example.paging_demo_app.Repository.UsersDataSource;

public class UsersDataSourceFactory extends DataSource.Factory {

    @NonNull
    @Override
    public DataSource create() {
        return new UsersDataSource();
    }
}
