package com.example.healthrecord.data.vo;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class PatientInfoVO implements Parcelable {

    @SerializedName("id")
    private String patientId;

    @SerializedName("name")
    private String patientName;

    @SerializedName("patient")
    private PatientBasicInfoVO patientBasicInfoVO;

    protected PatientInfoVO(Parcel in) {
        patientId = in.readString();
        patientName = in.readString();
    }

    public static final Creator<PatientInfoVO> CREATOR = new Creator<PatientInfoVO>() {
        @Override
        public PatientInfoVO createFromParcel(Parcel in) {
            return new PatientInfoVO(in);
        }

        @Override
        public PatientInfoVO[] newArray(int size) {
            return new PatientInfoVO[size];
        }
    };

    public String getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public PatientBasicInfoVO getPatientBasicInfo() {
        return patientBasicInfoVO;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(patientId);
        parcel.writeString(patientName);
    }
}
