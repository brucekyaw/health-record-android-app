package com.example.healthrecord.networks.responses;

import com.example.healthrecord.data.vo.DataVO;
import com.google.gson.annotations.SerializedName;

public class GetPatientResultResponse {

    private boolean success;
    private int code;
    private String message;
    @SerializedName("data")
    private DataVO data;

    public boolean isSuccess() {
        return success;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public DataVO getData() {
        return data;
    }
}
