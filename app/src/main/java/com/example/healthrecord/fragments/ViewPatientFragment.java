package com.example.healthrecord.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthrecord.R;
import com.example.healthrecord.activities.PatientDetailActivity;
import com.example.healthrecord.adapters.PatientAdapter;
import com.example.healthrecord.data.models.PatientModel;
import com.example.healthrecord.data.vo.PatientInfoVO;
import com.example.healthrecord.delegates.PatientActionDelegates;
import com.example.healthrecord.events.LoadedPatientEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class ViewPatientFragment extends Fragment implements PatientActionDelegates {

    private RecyclerView recyclerView;
    private PatientAdapter mPatientAdapter;
    private SearchView svPatientName;
    private List<PatientInfoVO> filteredPatientList = new ArrayList<>();

    private List<PatientInfoVO> originalPatientList = new ArrayList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_patient_view,container,false);
        svPatientName = view.findViewById(R.id.sv_patient_name);
        mPatientAdapter = new PatientAdapter(this);
        recyclerView = view.findViewById(R.id.rv_patient_list);
        recyclerView.setAdapter(mPatientAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        if (savedInstanceState != null) {
            filteredPatientList = savedInstanceState.getParcelableArrayList("filteredPatientList");
            originalPatientList = savedInstanceState.getParcelableArrayList("originalPatientList");
            mPatientAdapter.setPatientList(filteredPatientList);
        }else {
            PatientModel.getsObjectInstance().loadPatient();
        }
        svPatientName.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                mPatientAdapter.setPatientList(originalPatientList);
                filteredPatientList = mPatientAdapter.filter(newText);
                return true;
            }
        });

        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("filteredPatientList", (ArrayList<? extends Parcelable>) filteredPatientList);
        outState.putParcelableArrayList("originalPatientList", (ArrayList<? extends Parcelable>) originalPatientList);
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
    public void onPatientListLoaded(LoadedPatientEvent event){
        originalPatientList = event.getPatientInfoList();
        mPatientAdapter.setPatientList(event.getPatientInfoList());
    }
    @Override
    public void onPatientClicked(PatientInfoVO patient) {
        Intent intent = PatientDetailActivity.newIntent(getContext(),patient.getPatientId());
        startActivity(intent);
    }

}
