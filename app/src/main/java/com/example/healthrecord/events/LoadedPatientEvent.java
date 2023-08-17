package com.example.healthrecord.events;

import com.example.healthrecord.data.vo.PatientInfoVO;

import java.util.List;

public class LoadedPatientEvent {
    private List<PatientInfoVO> patientInfoList;

    public LoadedPatientEvent(List<PatientInfoVO> patientInfoList) {
        this.patientInfoList = patientInfoList;
    }

    public List<PatientInfoVO> getPatientInfoList() {
        return patientInfoList;
    }
}
