//package com.example.healthrecord.data.vo;
//
//import android.util.ArrayMap;
//
//import com.google.gson.annotations.SerializedName;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//
//public class PatientDetailVO {
//
//    private int medicalRecordId;
//    private Date medicalRecordDate;
//    private String gender;
//    private String education;
//    private LinkedHashMap<String, String> data;
//    private String heartDiseaseResult;
//
//    public PatientDetailVO(int medicalRecordId, Date medicalRecordDate, String gender, String education, LinkedHashMap<String, String> data, String heartDiseaseResult) {
//        this.medicalRecordId = medicalRecordId;
//        this.medicalRecordDate = medicalRecordDate;
//        this.gender = gender;
//        this.education = education;
//        this.data = data;
//        this.heartDiseaseResult = heartDiseaseResult;
//    }
//
//    public int getMedicalRecordId() {
//        return medicalRecordId;
//    }
//
//    public Date getMedicalRecordDate() {
//        return medicalRecordDate;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//    public LinkedHashMap<String, String> getData() {
//        return data;
//    }
//
//    public String getHeartDiseaseResult() {
//        return heartDiseaseResult;
//    }
//}