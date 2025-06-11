/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api.Resource;
import api.DAO.PrescriptionDAO;
import com.mycompany.healthsystem.Doctor;
import com.mycompany.healthsystem.Patient;
import com.mycompany.healthsystem.Prescription;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 *
 * @author shabnoor
 */


@Path("/prescriptions")
public class PrescriptionResource {

    private PrescriptionDAO prescriptionDAO = new PrescriptionDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Prescription> getAllPrescriptions() {
        return prescriptionDAO.getAllPrescriptions();
    }

    @GET
    @Path("/{prescriptionId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Prescription getPrescriptionById(@PathParam("prescriptionId") int prescriptionId) {
        return prescriptionDAO.getPrescriptionById(prescriptionId);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addPrescription(Prescription prescription) {
        prescriptionDAO.addPrescription(prescription);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{prescriptionId}")
    public void updatePrescription(@PathParam("prescriptionId") int prescriptionId, Prescription updatedPrescription) {
        Prescription existingPrescription = prescriptionDAO.getPrescriptionById(prescriptionId);

        if (existingPrescription != null) {
            updatedPrescription.setId(prescriptionId);
            prescriptionDAO.updatePrescription(updatedPrescription);
        }
    }

    @DELETE
    @Path("/{prescriptionId}")
    public void deletePrescription(@PathParam("prescriptionId") int prescriptionId) {
        prescriptionDAO.deletePrescription(prescriptionId);
    }
}

