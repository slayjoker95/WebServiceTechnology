package lab4;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Path("/laptops")
public class LaptopRestService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
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
}