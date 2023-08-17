package com.example.healthrecord.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.healthrecord.R;
import com.example.healthrecord.adapters.ViewPagerAdapter;
import com.example.healthrecord.data.vo.NurseVO;
import com.example.healthrecord.fragments.RegisterPatientFragment;
import com.example.healthrecord.fragments.ViewPatientFragment;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity{

    private static String KEY_NURSE_OBJECT = "KEY_NURSE_OBJECT";
    private ShapeableImageView imageView;
    private TextView tvUsername;
    private TextView tvUserid;
    private NurseVO nurse;
    private ViewPager vpPatient;
    private TabLayout tabPatient;
    private ViewPagerAdapter vpAdapter;


    public static Intent newIntent(Context context){
        Intent intent = new Intent(context,MainActivity.class);
        return intent;
    }

    public static Intent newIntent(Context context, NurseVO nurse){
        Intent intent = new Intent(context,MainActivity.class);
        intent.putExtra(KEY_NURSE_OBJECT, nurse);
        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nurse = getIntent().getParcelableExtra(KEY_NURSE_OBJECT);
        tvUsername = findViewById(R.id.tv_username);
        tvUserid = findViewById(R.id.tv_userid);
        dataBinder();
        vpPatient = findViewById(R.id.vp_patient);
        vpAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        tabPatient = findViewById(R.id.tabview_patient);
        vpPatient.setAdapter(vpAdapter);
        vpAdapter.addTab("View", new ViewPatientFragment());
        vpAdapter.addTab("Register", new RegisterPatientFragment());
        tabPatient.setupWithViewPager(vpPatient);
        vpPatient.setOffscreenPageLimit(vpAdapter.getCount());
    }
    private void dataBinder() {

        String fullName = nurse.getFirstName() +" " + nurse.getLastName();
        tvUsername.setText(fullName);
        tvUserid.setText(String.valueOf(nurse.getNurseId()));

    }
}