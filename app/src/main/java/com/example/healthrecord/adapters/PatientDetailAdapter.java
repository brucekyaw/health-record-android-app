package com.example.healthrecord.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.healthrecord.R;

import java.util.LinkedHashMap;

public class PatientDetailAdapter extends BaseAdapter {

    private LinkedHashMap<String, String> mMedicalRecordList;
    private Context context;
    public PatientDetailAdapter(Context context){
        mMedicalRecordList = new LinkedHashMap<>();
        this.context = context;
    }

    @Override
    public int getCount() {
        return mMedicalRecordList.size();
    }

    @Override
    public Object getItem(int position) {
        return mMedicalRecordList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if(view == null){
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.item_medical_detail,parent,false);
        }

        String key = (String) mMedicalRecordList.keySet().toArray()[position];
        String value = mMedicalRecordList.get(key);

        TextView labelTextView = view.findViewById(R.id.tv_label);
        TextView valueTextView = view.findViewById(R.id.tv_value);

        labelTextView.setText(key);
        valueTextView.setText(value);

        return view;
    }

    public void setMedicalRecordList(LinkedHashMap<String, String> medicalRecordList){
        mMedicalRecordList =medicalRecordList;
        notifyDataSetChanged();
    }

}
