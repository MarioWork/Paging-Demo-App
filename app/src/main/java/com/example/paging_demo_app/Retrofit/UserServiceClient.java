package com.example.paging_demo_app.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.paging_demo_app.Utils.AppConstants.BASE_URL;

public class UserServiceClient {

    private static Retrofit retrofit;

    public UserServiceClient() {
        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

    }

    public static IUserService getUserService() {
        return retrofit.create(IUserService.class);
    }
}
