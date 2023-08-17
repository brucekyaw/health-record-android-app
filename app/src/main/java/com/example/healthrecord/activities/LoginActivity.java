package com.example.healthrecord.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.healthrecord.R;
import com.example.healthrecord.data.models.NurseModel;
import com.example.healthrecord.data.vo.NurseVO;
import com.example.healthrecord.events.LoadedNurseEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class LoginActivity extends AppCompatActivity{
    EditText etUserName;
    EditText etPassword;
    Button btnSignIn;
    private NurseVO nurse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUserName = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btnSignIn = findViewById(R.id.btn_signin);
//        nurseList = NurseDataGenerator.generateNurseData();
        btnSignIn.setOnClickListener(view -> checkUser());

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
    public void onUserSuccess(LoadedNurseEvent event){
            Log.d("User Loaded", "onUserLoaded :" + event.getNurse());
            nurse = event.getNurse();
            loginSuccess(nurse);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onUserFailed(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void checkUser(){
        String username = etUserName.getText().toString();
        String password = etPassword.getText().toString();
        NurseModel.getsObjectInstance().loadNurse(username,password);
    }
    private void loginSuccess(NurseVO user){
        Intent intent = MainActivity.newIntent(getApplicationContext(),user);
        startActivity(intent);
    }


}
