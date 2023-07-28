package resources;

import com.google.gson.Gson;
import domain.InventoryDomain;
import services.InventoryServices;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/inventory")
public class Resource {
    public InventoryServices InventoryServices = new InventoryServices();

    public Resource() throws ClassNotFoundException {
    }

    @GET
    @Path("/{InvId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String Fetchid(@PathParam("InvId") int InvId) {
        try {
            return new Gson().toJson(InventoryServices.FetchByID(InvId));
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public String FetchAllInventory() {
        try {
            return new Gson().toJson(InventoryServices.FetchAll());
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }

    @GET
    @Path("/listByCategory")
    @Produces(MediaType.APPLICATION_JSON)
    public String FetchAllByCategory(@QueryParam("category") int category) {
        try {
            return new Gson().toJson(InventoryServices.FetchAllByCategory(category));
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }

    @GET
    @Path("/listByLocation")
    @Produces(MediaType.APPLICATION_JSON)
    public String FetchAllByLocation(@QueryParam("location") int location) {
        try {
            return new Gson().toJson(InventoryServices.FetchAllByLocation(location));
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }

    @GET
    @Path("/listByCategoryAndLocation")
    @Produces(MediaType.APPLICATION_JSON)
    public String FetchAllByCategoryAndLocation(@QueryParam("category") int category, @QueryParam("location") int location) {
        try {
            return new Gson().toJson(InventoryServices.FetchAllByLocationAndCategory(location, category));
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String AddInventory(String payload) {
        try {
            InventoryDomain inventoryDomain = new Gson().fromJson(payload, InventoryDomain.class);
            InventoryServices.AddNewInventoryItem(inventoryDomain);
            return new Gson().toJson(inventoryDomain);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }

    @PUT
    @Path("/{InvId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String UpdateInventory(@PathParam("InvId") int InvId, String payload) {
        try {
            InventoryDomain inventoryDomain = new Gson().fromJson(payload, InventoryDomain.class);
            inventoryDomain.setID(InvId);
            InventoryServices.UpdateExistingInventoryItemByID(inventoryDomain);
            return new Gson().toJson(inventoryDomain);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }

    @DELETE
    @Path("/{InvId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String DeleteInventory(@PathParam("InvId") int InvId) {
        try {
            InventoryServices.DeleteExistingInventoryItemById(InvId);
            return "Deleted";
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }
}
