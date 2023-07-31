package resources;
import com.google.gson.Gson;
import domain.Inventory;
import org.apache.logging.log4j.ThreadContext;
import services.InventoryServices;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.apache.logging.log4j.*;

@Path("/inventory")
public class MainResource {
    public InventoryServices InventoryServices = new InventoryServices();
    private static final Logger logger = LogManager.getLogger(MainResource.class.getName());

    public MainResource() {
    }

    @GET
    @Path("/{InvId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String Fetchid(@PathParam("InvId") int InvId) {
        ThreadContext.put("httpMethod", "GET");
        try {
            String inventory = new Gson().toJson(InventoryServices.FetchByID(InvId));
            logger.info("Inventory Retrieved by ID");
            return inventory;
        } catch (Exception exc) {
            exc.printStackTrace();
            return null;
        }
        finally {
            ThreadContext.remove("httpMethod");
        }

    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public String FetchAllInventory() {
        ThreadContext.put("httpMethod", "GET");
        try {
            String inventory = new Gson().toJson(InventoryServices.FetchAll());
            logger.info("All Inventory Retrieved");
            return inventory;
        } catch (Exception exc) {
            exc.printStackTrace();
            return null;
        }
        finally {
            ThreadContext.remove("httpMethod");
        }
    }

    @GET
    @Path("/listByCategory")
    @Produces(MediaType.APPLICATION_JSON)
    public String FetchAllByCategory(@QueryParam("category") int category) {
        ThreadContext.put("httpMethod", "GET");
        try {
            String inventory = new Gson().toJson(InventoryServices.FetchAllByCategory(category));
            logger.info("Inventory Retrieved by Category");
            return inventory;
        } catch (Exception exc) {
            exc.printStackTrace();
            return null;
        }
        finally {
            ThreadContext.remove("httpMethod");
        }
    }

    @GET
    @Path("/listByLocation")
    @Produces(MediaType.APPLICATION_JSON)
    public String FetchAllByLocation(@QueryParam("location") int location) {
        ThreadContext.put("httpMethod", "GET");
        try {
            String inv = new Gson().toJson(InventoryServices.FetchAllByLocation(location));
            logger.info("Inventory Retrieved by Location");
            return inv;
        } catch (Exception exc) {
            exc.printStackTrace();
            return null;
        }
        finally {
            ThreadContext.remove("httpMethod");
        }
    }

    @GET
    @Path("/listByCategoryAndLocation")
    @Produces(MediaType.APPLICATION_JSON)
    public String FetchAllByCategoryAndLocation(@QueryParam("category") int category, @QueryParam("location") int location) {
        ThreadContext.put("httpMethod", "GET");
        try {
            String inv = new Gson().toJson(InventoryServices.FetchAllByLocationAndCategory(location, category));
            logger.info("Inventory Retrieved by Location and Category");
            return inv;
        } catch (Exception exc) {
            exc.printStackTrace();
            return null;
        }
        finally {
            ThreadContext.remove("httpMethod");
        }
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String AddInventory(String payload) {
        ThreadContext.put("httpMethod", "POST");
        try {
            Inventory inventory = new Gson().fromJson(payload, Inventory.class);
            Boolean bool = InventoryServices.AddNewInventoryItem(inventory);
            if (bool) {
                logger.info("Inventory Added");
                return new Gson().toJson(inventory);
            }
            return "Error in Adding";
        } catch (Exception exc) {
            exc.printStackTrace();
            return null;
        }
        finally {
            ThreadContext.remove("httpMethod");
        }
    }

    @PUT
    @Path("/{InvId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String UpdateInventory(@PathParam("InvId") int InvId, String payload) {
        ThreadContext.put("httpMethod", "PUT");
        try {
            Inventory inventory = new Gson().fromJson(payload, Inventory.class);
            inventory.setID(InvId);
            Boolean bool = InventoryServices.UpdateExistingInventoryItemByID(inventory);
            if (bool) {
                logger.info("Inventory Updated");
                return new Gson().toJson(inventory);
            }
            return "Error in Updating";
        } catch (Exception exc) {
            exc.printStackTrace();
            return null;
        }
        finally {
            ThreadContext.remove("httpMethod");
        }
    }

    @DELETE
    @Path("/{InvId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String DeleteInventory(@PathParam("InvId") int InvId) {
        ThreadContext.put("httpMethod", "DELETE");
        try {
            Boolean bool = InventoryServices.DeleteExistingInventoryItemById(InvId);
            if (bool) {
                logger.info("Inventory Deleted");
                return "Deleted";
            }
            return "Error in Deletion";
        } catch (Exception exc) {
            exc.printStackTrace();
            return null;
        }
        finally {
            ThreadContext.remove("httpMethod");
        }
    }
}
