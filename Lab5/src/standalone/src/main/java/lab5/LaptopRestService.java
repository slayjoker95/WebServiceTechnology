package lab5;

import lab5.StatusOperation.ResultStatusOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;
import java.util.List;

@Path("/laptops")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LaptopRestService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Laptop> getAllLaptops(){
        try(DAL dal = new DAL(LaptopConnection.getConnection())) {
            List<Laptop> laptops = dal.getLaptops();
            return laptops;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @POST
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Laptop> getLaptopByFilter(LaptopFilter filter){
        try(DAL dal = new DAL(LaptopConnection.getConnection())){
            return dal.getLaptopsByFilter(filter);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Laptop getLaptop(@PathParam("id") int id){
        DAL dal = new DAL(LaptopConnection.getConnection());
        return dal.getLaptop(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResultStatusOperation createLaptop(Laptop laptop){
        DAL dal = new DAL(LaptopConnection.getConnection());
        return dal.insertLaptop(laptop);
    }

    @PUT
    public ResultStatusOperation updateLaptop(Laptop laptop){
        DAL dal = new DAL(LaptopConnection.getConnection());
        return dal.updateLaptop(laptop);
    }

    @DELETE
    @Path("/{id}")
    public ResultStatusOperation deleteLaptop(@PathParam("id") int id){
        DAL dal = new DAL(LaptopConnection.getConnection());
        return dal.deleteLaptop(id);
    }
}