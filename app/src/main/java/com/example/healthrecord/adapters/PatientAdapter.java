package com.example.healthrecord.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthrecord.R;
import com.example.healthrecord.data.vo.PatientInfoVO;
import com.example.healthrecord.delegates.PatientActionDelegates;
import com.example.healthrecord.viewholders.PatientViewHolder;

import java.util.ArrayList;
import java.util.List;

public class PatientAdapter extends RecyclerView.Adapter<PatientViewHolder> {
    private List<PatientInfoVO> mpatientList;
    private PatientActionDelegates mpatientActionDelegates;
    private List<PatientInfoVO> mFilteredPatientList;

    public PatientAdapter(PatientActionDelegates patientActionDelegates) {
        mpatientList = new ArrayList<>();
        mpatientActionDelegates = patientActionDelegates;
        mFilteredPatientList = new ArrayList<>();
    }

    @NonNull
    @Override
    public PatientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View patientItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category,parent,false);
        PatientViewHolder patientViewHolder = new PatientViewHolder(patientItemView,mpatientActionDelegates);
        return patientViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PatientViewHolder holder, int position) {
        PatientInfoVO patient = mFilteredPatientList.get(position);
        holder.setPatientData(patient);
    }
    @Override
    public int getItemCount() {
        return mFilteredPatientList.size();
    }

    public void setPatientList(List<PatientInfoVO> patientList){
        mpatientList =patientList;
        mFilteredPatientList = new ArrayList<>(patientList);
        notifyDataSetChanged();
    }


    public List<PatientInfoVO> filter(String query) {
        mFilteredPatientList.clear();
        if (query.isEmpty()) {
            mFilteredPatientList.addAll(mpatientList);
        } else {
            query = query.toLowerCase();
            for (PatientInfoVO patient : mpatientList) {
                if (patient.getPatientName().toLowerCase().contains(query)) {
                    mFilteredPatientList.add(patient);
                }
            }
        }
        notifyDataSetChanged();
        return mFilteredPatientList;
    }

}
