/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api.Resource;
import api.DAO.DoctorDAO;
import com.mycompany.healthsystem.Doctor;
import javax.ws.rs.Path;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 *
 * @author shabnoor
 */

@Path("/doctors")
public class DoctorResource {

    private DoctorDAO doctorDAO = new DoctorDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Doctor> getAllDoctors() {
        return doctorDAO.getAllDoctors();
    }

    @GET
    @Path("/{doctorId}") 
    @Produces(MediaType.APPLICATION_JSON)
    public Doctor getDoctorById(@PathParam("doctorId") int doctorId) { 
        return doctorDAO.getDoctorById(doctorId); 
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addDoctor(Doctor doctor) {
        doctorDAO.addDoctor(doctor);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{doctorId}") 
    public void updateDoctor(@PathParam("doctorId") int doctorId, Doctor updatedDoctor) {
        Doctor existingDoctor = doctorDAO.getDoctorById(doctorId);

        if (existingDoctor != null) {
            updatedDoctor.setId(doctorId);
            doctorDAO.updateDoctor(updatedDoctor);
        }
    }

    @DELETE
    @Path("/{doctorId}") 
    public void deleteDoctor(@PathParam("doctorId") int doctorId) { 
        doctorDAO.deleteDoctor(doctorId); 
    }
}
