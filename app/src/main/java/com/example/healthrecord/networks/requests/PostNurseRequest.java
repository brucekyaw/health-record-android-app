package com.example.healthrecord.networks.requests;

import com.google.gson.annotations.SerializedName;

public class PostNurseRequest {

    @SerializedName("emailId")
    private String email;

    @SerializedName("password")
    private String password;

    public PostNurseRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
