package com.example.healthrecord.data.vo;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class NurseVO implements Parcelable {

    @SerializedName("id")
    private String nurseId;

    private String firstName;

    private String lastName;

    @SerializedName("emailId")
    private String emailId;

    private String password;

    private String role;

    protected NurseVO(Parcel in) {
        nurseId = in.readString();
        firstName = in.readString();
        lastName = in.readString();
        emailId = in.readString();
        password = in.readString();
        role = in.readString();
    }

    public static final Creator<NurseVO> CREATOR = new Creator<NurseVO>() {
        @Override
        public NurseVO createFromParcel(Parcel in) {
            return new NurseVO(in);
        }

        @Override
        public NurseVO[] newArray(int size) {
            return new NurseVO[size];
        }
    };

    public String getNurseId() {
        return nurseId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(nurseId);
        parcel.writeString(firstName);
        parcel.writeString(lastName);
        parcel.writeString(emailId);
        parcel.writeString(password);
        parcel.writeString(role);
    }
}
