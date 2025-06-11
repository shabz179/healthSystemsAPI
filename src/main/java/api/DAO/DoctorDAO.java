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


public class DoctorDAO {
    private static List<Doctor> doctors = new ArrayList<>();

    static {
        Doctor doctor1 = new Doctor(0, "Dr. John Doe", "076556789", "25 Baden Road", "Cardiology");
        Doctor doctor2 = new Doctor(1, "Dr. Jane Smith", "0784561230", "4 Elephant Crescent", "Pediatrics");
        Doctor doctor3 = new Doctor(2, "Dr. David Johnson", "0752314562", "234 Pilton Place", "Orthopedics");
        Doctor doctor4 = new Doctor(3, "Dr. Sarah Williams", "0798425167", "1 Hampton Manor", "Dermatology");

        Patient patient1 = new Patient(178840, "Bobby Matthews", 30, "18 Lodge Avenue Place", "0790435577", "Heart failure", "Stable");
        Patient patient2 = new Patient(135353, "Monica Smith", 25, "46 Barking Palace Street", "07857627482", "Eczema", "Stable");
        Patient patient3 = new Patient(177703, "Bradley Smith", 34, "2 Heathway Avenue", "0745678901", "Arthritis", "Stable");
        Patient patient4 = new Patient(135354, "Abdullahi Bukhari", 16, "4 Percy Street", "0798822314", "Acne", "Stable");

        doctor1.addPatient(patient1);
        doctor2.addPatient(patient2);
        doctor3.addPatient(patient3);
        doctor4.addPatient(patient4);

        doctors.add(doctor1);
        doctors.add(doctor2);
        doctors.add(doctor3);
        doctors.add(doctor4);
    }

    public static List<Doctor> getAllDoctors() {
        return doctors;
    }

    public static Doctor getDoctorById(int id) {
        for (Doctor doctor : doctors) {
            if (doctor.getId() == id) {
                return doctor;
            }
        }
        return null;
    }

    public static void addDoctor(Doctor doctor) {
        int newDoctorId = getNextDoctorId();
        doctor.setId(newDoctorId);
        doctors.add(doctor);
    }

    public static void updateDoctor(Doctor updatedDoctor) {
        for (int i = 0; i < doctors.size(); i++) {
            Doctor existingDoctor = doctors.get(i);
            if (existingDoctor.getId() == updatedDoctor.getId()) {
                doctors.set(i, updatedDoctor);
                System.out.println("Doctor updated: " + updatedDoctor);
                return;
            }
        }
        System.out.println("Doctor not found for updating: " + updatedDoctor);
    }

    public static void deleteDoctor(int id) {
        doctors.removeIf(doctor -> doctor.getId() == id);
    }

    private static int getNextDoctorId() {
        int maxDoctorId = Integer.MIN_VALUE;
        for (Doctor doctor : doctors) {
            int doctorId = doctor.getId();
            if (doctorId > maxDoctorId) {
                maxDoctorId = doctorId;
            }
        }
        return maxDoctorId + 1;
    }
}
