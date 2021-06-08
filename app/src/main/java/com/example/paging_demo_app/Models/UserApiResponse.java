package com.example.paging_demo_app.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserApiResponse {

    @SerializedName("data")
    private List<UserModel> usersList;

    public List<UserModel> getUsersList() {
        return usersList;
    }
}
