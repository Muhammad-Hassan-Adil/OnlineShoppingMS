package resources;
//import domain.ItemCategoryDomain;
//import domain.ItemLocationDomain;
//import domain.InventoryDomain;
import services.InventoryServices;
import com.google.gson.Gson;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
@Path("/inventory")
public class Resource {
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
}
