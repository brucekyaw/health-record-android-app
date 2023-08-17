package com.example.healthrecord.networks.responses;

import com.example.healthrecord.data.vo.DataVO;
import com.google.gson.annotations.SerializedName;

public class GetPatientRecordResponse {

    private boolean success;
    private int code;
    private String message;
    @SerializedName("data")
    private DataVO dataVO;

    public boolean isSuccess() {
        return success;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public DataVO getDataVO() {
        return dataVO;
    }
}
