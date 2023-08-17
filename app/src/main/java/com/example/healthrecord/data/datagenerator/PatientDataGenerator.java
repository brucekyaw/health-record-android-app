//package com.example.healthrecord.data.datagenerator;
//
//import com.example.healthrecord.data.vo.PatientDetailVO;
//import com.example.healthrecord.data.vo.PatientVO;
//
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.LinkedHashMap;
//import java.util.List;
//
//public class PatientDataGenerator {
//    private static List<PatientVO> patientList = new ArrayList<>();
//
//    private static boolean isDataGenerated = false;
//    public static List<PatientVO> generatePatientData(){
//            if (!isDataGenerated) {
////
////        MedicalRecordVO medicalRecord1 = new MedicalRecordVO(1099, getDate(-20), "Male", "Graduate", "No", 0, "not currently used", "free", "No", "No", 160.5, 120.0, 80, 23.5, 75, 90, "No");
////
////        MedicalRecordVO medicalRecord2 = new MedicalRecordVO(2099, getDate(-26), "Female", "Undergraduate", "Yes", 10, "currently used", "prevalent disease", "Yes", "No", 180.2, 130.0, 85, 25.0, 80, 95, "Yes");
////
////        MedicalRecordVO medicalRecord3 = new MedicalRecordVO(3099, getDate(-28), "Male", "High School", "No", 0, "not currently used", "free", "No", "Yes", 185.0, 140.0, 90, 21.7, 70, 100, "No");
////
////        MedicalRecordVO medicalRecord4 = new MedicalRecordVO(4099, getDate(-23), "Female", "Graduate", "No", 0, "not currently used", "free", "Yes", "No", 170.0, 110.0, 75, 24.8, 78, 88, "No");
////
////        MedicalRecordVO medicalRecord5 = new MedicalRecordVO(5099, getDate(-22), "Male", "Undergraduate", "Yes", 5, "currently used", "prevalent disease", "No", "Yes", 200.5, 150.0, 95, 22.3, 72, 98, "Yes");
////
////        MedicalRecordVO medicalRecord6 = new MedicalRecordVO(6099, getDate(-40), "Female", "High School", "Yes", 8, "currently used", "prevalent disease", "Yes", "No", 175.0, 125.0, 80, 26.5, 85, 92, "Yes");
////
////        MedicalRecordVO medicalRecord7 = new MedicalRecordVO(7099, getDate(-42), "Male", "Graduate", "No", 0, "not currently used", "free", "Yes", "Yes", 190.5, 135.0, 88, 23.0, 78, 96, "Yes");
////
////        MedicalRecordVO medicalRecord8 = new MedicalRecordVO(8099, getDate(-65), "Female", "Undergraduate", "Yes", 12, "currently used", "prevalent disease", "No", "No", 185.0, 140.0, 90, 27.8, 76, 98, "No");
////
////        MedicalRecordVO medicalRecord9 = new MedicalRecordVO(9099, getDate(-10), "Male", "Graduate", "No", 0, "not currently used", "free", "No", "No", 170.0, 120.0, 78, 25.2, 80, 85, "No");
////
////        MedicalRecordVO medicalRecord10 = new MedicalRecordVO(10099, getDate(-46), "Female", "High School", "No", 0, "not currently used", "free", "No", "Yes", 195.5, 150.0, 95, 28.1, 72, 100, "No");
//
//            LinkedHashMap<String, String> medicalRecord1 = new LinkedHashMap<>();
//            medicalRecord1.put("currentSmoker", "Yes");
//            medicalRecord1.put("cigsPerDay", "10");
//            medicalRecord1.put("bpMEDS", "Used");
//            medicalRecord1.put("prevalentStoke", "Free");
//            medicalRecord1.put("prevalentHyp", "No");
//            medicalRecord1.put("diabetes", "No");
//            medicalRecord1.put("totChol", "180");
//            medicalRecord1.put("sysBP", "120");
//            medicalRecord1.put("diaBP", "80");
//            medicalRecord1.put("weight", "24.5kg");
//            medicalRecord1.put("height", "145.2cm");
//            medicalRecord1.put("heartRate", "75");
//            medicalRecord1.put("bloodType", "A");
//            medicalRecord1.put("allgeries", "NO");
//            medicalRecord1.put("HIV", "YES");
//            medicalRecord1.put("glucose", "90");
//
//            LinkedHashMap<String, String> medicalRecord2 = new LinkedHashMap<>();
//            medicalRecord2.put("currentSmoker", "No");
//            medicalRecord2.put("cigsPerDay", "0");
//            medicalRecord2.put("bpMEDS", "Not Used");
//            medicalRecord2.put("prevalentStoke", "Free");
//            medicalRecord2.put("prevalentHyp", "Yes");
//            medicalRecord2.put("diabetes", "Yes");
//            medicalRecord2.put("totChol", "210");
//            medicalRecord2.put("sysBP", "140");
//            medicalRecord2.put("diaBP", "90");
//            medicalRecord2.put("bmi", "29.8");
//            medicalRecord2.put("heartRate", "80");
//            medicalRecord2.put("glucose", "130");
//
//            LinkedHashMap<String, String> medicalRecord3 = new LinkedHashMap<>();
//            medicalRecord3.put("currentSmoker", "No");
//            medicalRecord3.put("cigsPerDay", "0");
//            medicalRecord3.put("bpMEDS", "Not Used");
//            medicalRecord3.put("prevalentStoke", "Free");
//            medicalRecord3.put("prevalentHyp", "No");
//            medicalRecord3.put("diabetes", "No");
//            medicalRecord3.put("totChol", "190");
//            medicalRecord3.put("sysBP", "115");
//            medicalRecord3.put("diaBP", "70");
//            medicalRecord3.put("bmi", "21.8");
//            medicalRecord3.put("heartRate", "72");
//            medicalRecord3.put("glucose", "80");
//
//            LinkedHashMap<String, String> medicalRecord4 = new LinkedHashMap<>();
//            medicalRecord4.put("currentSmoker", "Yes");
//            medicalRecord4.put("cigsPerDay", "15");
//            medicalRecord4.put("bpMEDS", "Used");
//            medicalRecord4.put("prevalentStoke", "Free");
//            medicalRecord4.put("prevalentHyp", "Yes");
//            medicalRecord4.put("diabetes", "Yes");
//            medicalRecord4.put("totChol", "250");
//            medicalRecord4.put("sysBP", "160");
//            medicalRecord4.put("diaBP", "100");
//            medicalRecord4.put("bmi", "35.2");
//            medicalRecord4.put("heartRate", "88");
//            medicalRecord4.put("glucose", "180");
//
//            LinkedHashMap<String, String> medicalRecord5 = new LinkedHashMap<>();
//            medicalRecord5.put("currentSmoker", "Yes");
//            medicalRecord5.put("cigsPerDay", "5");
//            medicalRecord5.put("bpMEDS", "Used");
//            medicalRecord5.put("prevalentStoke", "Free");
//            medicalRecord5.put("prevalentHyp", "Yes");
//            medicalRecord5.put("diabetes", "No");
//            medicalRecord5.put("totChol", "220");
//            medicalRecord5.put("sysBP", "140");
//            medicalRecord5.put("diaBP", "90");
//            medicalRecord5.put("bmi", "28.3");
//            medicalRecord5.put("heartRate", "76");
//            medicalRecord5.put("glucose", "100");
//
//            LinkedHashMap<String, String> medicalRecord6 = new LinkedHashMap<>();
//            medicalRecord6.put("currentSmoker", "No");
//            medicalRecord6.put("cigsPerDay", "0");
//            medicalRecord6.put("bpMEDS", "Not Used");
//            medicalRecord6.put("prevalentStoke", "Free");
//            medicalRecord6.put("prevalentHyp", "No");
//            medicalRecord6.put("diabetes", "No");
//            medicalRecord6.put("totChol", "190");
//            medicalRecord6.put("sysBP", "120");
//            medicalRecord6.put("diaBP", "80");
//            medicalRecord6.put("bmi", "22.1");
//            medicalRecord6.put("heartRate", "70");
//            medicalRecord6.put("glucose", "85");
//
//            LinkedHashMap<String, String> medicalRecord7 = new LinkedHashMap<>();
//            medicalRecord7.put("currentSmoker", "Yes");
//            medicalRecord7.put("cigsPerDay", "10");
//            medicalRecord7.put("bpMEDS", "Used");
//            medicalRecord7.put("prevalentStoke", "Free");
//            medicalRecord7.put("prevalentHyp", "Yes");
//            medicalRecord7.put("diabetes", "Yes");
//            medicalRecord7.put("totChol", "230");
//            medicalRecord7.put("sysBP", "150");
//            medicalRecord7.put("diaBP", "95");
//            medicalRecord7.put("bmi", "30.5");
//            medicalRecord7.put("heartRate", "95");
//            medicalRecord7.put("glucose", "170");
//
//            LinkedHashMap<String, String> medicalRecord8 = new LinkedHashMap<>();
//            medicalRecord8.put("currentSmoker", "No");
//            medicalRecord8.put("cigsPerDay", "0");
//            medicalRecord8.put("bpMEDS", "Not Used");
//            medicalRecord8.put("prevalentStoke", "Free");
//            medicalRecord8.put("prevalentHyp", "No");
//            medicalRecord8.put("diabetes", "Yes");
//            medicalRecord8.put("totChol", "200");
//            medicalRecord8.put("sysBP", "130");
//            medicalRecord8.put("diaBP", "85");
//            medicalRecord8.put("bmi", "25.9");
//            medicalRecord8.put("heartRate", "80");
//            medicalRecord8.put("glucose", "110");
//
//            LinkedHashMap<String, String> medicalRecord9 = new LinkedHashMap<>();
//            medicalRecord9.put("currentSmoker", "No");
//            medicalRecord9.put("cigsPerDay", "0");
//            medicalRecord9.put("bpMEDS", "Not Used");
//            medicalRecord9.put("prevalentStoke", "Free");
//            medicalRecord9.put("prevalentHyp", "No");
//            medicalRecord9.put("diabetes", "No");
//            medicalRecord9.put("totChol", "170");
//            medicalRecord9.put("sysBP", "118");
//            medicalRecord9.put("bloodType", "O");
//            medicalRecord9.put("diaBP", "72");
//            medicalRecord9.put("bmi", "23.4");
//            medicalRecord9.put("heartRate", "68");
//            medicalRecord9.put("glucose", "75");
//
//            LinkedHashMap<String, String> medicalRecord10 = new LinkedHashMap<>();
//            medicalRecord10.put("currentSmoker", "Yes");
//            medicalRecord10.put("cigsPerDay", "20");
//            medicalRecord10.put("bpMEDS", "Used");
//            medicalRecord10.put("prevalentStoke", "Free");
//            medicalRecord10.put("prevalentHyp", "Yes");
//            medicalRecord10.put("diabetes", "No");
//            medicalRecord10.put("totChol", "240");
//            medicalRecord10.put("sysBP", "155");
//            medicalRecord10.put("diaBP", "100");
//            medicalRecord10.put("bmi", "32.1");
//            medicalRecord10.put("heartRate", "90");
//            medicalRecord10.put("glucose", "120");
//
//            PatientDetailVO patientDetail1 = new PatientDetailVO(1, getDate(-23), "Male", "Bachelor's Degree", medicalRecord1, "YES");
//            PatientVO patient1 = new PatientVO(1, "John Doe", "123 Main Street", "101", "profile_image_1.jpg", true, patientDetail1);
//
//            PatientDetailVO patientDetail2 = new PatientDetailVO(2, getDate(-53), "Female", "High School Diploma", medicalRecord2, "NO");
//            PatientVO patient2 = new PatientVO(2, "Katy Smith", "456 Elm Avenue", "102", "profile_image_2.jpg", false, patientDetail2);
//
//            PatientDetailVO patientDetail3 = new PatientDetailVO(3, getDate(-26), "Male", "Master's Degree", medicalRecord3,"YES");
//            PatientVO patient3 = new PatientVO(3, "Michael Johnson", "789 Oak Road", "103", "profile_image_3.jpg", true, patientDetail3);
//
//            PatientDetailVO patientDetail4 = new PatientDetailVO(4, getDate(-64), "Female", "Doctorate Degree", medicalRecord4,"NO");
//            PatientVO patient4 = new PatientVO(4, "Emily Williams", "111 Pine Lane", "104", "profile_image_4.jpg", false, patientDetail4);
//
//            PatientDetailVO patientDetail5 = new PatientDetailVO(5, getDate(-33), "Male", "High School Diploma", medicalRecord5,"YES");
//            PatientVO patient5 = new PatientVO(5, "David Brown", "222 Maple Drive", "105", "profile_image_5.jpg", true, patientDetail5);
//
//            PatientDetailVO patientDetail6 = new PatientDetailVO(6, getDate(-12), "Female", "Bachelor's Degree", medicalRecord6,"YES");
//            PatientVO patient6 = new PatientVO(6, "Sophie Turner", "444 Cedar Street", "106", "profile_image_6.jpg", true, patientDetail6);
//
//            PatientDetailVO patientDetail7 = new PatientDetailVO(7, getDate(-2), "Male", "Associate Degree", medicalRecord7,"NO");
//            PatientVO patient7 = new PatientVO(7, "James Johnson", "555 Birch Boulevard", "107", "profile_image_7.jpg", false, patientDetail7);
//
//            PatientDetailVO patientDetail8 = new PatientDetailVO(8, getDate(-73), "Female", "Master's Degree", medicalRecord8,"YES");
//            PatientVO patient8 = new PatientVO(8, "Emma Wilson", "666 Willow Way", "108", "profile_image_8.jpg", true, patientDetail8);
//
//            PatientDetailVO patientDetail9 = new PatientDetailVO(9, getDate(-37), "Male", "High School Diploma", medicalRecord9,"NO");
//            PatientVO patient9 = new PatientVO(9, "Benjamin Smith", "777 Oak Road", "109", "profile_image_9.jpg", false, patientDetail9);
//
//            PatientDetailVO patientDetail10 = new PatientDetailVO(10, getDate(-15), "Female", "Bachelor's Degree", medicalRecord10,"YES");
//            PatientVO patient10 = new PatientVO(10, "Isabella Lee", "888 Elm Avenue", "110", "profile_image_10.jpg", true, patientDetail10);
//
//            patientList.add(patient1);
//            patientList.add(patient2);
//            patientList.add(patient3);
//            patientList.add(patient4);
//            patientList.add(patient5);
//            patientList.add(patient6);
//            patientList.add(patient7);
//            patientList.add(patient8);
//            patientList.add(patient9);
//            patientList.add(patient10);
//
//            isDataGenerated = true;
//            }
//
//
//            return patientList;
//    }
//
//    public static PatientVO findPatientById(int id){
//        for(PatientVO patient : patientList)
//        {
//           if(patient.getPatientID() == id)return patient;
//        }
//            return null;
//    }
//        private static Date getDate(int daysAgo) {
//        Calendar cal = Calendar.getInstance();
//        cal.add(Calendar.DAY_OF_MONTH, daysAgo);
//        return cal.getTime();
//    }
//
//
//}
