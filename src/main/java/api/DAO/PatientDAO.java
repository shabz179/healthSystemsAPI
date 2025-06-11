/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api.DAO;
import com.mycompany.healthsystem.Doctor;
import com.mycompany.healthsystem.Patient;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author shabnoor
 */

public class PatientDAO {
    private static List<Patient> patients = new ArrayList<>();

    static {
    Doctor doctor1 = new Doctor(0,"Dr. John Doe","076556789","25 Baden Road","Cardiology");
    Doctor doctor2 = new Doctor(1,"Dr. Jane Smith","0784561230","4 Elephant Crescent","Pediatrics");
    Doctor doctor3 = new Doctor(2,"Dr. David Johnson","0752314562","234 Pilton Place", "Orthopedics");
    Doctor doctor4 = new Doctor(3,"Dr. Sarah Williams","0798425167","1 Hampton Manor", "Dermatology");

    Patient patient1 = new Patient(178840, "Bobby Matthews", 30, "18 Lodge Avenue Place", "0790435577", "Heart failure", "Stable");
    Patient patient2 = new Patient(135353, "Monica Smith", 25, "46 Barking Palace Street", "07857627482", "Eczema", "Stable");
    Patient patient3 = new Patient(177703, "Bradley Smith", 34,  "2 Heathway Avenue", "0745678901", "Arthritis", "Stable");
    Patient patient4 = new Patient(147053, "Abdullahi Bukhari", 16, "4 Percy Street", "0798822314", "Acne", "Stable");

    patient1.setDoctor(doctor1);
    patient2.setDoctor(doctor2);
    patient3.setDoctor(doctor3);
    patient4.setDoctor(doctor4);

    patients.add(patient1);
    patients.add(patient2);
    patients.add(patient3);
    patients.add(patient4);
    
    }

    public static List<Patient> getAllPatients() {
        return patients;
    }

    public static Patient getPatientById(int id) {
        for (Patient patient : patients) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        return null;
    }

    public void addPatient(Patient patient) {
        int newUserId = getNextUserId();
        patient.setId(newUserId);
        patients.add(patient);
    }


    public static void updatePatient(Patient updatedPatient) {
        for (int i = 0; i < patients.size(); i++) {
            Patient existingPatient = patients.get(i);
            if (existingPatient.getId() == updatedPatient.getId()) {
                patients.set(i, updatedPatient);
                System.out.println("Patient updated: " + updatedPatient);
                return;
            }
        }
        System.out.println("Patient not found for updating: " + updatedPatient);
    }

    public static void deletePatient(int id) {
        patients.removeIf(patient -> patient.getId() == id);
    }

    private static int getNextUserId() {
        int maxUserId = Integer.MIN_VALUE;
        for (Patient patient : patients) {
            int userId = patient.getId();
            if (userId > maxUserId) {
                maxUserId = userId;
            }
        }
        return maxUserId + 1;
    }
}







