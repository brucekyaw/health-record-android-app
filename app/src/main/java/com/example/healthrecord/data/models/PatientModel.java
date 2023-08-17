package com.example.healthrecord.data.models;

import com.example.healthrecord.networks.ClinicDataAgent;
import com.example.healthrecord.networks.RetrofitDataAgent;

public class PatientModel {

    public static PatientModel sObjectInstance;

    private ClinicDataAgent mDataAgent;

    public PatientModel() {
        this.mDataAgent = RetrofitDataAgent.getsObjInstance();
    }

    public static PatientModel getsObjectInstance(){
        if(sObjectInstance == null){
                sObjectInstance = new PatientModel();
        }
        return sObjectInstance;
    }

    public void registerPatient(String patientName, String roomNumber){
        mDataAgent.postPatient(patientName,roomNumber);
    }

    public void loadPatient(){
        mDataAgent.loadPatient();
    }

    public void loadPatientDetail(String patientId){
        mDataAgent.loadPatientRecord(patientId);
    }

    public void loadPatientResult(String patientId){
        mDataAgent.loadPatientResult(patientId);
    }
}
