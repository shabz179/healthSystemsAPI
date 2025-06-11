/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api.Resource;

import api.DAO.AppointmentDAO;
import com.mycompany.healthsystem.Appointment;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author shabnoor
 */
@Path("/appointments")
public class AppointmentResource {

    private AppointmentDAO appointmentDAO = new AppointmentDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Appointment> getAllAppointments() {
        return appointmentDAO.getAllAppointments();
    }

    @GET
    @Path("/{appointmentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Appointment getAppointmentById(@PathParam("appointmentId") int appointmentId) {
        return appointmentDAO.getAppointmentById(appointmentId);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addAppointment(Appointment appointment) {
        appointmentDAO.addAppointment(appointment);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{appointmentId}")
    public void updateAppointment(@PathParam("appointmentId") int appointmentId, Appointment updatedAppointment) {
        Appointment existingAppointment = appointmentDAO.getAppointmentById(appointmentId);

        if (existingAppointment != null) {
            updatedAppointment.setId(appointmentId);
            appointmentDAO.updateAppointment(updatedAppointment);
        }
    }

    @DELETE
    @Path("/{appointmentId}")
    public void deleteAppointment(@PathParam("appointmentId") int appointmentId) {
        appointmentDAO.deleteAppointment(appointmentId);
    }
}
