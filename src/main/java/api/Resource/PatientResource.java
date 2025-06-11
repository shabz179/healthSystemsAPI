/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import api.DAO.PatientDAO;
import com.mycompany.healthsystem.Patient;
import java.util.List;

/**
 *
 * @author shabnoor
 */

@Path("/patients")
public class PatientResource {

    private PatientDAO patientdao = new PatientDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Patient> getAllPatients() {
        return patientdao.getAllPatients();
    }

    @GET
    @Path("/{patientId}") 
    @Produces(MediaType.APPLICATION_JSON)
    public Patient getPatientById(@PathParam("patientId") int patientId) { 
        return patientdao.getPatientById(patientId); 
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addPatient(Patient patient) {
        patientdao.addPatient(patient);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{patientId}") 
    public void updatePatient(@PathParam("patientId") int patientId, Patient updatedPatient) {
        Patient existingPatient = patientdao.getPatientById(patientId);

        if (existingPatient != null) {
            updatedPatient.setId(patientId);
            patientdao.updatePatient(updatedPatient);
        }
    }

    @DELETE
    @Path("/{patientId}") 
    public void deletePatient(@PathParam("patientId") int patientId) { 
        patientdao.deletePatient(patientId); 
    }
}
