package com.example.healthrecord.networks.responses;
import com.example.healthrecord.data.vo.NurseVO;
import com.google.gson.annotations.SerializedName;

public class GetNurseResponse {

    @SerializedName("user")
    private NurseVO nurse;

    @SerializedName("access_token")
    private String accessToken;

    public NurseVO getNurse() {
        return nurse;
    }

    public String getAccessToken() {
        return accessToken;
    }

}
