package com.example.healthrecord.networks;

import com.example.healthrecord.networks.requests.PostNurseRequest;
import com.example.healthrecord.networks.requests.PostPatientRequest;
import com.example.healthrecord.networks.responses.GetNurseResponse;
import com.example.healthrecord.networks.responses.GetPatientRecordResponse;
import com.example.healthrecord.networks.responses.GetPatientResponse;
import com.example.healthrecord.networks.responses.GetPatientResultResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ClinicApi {


    @GET("/nurse/patient")
    Call<GetPatientRecordResponse> loadPatient(@Header("Authorization") String accessToken);
    @POST("/auth/login")
    Call<GetNurseResponse> loadNurse(@Body PostNurseRequest postNurseRequest);
    @GET("/nurse/patient_record/{patientId}")
    Call<GetPatientRecordResponse> loadPatientRecord(@Header("Authorization") String accessToken, @Path("patientId") String patientId);
    @POST("/nurse/patient")
    Call<GetPatientResponse> postPatientRecord(@Header("Authorization") String accessToken, @Body PostPatientRequest postPatientRequest);
    @GET("/researcher/patientId/{patientId}")
    Call<GetPatientResultResponse> loadPatientResult(@Header("Authorization") String accessToken, @Path("patientId") String patientId);

}
