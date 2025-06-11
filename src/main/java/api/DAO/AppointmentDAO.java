/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api.DAO;
import com.mycompany.healthsystem.Appointment;
import com.mycompany.healthsystem.Doctor;
import com.mycompany.healthsystem.Patient;
import java.util.*;

/**
 *
 * @author shabnoor
 */


public class AppointmentDAO {
    private static List<Appointment> appointments = new ArrayList<>();

    static {
        PatientDAO patientDAO = new PatientDAO();
        List<Patient> patients = patientDAO.getAllPatients();

        DoctorDAO doctorDAO = new DoctorDAO();
        List<Doctor> doctors = doctorDAO.getAllDoctors();

        appointments.add(new Appointment(402, "2024-03-26", "10:45", patientDAO.getPatientById(178840), doctorDAO.getDoctorById(0)));
        appointments.add(new Appointment(393, "2024-04-02", "15:30", patientDAO.getPatientById(135353), doctorDAO.getDoctorById(1)));
        appointments.add(new Appointment(173, "2024-04-10", "09:15", patientDAO.getPatientById(177703), doctorDAO.getDoctorById(2)));
        appointments.add(new Appointment(295, "2024-04-10", "10:00", patientDAO.getPatientById(147053), doctorDAO.getDoctorById(3)));
    }

    public List<Appointment> getAllAppointments() {
        return appointments;
    }

    public Appointment getAppointmentById(int id) {
        for (Appointment appointment : appointments) {
            if (appointment.getId() == id) {
                return appointment;
            }
        }
        return null;
    }

    public void addAppointment(Appointment appointment) {
        int newId = getNextAppointmentId();
        appointment.setId(newId);
        appointments.add(appointment);
    }

    public void updateAppointment(Appointment updatedAppointment) {
        for (int i = 0; i < appointments.size(); i++) {
            Appointment existingAppointment = appointments.get(i);
            if (existingAppointment.getId() == updatedAppointment.getId()) {
                appointments.set(i, updatedAppointment);
                System.out.println("Appointment updated: " + updatedAppointment);
                return;
            }
        }
        System.out.println("Appointment not found for updating: " + updatedAppointment);
    }

    public void deleteAppointment(int id) {
        appointments.removeIf(appointment -> appointment.getId() == id);
    }

    private int getNextAppointmentId() {
        int maxAppointmentId = Integer.MIN_VALUE;
        for (Appointment appointment : appointments) {
            int appointmentId = appointment.getId();
            if (appointmentId > maxAppointmentId) {
                maxAppointmentId = appointmentId;
            }
        }
        return maxAppointmentId + 1;
    }
}

