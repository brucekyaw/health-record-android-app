package com.example.healthrecord.data.vo;

import com.google.gson.annotations.SerializedName;

import java.util.LinkedHashMap;

public class RecordFeatureVO {

    @SerializedName("id")
    private String recordId;

    @SerializedName("patientId")
    private String patientId;

    @SerializedName("name")
    private String patientName;

    @SerializedName("date")
    private String recordDate;

    @SerializedName("recordFeatures")
    private LinkedHashMap<String, String> recordFeatures;

    public String getRecordId() {
        return recordId;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getRecordDate() {
        return recordDate;
    }

    public LinkedHashMap<String, String> getRecordFeatures() {
        return recordFeatures;
    }
}
