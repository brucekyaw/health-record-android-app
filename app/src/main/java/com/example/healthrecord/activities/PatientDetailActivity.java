package com.example.healthrecord.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.TextView;

import com.example.healthrecord.R;
import com.example.healthrecord.adapters.PatientDetailAdapter;
import com.example.healthrecord.data.models.PatientModel;
import com.example.healthrecord.events.LoadedPatientRecordEvent;
import com.example.healthrecord.events.LoadedPatientResultEvent;
import com.example.healthrecord.utils.ResultConverterUtils;
import com.google.android.material.imageview.ShapeableImageView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class PatientDetailActivity extends AppCompatActivity {

    private static String KEY_PATIENT_ID = "KEY_PATIENT_ID";
    private TextView tvMedicalRecordId;
    private TextView tvMedicalRecordDate;
    private TextView tvPatientName;
    private TextView lblMedicalRecordDate;
    private TextView lblPatientName;
    private TextView lblMedicalRecordId;
    private GridView gridPatientDetail;
    private PatientDetailAdapter patientDetailAdapter;
    private ShapeableImageView imgPatient;
    private FrameLayout flNoMedicalRecord;
    private TextView lblMedicalResult;
    private TextView tvMedicalResult;
    private CardView cardView;
    private String patientId;

    public static Intent newIntent(Context context){
        Intent intent = new Intent(context,PatientDetailActivity.class);
        return intent;
    }

    public static Intent newIntent(Context context,String patientId){
        Intent intent = new Intent(context,PatientDetailActivity.class);
        intent.putExtra(KEY_PATIENT_ID,patientId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_detail);
        patientId = getIntent().getStringExtra(KEY_PATIENT_ID);
        bindComponent();
//        bindData();
//        LinkedHashMap<String,String> data = patient.getPatientDetailVO().getData();
        patientDetailAdapter = new PatientDetailAdapter(this);
        gridPatientDetail.setNumColumns(2);
        gridPatientDetail.setAdapter(patientDetailAdapter);
        PatientModel.getsObjectInstance().loadPatientDetail(patientId);
        PatientModel.getsObjectInstance().loadPatientResult(patientId);

    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPatientRecordLoaded(LoadedPatientRecordEvent event){
            patientDetailAdapter.setMedicalRecordList(event.getRecordFeature().getRecordFeatures());
            tvMedicalRecordId.setText(event.getRecordFeature().getRecordId());
            tvPatientName.setText(event.getRecordFeature().getPatientName());
            tvMedicalRecordDate.setText(event.getRecordFeature().getRecordDate());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPatientResultLoaded(LoadedPatientResultEvent event){
        ResultConverterUtils.setMedicalResultWithColor(tvMedicalResult, event.getResultVO().getResult());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onNoPatientRecord(String message){
        flNoMedicalRecord.setVisibility(View.VISIBLE);
        tvMedicalRecordId.setVisibility(View.GONE);
        tvPatientName.setVisibility(View.GONE);
        tvMedicalRecordDate.setVisibility(View.GONE);
        imgPatient.setVisibility(View.GONE);
        gridPatientDetail.setVisibility(View.GONE);
        cardView.setVisibility(View.GONE);
        lblMedicalRecordDate.setVisibility(View.GONE);
        lblPatientName.setVisibility(View.GONE);
        lblMedicalRecordId.setVisibility(View.GONE);
        lblMedicalResult.setVisibility(View.GONE);
        tvMedicalResult.setVisibility(View.GONE);
    }

    private void bindComponent() {
        gridPatientDetail = findViewById(R.id.grid_patient_detail);
        tvMedicalRecordId = findViewById(R.id.tv_medical_record_id);
        tvMedicalRecordDate = findViewById(R.id.tv_medical_date);
        tvPatientName = findViewById(R.id.tv_patient_name);
        flNoMedicalRecord = findViewById(R.id.fl_no_medical_record);
        imgPatient = findViewById(R.id.patientImageView);
        cardView = findViewById(R.id.cardView);
        lblMedicalRecordId = findViewById(R.id.label_medical_record_id);
        lblPatientName = findViewById(R.id.label_patient_name);
        lblMedicalRecordDate = findViewById(R.id.label_medical_date);
        lblMedicalResult = findViewById(R.id.label_heart_disease_result);
        tvMedicalResult = findViewById(R.id.tv_heart_disease_result);

    }

}
