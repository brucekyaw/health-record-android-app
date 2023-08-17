package com.example.healthrecord.events;

import com.example.healthrecord.data.vo.RecordFeatureVO;

public class LoadedPatientRecordEvent {

    private RecordFeatureVO recordFeature;

    public LoadedPatientRecordEvent(RecordFeatureVO recordFeature) {
        this.recordFeature = recordFeature;
    }

    public RecordFeatureVO getRecordFeature() {
        return recordFeature;
    }
}
