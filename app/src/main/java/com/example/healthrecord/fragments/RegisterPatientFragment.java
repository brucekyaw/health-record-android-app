package com.example.healthrecord.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.healthrecord.R;
import com.example.healthrecord.data.models.PatientModel;
import com.example.healthrecord.utils.ValidationUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class RegisterPatientFragment extends Fragment {

    private EditText tvPatientName;
    private EditText tvPatientRoomNumber;
    private Button btnRegister;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_patient_register, container, false);

        tvPatientName = view.findViewById(R.id.et_patient_name);
        tvPatientRoomNumber = view.findViewById(R.id.et_room_number);
        btnRegister = view.findViewById(R.id.btn_register);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkPatient();
            }
        });
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSuccessRegister(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
        PatientModel.getsObjectInstance().loadPatient();
    }

    private void checkPatient() {
        String patientName = tvPatientName.getText().toString();
        String roomNumber = tvPatientRoomNumber.getText().toString();
        if(ValidationUtils.isValidPatientName(getContext(),patientName) && ValidationUtils.isRoomNumberValid(getContext(),roomNumber)){
            PatientModel.getsObjectInstance().registerPatient(patientName,roomNumber);
            tvPatientName.setText("");
            tvPatientRoomNumber.setText("");
        }

    }
}
