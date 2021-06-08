package com.example.paging_demo_app.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.paging_demo_app.Adapters.UsersAdapter;
import com.example.paging_demo_app.Models.UserModel;
import com.example.paging_demo_app.R;
import com.example.paging_demo_app.ViewModels.MainActivityViewModel;
import com.example.paging_demo_app.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    UsersAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        adapter = new UsersAdapter();
        setupRecyclerView();
        getUsers();
    }

    private void setupRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        binding.usersRecyclerView.setLayoutManager(linearLayoutManager);
        binding.usersRecyclerView.setAdapter(adapter);
    }

    private void getUsers() {
        MainActivityViewModel userViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        userViewModel.getUsers().observe(this, new Observer<PagedList<UserModel>>() {
            @Override
            public void onChanged(PagedList<UserModel> userModels) {
                if (userModels != null) {
                    adapter.submitList(userModels);
                }
            }
        });
    }
}