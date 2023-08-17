package com.example.healthrecord.events;

import com.example.healthrecord.data.vo.ResultVO;

public class LoadedPatientResultEvent {

    private ResultVO resultVO;

    public LoadedPatientResultEvent(ResultVO resultVO) {
        this.resultVO = resultVO;
    }

    public ResultVO getResultVO() {
        return resultVO;
    }
}
