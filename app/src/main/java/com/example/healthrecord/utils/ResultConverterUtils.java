package com.example.healthrecord.utils;

import android.graphics.Color;
import android.widget.TextView;

import java.util.Objects;

public class ResultConverterUtils {

    public static void setMedicalResultWithColor(TextView textView, String result) {
        if (Objects.equals(result, "0")) {
            textView.setText("Healthy");
            textView.setTextColor(Color.GREEN);
        } else {
            textView.setText("Unhealthy");
            textView.setTextColor(Color.RED);
        }
    }
}
