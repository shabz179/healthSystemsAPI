/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api.Resource;
import api.DAO.MedicalRecordDAO;
import com.mycompany.healthsystem.MedicalRecord;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
/**
 *
 * @author shabnoor
 */

@Path("/medicalRecords")
public class MedicalRecordResource {

    private MedicalRecordDAO medicalRecordDAO = new MedicalRecordDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<MedicalRecord> getAllMedicalRecords() {
        return medicalRecordDAO.getAllMedicalRecords();
    }

    @GET
    @Path("/{medicalRecordId}")
    @Produces(MediaType.APPLICATION_JSON)
    public MedicalRecord getMedicalRecordById(@PathParam("medicalRecordId") int medicalRecordId) {
        return medicalRecordDAO.getMedicalRecordById(medicalRecordId);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecordDAO.addMedicalRecord(medicalRecord);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{medicalRecordId}")
    public void updateMedicalRecord(@PathParam("medicalRecordId") int medicalRecordId, MedicalRecord updatedMedicalRecord) {
        MedicalRecord existingMedicalRecord = medicalRecordDAO.getMedicalRecordById(medicalRecordId);

        if (existingMedicalRecord != null) {
            updatedMedicalRecord.setId(medicalRecordId);
            medicalRecordDAO.updateMedicalRecord(updatedMedicalRecord);
        }
    }

    @DELETE
    @Path("/{medicalRecordId}")
    public void deleteMedicalRecord(@PathParam("medicalRecordId") int medicalRecordId) {
        medicalRecordDAO.deleteMedicalRecord(medicalRecordId);
    }
}
