package com.example.healthrecord.data.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataVO {

    @SerializedName("recordList")
    private List<RecordFeatureVO> recordFeatures;
    @SerializedName("patientList")
    private List<PatientInfoVO> patientInfoList;

    @SerializedName("data")
    private List<ResultVO> resultList;

    public List<ResultVO> getResultList() {
        return resultList;
    }

    public List<RecordFeatureVO> getRecordFeatures() {
        return recordFeatures;
    }

    public List<PatientInfoVO> getPatientInfoList() {
        return patientInfoList;
    }
}
