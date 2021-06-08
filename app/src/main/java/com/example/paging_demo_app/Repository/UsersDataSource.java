package com.example.paging_demo_app.Repository;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.example.paging_demo_app.Models.UserApiResponse;
import com.example.paging_demo_app.Models.UserModel;
import com.example.paging_demo_app.Retrofit.IUserService;
import com.example.paging_demo_app.Retrofit.UserServiceClient;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsersDataSource extends PageKeyedDataSource<Integer, UserModel> {

    private String TAG = this.getClass().getSimpleName();
    private IUserService userService;

    public UsersDataSource() {
        userService = UserServiceClient.getUserService();
    }

    @Override
    public void loadInitial(@NonNull PageKeyedDataSource.LoadInitialParams<Integer> params, @NonNull PageKeyedDataSource.LoadInitialCallback<Integer, UserModel> callback) {
        Call<UserApiResponse> call = userService.getUsers(1);

        call.enqueue(new Callback<UserApiResponse>() {
            @Override
            public void onResponse(Call<UserApiResponse> call, Response<UserApiResponse> response) {
                if (response != null) {
                    callback.onResult(response.body().getUsersList(), null, 2);
                }
            }

            @Override
            public void onFailure(Call<UserApiResponse> call, Throwable t) {
                Log.d(TAG, "failedLoadInitial: " + t.getMessage());
            }
        });

    }

    @Override
    public void loadBefore(@NonNull PageKeyedDataSource.LoadParams<Integer> params, @NonNull PageKeyedDataSource.LoadCallback<Integer, UserModel> callback) {
        Call<UserApiResponse> call = userService.getUsers(params.key);

        call.enqueue(new Callback<UserApiResponse>() {
            @Override
            public void onResponse(Call<UserApiResponse> call, Response<UserApiResponse> response) {
                if (response != null) {
                    Integer key = params.key > 1 ? params.key - 1 : null;
                    callback.onResult(response.body().getUsersList(), key);
                }
            }

            @Override
            public void onFailure(Call<UserApiResponse> call, Throwable t) {
                Log.d(TAG, "failedLoadBefore: " + t.getMessage());
            }
        });
    }

    @Override
    public void loadAfter(@NonNull PageKeyedDataSource.LoadParams<Integer> params, @NonNull PageKeyedDataSource.LoadCallback<Integer, UserModel> callback) {
        Call<UserApiResponse> call = userService.getUsers(params.key);

        call.enqueue(new Callback<UserApiResponse>() {
            @Override
            public void onResponse(Call<UserApiResponse> call, Response<UserApiResponse> response) {
                if (response != null) {
                    Integer key = params.key > 1 ? params.key + 1 : null;
                    callback.onResult(response.body().getUsersList(), key);
                }
            }

            @Override
            public void onFailure(Call<UserApiResponse> call, Throwable t) {
                Log.d(TAG, "failedLoadAfter: " + t.getMessage());
            }
        });
    }
}
