package com.example.healthrecord.networks.responses;

import com.example.healthrecord.data.vo.PatientInfoVO;
import com.google.gson.annotations.SerializedName;

public class GetPatientResponse {
    private boolean success;
    private int code;
    private String message;
    @SerializedName("data")
    private PatientInfoVO patientInfo;

    public boolean isSuccess() {
        return success;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public PatientInfoVO getPatientInfo() {
        return patientInfo;
    }
}
