package com.example.paging_demo_app.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.example.paging_demo_app.Models.UserModel;
import com.example.paging_demo_app.Repository.UsersDataSourceFactory;

public class MainActivityViewModel extends AndroidViewModel {

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<PagedList<UserModel>> getUsers() {
        UsersDataSourceFactory usersDataSourceFactory = new UsersDataSourceFactory();
        PagedList.Config config =
                (new PagedList.Config.Builder()
                        .setEnablePlaceholders(false)
                        .setPageSize(6))
                        .build();

        return new LivePagedListBuilder(usersDataSourceFactory, config).build();
    }
}
