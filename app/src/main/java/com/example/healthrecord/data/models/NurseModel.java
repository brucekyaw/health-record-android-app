package com.example.healthrecord.data.models;

import com.example.healthrecord.networks.ClinicDataAgent;
import com.example.healthrecord.networks.RetrofitDataAgent;

public class NurseModel {

    private static NurseModel sObjectInstance;
    private ClinicDataAgent mDataAgent;

    private NurseModel(){
        mDataAgent = RetrofitDataAgent.getsObjInstance();
    }

    public static NurseModel getsObjectInstance(){
        if(sObjectInstance == null){
            sObjectInstance = new NurseModel();
        }
        return sObjectInstance;
    }

    public void loadNurse(String emailid, String password){
        mDataAgent.loadNurse(emailid,password);
    }

}
