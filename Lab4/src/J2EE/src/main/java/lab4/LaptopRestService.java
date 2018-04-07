package lab4;

import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


@Path("/laptops")
@Produces({MediaType.APPLICATION_JSON})
public class LaptopRestService {
    protected Connection getConnection() throws SQLException, NamingException {
        InitialContext ic = new InitialContext();
        DataSource ds = (DataSource) ic.lookup("jdbc/mylaptops");
        return ds.getConnection();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Laptop> getAllLaptops(){
        try(DAL dal = new DAL(getConnection())) {
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
        try(DAL dal = new DAL(getConnection())){
            return dal.getLaptopsByFilter(filter);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}