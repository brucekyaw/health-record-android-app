package com.example.healthrecord.networks;

public interface ClinicDataAgent {

    void loadPatient();
    void loadNurse(String emailId, String password);
    void loadPatientRecord(String id);
    void postPatient(String patientName, String roomNumber);
    void loadPatientResult(String patientId);

}
