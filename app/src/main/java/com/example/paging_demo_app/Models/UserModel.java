package com.example.paging_demo_app.Models;

import com.google.gson.annotations.SerializedName;

public class UserModel {

    @SerializedName("id")
    private int id;

    @SerializedName("first_name")
    private String name;

    @SerializedName("last_name")
    private String lastName;

    @SerializedName("avatar")
    private String profilePicture;



    //Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public String getLastName() {
        return lastName;
    }

}
