package com.example.paging_demo_app.Retrofit;


import com.example.paging_demo_app.Models.UserApiResponse;


import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IUserService {

    @GET("users")
    Call<UserApiResponse> getUsers(
            @Query("page") int page
    );

}
