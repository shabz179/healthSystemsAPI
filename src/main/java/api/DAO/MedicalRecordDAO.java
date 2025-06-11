/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api.DAO;
import com.mycompany.healthsystem.MedicalRecord;
import com.mycompany.healthsystem.Patient;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author shabnoor
 */

public class MedicalRecordDAO {
    private static List<MedicalRecord> medicalRecords = new ArrayList<>();

    static {
        Patient patient1 = new Patient(135354, "Abdullahi Bukhari", 16, "4 Percy Street", "0798822314", "Acne", "Stable");
        Patient patient2 = new Patient(133472, "Monica Smith", 25, "46 Barking Palace Street", "07857627482", "Broken leg", "Stable");
        Patient patient3 = new Patient(177703, "Bradley Smith", 34, "2 Heathway Avenue", "0745678901", "Migraine", "Stable");
        Patient patient4 = new Patient(178840, "Bobby Matthews", 30, "18 Lodge Avenue Place", "0790435577", "Concussion", "Stable");

        medicalRecords.add(new MedicalRecord(1, patient1, "Fever", "Rest and medication"));
        medicalRecords.add(new MedicalRecord(2, patient2, "Broken leg", "Surgery and cast"));
        medicalRecords.add(new MedicalRecord(3, patient3, "Migraine", "Painkillers and rest"));
        medicalRecords.add(new MedicalRecord(4, patient4, "Concussion", "Rest and monitoring"));
        medicalRecords.add(new MedicalRecord(5, patient2, "Allergic reaction", "Epinephrine and antihistamines"));
    }

    public List<MedicalRecord> getAllMedicalRecords() {
        return medicalRecords;
    }

    public MedicalRecord getMedicalRecordById(int id) {
        for (MedicalRecord medicalRecord : medicalRecords) {
            if (medicalRecord.getId() == id) {
                return medicalRecord;
            }
        }
        return null;
    }

    public void addMedicalRecord(MedicalRecord medicalRecord) {
        int newId = getNextMedicalRecordId();
        medicalRecord.setId(newId);
        medicalRecords.add(medicalRecord);
    }

    public void updateMedicalRecord(MedicalRecord updatedMedicalRecord) {
        for (int i = 0; i < medicalRecords.size(); i++) {
            MedicalRecord existingMedicalRecord = medicalRecords.get(i);
            if (existingMedicalRecord.getId() == updatedMedicalRecord.getId()) {
                medicalRecords.set(i, updatedMedicalRecord);
                System.out.println("Medical record updated: " + updatedMedicalRecord);
                return;
            }
        }
        System.out.println("Medical record not found for updating: " + updatedMedicalRecord);
    }

    public void deleteMedicalRecord(int id) {
        medicalRecords.removeIf(medicalRecord -> medicalRecord.getId() == id);
    }

    private static int getNextMedicalRecordId() {
        int maxMedicalRecordId = Integer.MIN_VALUE;
        for (MedicalRecord medicalRecord : medicalRecords) {
            int medicalRecordId = medicalRecord.getId();
            if (medicalRecordId > maxMedicalRecordId) {
                maxMedicalRecordId = medicalRecordId;
            }
        }
        return maxMedicalRecordId + 1;
    }
}



