package com.example.healthrecord.networks;

import android.util.Log;

import com.example.healthrecord.data.vo.PatientBasicInfoVO;
import com.example.healthrecord.events.LoadedNurseEvent;
import com.example.healthrecord.events.LoadedPatientEvent;
import com.example.healthrecord.events.LoadedPatientRecordEvent;
import com.example.healthrecord.events.LoadedPatientResultEvent;
import com.example.healthrecord.networks.requests.PostNurseRequest;
import com.example.healthrecord.networks.requests.PostPatientRequest;
import com.example.healthrecord.networks.responses.GetNurseResponse;
import com.example.healthrecord.networks.responses.GetPatientRecordResponse;
import com.example.healthrecord.networks.responses.GetPatientResponse;
import com.example.healthrecord.networks.responses.GetPatientResultResponse;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitDataAgent implements ClinicDataAgent{

    private static RetrofitDataAgent sObjInstance;
    private ClinicApi mClinicApi;
    private static String ACCESS_TOKEN_HEADER;

    private RetrofitDataAgent(){
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://adproj.azurewebsites.net")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(httpClient)
                .build();

        mClinicApi = retrofit.create(ClinicApi.class);
    }
    public static RetrofitDataAgent getsObjInstance(){
        if(sObjInstance==null)
            sObjInstance = new RetrofitDataAgent();
        return sObjInstance;
    }

    @Override
    public void loadPatient() {

        Call<GetPatientRecordResponse> getPatientRecordResponseCall = mClinicApi.loadPatient("Bearer "+ACCESS_TOKEN_HEADER);
        getPatientRecordResponseCall.enqueue(new Callback<GetPatientRecordResponse>() {
            @Override
            public void onResponse(Call<GetPatientRecordResponse> call, Response<GetPatientRecordResponse> response) {
                if(response.isSuccessful()){
                    GetPatientRecordResponse getPatientResponse = response.body();
                    if(getPatientResponse != null && getPatientResponse.getDataVO() != null){
                        LoadedPatientEvent loadedPatientEvent = new LoadedPatientEvent(getPatientResponse.getDataVO().getPatientInfoList());
                        EventBus.getDefault().post(loadedPatientEvent);
                    }
                    else{
                        Log.d("Response Check", "getNurseResponse or getNurse() is null");
                    }
                }
                else {
                    Log.d("Response Check", "Unsuccessful response" + response.code());

                    String errorBody = null;
                    try {
                        errorBody = response.errorBody().string();
                        Log.d("Response Check", "Error body: " + errorBody);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            @Override
            public void onFailure(Call<GetPatientRecordResponse> call, Throwable t) {
            }
        });


    }

    @Override
    public void postPatient(String patientName, String roomNumber) {

        PatientBasicInfoVO patientBasicInfoVO = new PatientBasicInfoVO(roomNumber);
        Call<GetPatientResponse> getPatientResponseCall = mClinicApi.postPatientRecord("Bearer "+ACCESS_TOKEN_HEADER,new PostPatientRequest(patientName, patientBasicInfoVO));

        getPatientResponseCall.enqueue(new Callback<GetPatientResponse>() {
            @Override
            public void onResponse(Call<GetPatientResponse> call, Response<GetPatientResponse> response) {
                if(response.isSuccessful()){
                    GetPatientResponse getPatientResponse = response.body();
                    if(getPatientResponse != null && getPatientResponse.getPatientInfo() != null){
                        EventBus.getDefault().post(getPatientResponse.getMessage());
                    }
                    else{
                        Log.d("Response Check", "getNurseResponse or getNurse() is null");
                    }
                }
                else {
                    Log.d("Response Check", "Unsuccessful response" + response.code());

                    String errorBody = null;
                    try {
                        errorBody = response.errorBody().string();
                        Log.d("Response Check", "Error body: " + errorBody);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            @Override
            public void onFailure(Call<GetPatientResponse> call, Throwable t) {
            }
        });

    }

    @Override
    public void loadPatientRecord(String patientId) {

        Call<GetPatientRecordResponse> getPatientRecordResponseCall = mClinicApi.loadPatientRecord("Bearer "+ACCESS_TOKEN_HEADER,patientId);

        getPatientRecordResponseCall.enqueue(new Callback<GetPatientRecordResponse>() {
            @Override
            public void onResponse(Call<GetPatientRecordResponse> call, Response<GetPatientRecordResponse> response) {
                if(response.isSuccessful()){
                    GetPatientRecordResponse getPatientRecordResponse = response.body();
                    if(getPatientRecordResponse != null && getPatientRecordResponse.getDataVO().getRecordFeatures().size()>0 ) {
                        if (getPatientRecordResponse.getDataVO().getRecordFeatures().get(0).getRecordFeatures() != null) {
                            LoadedPatientRecordEvent event = new LoadedPatientRecordEvent(getPatientRecordResponse.getDataVO().getRecordFeatures().get(0));
                            EventBus.getDefault().post(event);
                        }
                        else{
                            EventBus.getDefault().post("No Medical Data yet");
                        }
                    } else{
                        EventBus.getDefault().post("No Medical Data yet");
                    }

                }
                else {
                    Log.d("Response Check", "Unsuccessful response" + response.code());

                    String errorBody = null;
                    try {
                        errorBody = response.errorBody().string();
                        Log.d("Response Check", "Error body: " + errorBody);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            @Override
            public void onFailure(Call<GetPatientRecordResponse> call, Throwable t) {

            }
        });

    }

    @Override
    public void loadNurse(String emailId, String password) {
        PostNurseRequest requestBody = new PostNurseRequest(emailId,password);
        Call<GetNurseResponse> getNurseResponseCall = mClinicApi.loadNurse(requestBody);

        //call api object
        getNurseResponseCall.enqueue(new Callback<GetNurseResponse>() {
            @Override
            public void onResponse(Call<GetNurseResponse> call, Response<GetNurseResponse> response) {
                if(response.isSuccessful()){
                    GetNurseResponse getNurseResponse = response.body();
                    if(getNurseResponse != null && getNurseResponse.getNurse()!=null && getNurseResponse.getNurse().getRole().equals("NURSE")){
                        ACCESS_TOKEN_HEADER = getNurseResponse.getAccessToken();
                        LoadedNurseEvent event = new LoadedNurseEvent(getNurseResponse.getNurse());
                        EventBus.getDefault().post(event);
                    }
                    else
                    {
                        EventBus.getDefault().post("Unauthorized User");
                    }
                }
                else {
                    Log.d("Response Check", "Unsuccessful response" + response.code());

                    String errorBody = null;
                    try {
                        errorBody = response.errorBody().string();
                        Log.d("Response Check", "Error body: " + errorBody);
                        EventBus.getDefault().post("Unauthorized User");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            @Override
            public void onFailure(Call<GetNurseResponse> call, Throwable t) {
                Log.d("Failed Callback","Somethings wrong");
            }
        });
    }

    @Override
    public void loadPatientResult(String patientId) {
        Call<GetPatientResultResponse> getPatientResultResponseCall = mClinicApi.loadPatientResult("Bearer "+ ACCESS_TOKEN_HEADER,patientId);

        getPatientResultResponseCall.enqueue(new Callback<GetPatientResultResponse>() {
            @Override
            public void onResponse(Call<GetPatientResultResponse> call, Response<GetPatientResultResponse> response) {
                if(response.isSuccessful()){
                    GetPatientResultResponse getPatientResultResponse = response.body();
                    if(getPatientResultResponse != null && getPatientResultResponse.getData().getResultList().size()>0 ) {
                        if (getPatientResultResponse.getData().getResultList().get(0) != null) {
                            LoadedPatientResultEvent event = new LoadedPatientResultEvent(getPatientResultResponse.getData().getResultList().get(0));
                            EventBus.getDefault().post(event);
                        }
                        else{

                        }
                    } else{

                    }

                }
                else {
                    Log.d("Response Check", "Unsuccessful response" + response.code());

                    String errorBody = null;
                    try {
                        errorBody = response.errorBody().string();
                        Log.d("Response Check", "Error body: " + errorBody);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            @Override
            public void onFailure(Call<GetPatientResultResponse> call, Throwable t) {

            }
        });

    }
}
