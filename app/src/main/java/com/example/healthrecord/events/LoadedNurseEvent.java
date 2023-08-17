package com.example.healthrecord.events;

import com.example.healthrecord.data.vo.NurseVO;

public class LoadedNurseEvent {

    private NurseVO nurse;

    public LoadedNurseEvent(NurseVO nurse) {
        this.nurse = nurse;
    }

    public NurseVO getNurse() {
        return nurse;
    }
}
