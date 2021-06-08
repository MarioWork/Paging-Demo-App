package com.example.paging_demo_app.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.paging_demo_app.Utils.AppConstants.BASE_URL;

public class UserServiceClient {

    private static Retrofit retrofit;

   private static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }

    public static IUserService getUserService() {
        return getRetrofitInstance().create(IUserService.class);
    }
}
