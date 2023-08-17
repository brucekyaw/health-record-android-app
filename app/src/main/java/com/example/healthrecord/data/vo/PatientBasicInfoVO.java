package com.example.healthrecord.data.vo;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class PatientBasicInfoVO implements Parcelable {

    @SerializedName("room")
    private String roomNumber;

    public PatientBasicInfoVO(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    protected PatientBasicInfoVO(Parcel in) {
        roomNumber = in.readString();
    }

    public static final Creator<PatientBasicInfoVO> CREATOR = new Creator<PatientBasicInfoVO>() {
        @Override
        public PatientBasicInfoVO createFromParcel(Parcel in) {
            return new PatientBasicInfoVO(in);
        }

        @Override
        public PatientBasicInfoVO[] newArray(int size) {
            return new PatientBasicInfoVO[size];
        }
    };

    public String getRoomNumber() {
        return roomNumber;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(roomNumber);
    }
}
