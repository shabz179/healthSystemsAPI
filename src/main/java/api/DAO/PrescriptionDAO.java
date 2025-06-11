/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api.DAO;
import com.mycompany.healthsystem.Doctor;
import com.mycompany.healthsystem.Patient;
import com.mycompany.healthsystem.Prescription;
import java.util.*;
/**
 *
 * @author shabnoor
 */

public class PrescriptionDAO {
    private static List<Prescription> prescriptions = new ArrayList<>();

    static {
        Doctor doctor1 = new Doctor(0, "Dr. John Doe", "076556789", "25 Baden Road", "Cardiology");
        Doctor doctor2 = new Doctor(1, "Dr. Jane Smith", "0784561230", "4 Elephant Crescent", "Pediatrics");
        Doctor doctor3 = new Doctor(2, "Dr. David Johnson", "0752314562", "234 Pilton Place", "Orthopedics");
        Doctor doctor4 = new Doctor(3, "Dr. Sarah Williams", "0798425167", "1 Hampton Manor", "Dermatology");

        Patient patient1 = new Patient(178840, "Bobby Matthews", 30, "18 Lodge Avenue Place", "0790435577", "Heart failure", "Stable");
        Patient patient2 = new Patient(135353, "Monica Smith", 25, "46 Barking Palace Street", "07857627482", "Eczema", "Stable");
        Patient patient3 = new Patient(177703, "Bradley Smith", 34, "2 Heathway Avenue", "0745678901", "Arthritis", "Stable");
        Patient patient4 = new Patient(147053, "Abdullahi Bukhari", 16, "4 Percy Street", "0798822314", "Acne", "Stable");

        prescriptions.add(new Prescription(135353, "Lycacemilin", "one tablet a day", "Take 1 at night", "4-6 months", "Dr. Williams", patient4.getName()));
        prescriptions.add(new Prescription(177703, "Naproxen", "two to three tablet a day", "Take 1 in the morning and one at night", "2 months", "Dr. Smith", patient3.getName()));
        prescriptions.add(new Prescription(135353, "Cetirizine", "one spoon a day", "Take once a day ", "3 months", "Dr. Johnson", patient3.getName()));
        prescriptions.add(new Prescription(178840, "Benzoyl Peroxide", "apply thinly at night", "use at night ", "4 months", "Dr. Williams", patient4.getName()));
    }

    public static List<Prescription> getAllPrescriptions() {
        return prescriptions;
    }

    public static Prescription getPrescriptionById(int id) {
        for (Prescription prescription : prescriptions) {
            if (prescription.getId() == id) {
                return prescription;
            }
        }
        return null;
    }

    public static void addPrescription(Prescription prescription) {
        prescriptions.add(prescription);
    }

    public static void updatePrescription(Prescription updatedPrescription) {
        for (int i = 0; i < prescriptions.size(); i++) {
            Prescription prescription = prescriptions.get(i);
            if (prescription.getId() == updatedPrescription.getId()) {
                prescriptions.set(i, updatedPrescription);
                System.out.println("Prescription updated: " + updatedPrescription);
                return;
            }
        }
        System.out.println("Prescription not found for updating: " + updatedPrescription);
    }

    public static void deletePrescription(int id) {
        prescriptions.removeIf(prescription -> prescription.getId() == id);
    }

    private static int getNextPrescriptionId() {
        int maxPrescriptionId = Integer.MIN_VALUE;
        for (Prescription prescription : prescriptions) {
            int prescriptionId = prescription.getId();
            if (prescriptionId > maxPrescriptionId) {
                maxPrescriptionId = prescriptionId;
            }
        }
        return maxPrescriptionId + 1;
    }
}
