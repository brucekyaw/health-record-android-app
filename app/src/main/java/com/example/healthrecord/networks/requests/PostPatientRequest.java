package com.example.healthrecord.networks.requests;

import com.example.healthrecord.data.vo.PatientBasicInfoVO;
import com.google.gson.annotations.SerializedName;

public class PostPatientRequest {

    @SerializedName("name")
    private String patientName;

    @SerializedName("patient")
    private PatientBasicInfoVO patientBasicInfoVO;

    public PostPatientRequest(String patientName, PatientBasicInfoVO patientBasicInfoVO) {
        this.patientName = patientName;
        this.patientBasicInfoVO = patientBasicInfoVO;
    }

    public String getPatientName() {
        return patientName;
    }

    public PatientBasicInfoVO getPatientBasicInfo() {
        return patientBasicInfoVO;
    }
}
