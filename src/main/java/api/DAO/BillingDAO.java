/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api.DAO;
import java.util.*;
import com.mycompany.healthsystem.Billing;
import com.mycompany.healthsystem.Patient;
/**
 *
 * @author shabnoor
 */

public class BillingDAO {
    private static List<Billing> billings = new ArrayList<>();

    static {
           Patient patient1 = new Patient(178840, "Bobby Matthews", 30, "18 Lodge Avenue Place", "0790435577", "Heart failure", "Stable");
        Patient patient2 = new Patient(135353, "Monica Smith", 25, "46 Barking Palace Street", "07857627482", "Eczema", "Stable");
        Patient patient3 = new Patient(177703, "Bradley Smith", 34, "2 Heathway Avenue", "0745678901", "Arthritis", "Stable");
        Patient patient4 = new Patient(147053, "Abdullahi Bukhari", 16, "4 Percy Street", "0798822314", "Acne", "Stable");

        Billing billing1 = new Billing(patient1, 500.0, 500.0, 0.0, "Paid", "Dr. Jones");
        Billing billing2 = new Billing(patient2, 750.0, 0.0, 750.0, "Pending", "Dr. Smith");
        Billing billing3 = new Billing(patient3, 600.0, 550.0, 50.0, "Partial", "Dr. Adams");
        Billing billing4 = new Billing(patient4, 0.0, 0.0, 0.0, "Paid", "Dr. White");

        billing1.setId(1);
        billing2.setId(2);
        billing3.setId(3);
        billing4.setId(4);

        billings.add(billing1);
        billings.add(billing2);
        billings.add(billing3);
        billings.add(billing4);
    }

    public List<Billing> getAllBillings() {
        return new ArrayList<>(billings);
    }

    public Billing getBillingById(int id) {
        for (Billing billing : billings) {
            if (billing.getId() == id) {
                return billing;
            }
        }
        return null;
    }

    public void addBilling(Billing billing) {
        int newBillingId = getNextBillingId();
        billing.setId(newBillingId);
        billings.add(billing);
    }

    public void updateBilling(Billing updatedBilling) {
        for (int i = 0; i < billings.size(); i++) {
            Billing existingBilling = billings.get(i);
            if (existingBilling.getId() == updatedBilling.getId()) {
                billings.set(i, updatedBilling);
                System.out.println("Billing updated: " + updatedBilling);
                return;
            }
        }
        System.out.println("Billing not found for updating: " + updatedBilling);
    }

    public void deleteBilling(int id) {
        billings.removeIf(billing -> billing.getId() == id);
    }

    private int getNextBillingId() {
        int maxBillingId = Integer.MIN_VALUE;
        for (Billing billing : billings) {
            int billingId = billing.getPatient().getId();
            if (billingId > maxBillingId) {
                maxBillingId = billingId;
            }
        }
        return maxBillingId + 1;
    }
}

