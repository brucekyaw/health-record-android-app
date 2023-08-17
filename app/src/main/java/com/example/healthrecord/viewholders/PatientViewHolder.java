package com.example.healthrecord.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthrecord.R;
import com.example.healthrecord.data.vo.PatientInfoVO;
import com.example.healthrecord.delegates.PatientActionDelegates;

public class PatientViewHolder extends RecyclerView.ViewHolder {
    private TextView tvPatientName;
    private TextView tvRoomNumber;
//    private ImageView lightIndicator;
    private ImageView arrowIcon;
    private CardView cvPatient;
    private PatientActionDelegates mPatientActionDelegates;
    private PatientInfoVO patientInfoVO;
    public PatientViewHolder(@NonNull View itemView, PatientActionDelegates patientActionDelegates) {
        super(itemView);

        mPatientActionDelegates = patientActionDelegates;
        tvPatientName = itemView.findViewById(R.id.tv_patient_name);
        tvRoomNumber = itemView.findViewById(R.id.tv_roomnumber);
//        lightIndicator = itemView.findViewById(R.id.LightIndicator);
        arrowIcon = itemView.findViewById(R.id.iv_arrow);
        cvPatient = itemView.findViewById(R.id.cv_patient);
        cvPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPatientActionDelegates.onPatientClicked(patientInfoVO);
            }
        });

    }

    public void setPatientData(PatientInfoVO patient){
        this.patientInfoVO = patient;
        tvPatientName.setText(String.valueOf(patient.getPatientName()));
        tvRoomNumber.setText(String.valueOf(patient.getPatientBasicInfo().getRoomNumber()));
//        lightIndicator.setImageResource(patient.isCritical() ? R.drawable.holo_red_light : R.drawable.holo_green_light);
        arrowIcon.setImageResource(R.drawable.baseline_arrow_right_24);

    }

}
