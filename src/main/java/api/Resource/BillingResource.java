/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api.Resource;
import api.DAO.BillingDAO;
import com.mycompany.healthsystem.Billing;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 *
 * @author shabnoor
 */

@Path("/billings")
public class BillingResource {

    private BillingDAO billingDAO = new BillingDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Billing> getAllBillings() {
        return billingDAO.getAllBillings();
    }

    @GET
    @Path("/{billingId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Billing getBillingById(@PathParam("billingId") int billingId) {
        return billingDAO.getBillingById(billingId);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addBilling(Billing billing) {
        billingDAO.addBilling(billing);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{billingId}")
    public void updateBilling(@PathParam("billingId") int billingId, Billing updatedBilling) {
        Billing existingBilling = billingDAO.getBillingById(billingId);

        if (existingBilling != null) {
            updatedBilling.setId(billingId);
            billingDAO.updateBilling(updatedBilling);
        }
    }

    @DELETE
    @Path("/{billingId}")
    public void deleteBilling(@PathParam("billingId") int billingId) {
        billingDAO.deleteBilling(billingId);
    }
}