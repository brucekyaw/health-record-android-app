package com.example.healthrecord.utils;
import android.content.Context;
import android.widget.Toast;
import androidx.annotation.NonNull;

public class ValidationUtils {

    public static boolean isValidPatientName(Context context,String patientName) {
        if (patientName.isEmpty()) {
            Toast.makeText(context, "Name Cannot be Blank", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(patientName.matches("^[a-zA-Z\\s]+$")){
            return true;
        }else{
            Toast.makeText(context, "Name cannot contain special character and number", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public static boolean isRoomNumberValid(Context context, @NonNull String roomNumber){
        if (roomNumber.isEmpty()) {
            Toast.makeText(context, "Room Number cannot be blank", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(roomNumber.length()==3) {
            roomNumber = roomNumber.replaceFirst("^0+(?!$)", "");

            try {
                int roomNumberInt = Integer.parseInt(roomNumber);
                if (roomNumberInt >= 1 && roomNumberInt <= 500) {
                        return true;
                } else {
                    Toast.makeText(context, "Room Number must between 001 and 500", Toast.LENGTH_SHORT).show();
                    return false;
                }
            } catch (NumberFormatException e) {
                Toast.makeText(context, "It is not a number", Toast.LENGTH_SHORT).show();
                return false;
            }
        }else {
            Toast.makeText(context, "Invalid Room Format (001-500)", Toast.LENGTH_SHORT).show();
            return false;
        }

    }


}
