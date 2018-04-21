package lab6.WebService;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import lab6.DAL;
import lab6.Laptop;
import lab6.LaptopConnection;
import lab6.LaptopFilter;
import lab6.StatusOperation.ResultStatusOperation;
import lab6.StatusOperation.StatusCrudOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.StringTokenizer;

@Path("/laptops")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LaptopRestService {

    private static final String AUTH_HEADER_KEY = "Authorization";
    private static final String AUTH_HEADER_PREFIX = "Basic ";

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Laptop> getAllLaptops() throws IllegalQueryBadRequestException{
        DAL dal = new DAL(LaptopConnection.getConnection());
        List<Laptop> laptops = dal.getLaptops();
        if(laptops == null || (laptops != null && laptops.isEmpty())){
            throw new IllegalQueryBadRequestException("Не найдено ни одной записи");
        }
        return laptops;
    }

    @POST
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Laptop> getLaptopByFilter(LaptopFilter filter) throws IllegalQueryBadRequestException{
        DAL dal = new DAL(LaptopConnection.getConnection());
        List<Laptop> laptops = dal.getLaptopsByFilter(filter);
        if(laptops == null || (laptops != null && laptops.isEmpty())){
            throw new IllegalQueryBadRequestException("Не найдено ни одной записи, удовлетворящей фильтру");
        }
        return laptops;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Laptop getLaptop(@PathParam("id") int id) throws IllegalQueryBadRequestException{
        DAL dal = new DAL(LaptopConnection.getConnection());
        Laptop laptop = dal.getLaptop(id);
        if(laptop == null){
            throw new IllegalQueryBadRequestException("Не верный идентификатор запроса");
        }
        return laptop;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResultStatusOperation createLaptop(@Context HttpHeaders headers, Laptop laptop) throws IllegalQueryBadRequestException, AuthException{
        if (!isAuthenticated(headers)) {
            throw AuthException.DEFAULT_INSTANCE;
        }
        DAL dal = new DAL(LaptopConnection.getConnection());
        ResultStatusOperation status = dal.insertLaptop(laptop);
        if(status.getStatus() == StatusCrudOperation.InsertError){
            throw new IllegalQueryBadRequestException(status.getMessage());
        }
        return status;
    }

    @PUT
    public ResultStatusOperation updateLaptop(@Context HttpHeaders headers, Laptop laptop) throws IllegalQueryBadRequestException, AuthException{
        if (!isAuthenticated(headers)) {
            throw AuthException.DEFAULT_INSTANCE;
        }
        DAL dal = new DAL(LaptopConnection.getConnection());
        ResultStatusOperation statusOperation = dal.updateLaptop(laptop);
        if(statusOperation.getStatus() != StatusCrudOperation.UpdateSuccess){
            throw new IllegalQueryBadRequestException(statusOperation.getMessage());
        }
        return statusOperation;
    }

    @DELETE
    @Path("/{id}")
    public ResultStatusOperation deleteLaptop(@Context HttpHeaders headers, @PathParam("id") int id)throws IllegalQueryBadRequestException, AuthException{
        if (!isAuthenticated(headers)) {
            throw AuthException.DEFAULT_INSTANCE;
        }
        DAL dal = new DAL(LaptopConnection.getConnection());
        ResultStatusOperation statusOperation = dal.deleteLaptop(id);
        if(statusOperation.getStatus() != StatusCrudOperation.DeleteSuccess){
            throw new IllegalQueryBadRequestException(statusOperation.getMessage());
        }
        return dal.deleteLaptop(id);
    }

    private boolean isAuthenticated(HttpHeaders headers) {
        List<String> authHeader = headers.getRequestHeaders().get(AUTH_HEADER_KEY);
        if (authHeader == null) {
            return false;
        }

        String authToken = authHeader.get(0);
        if (authToken.isEmpty()) {
            return false;
        }

        authToken = authToken.replaceFirst(AUTH_HEADER_PREFIX, "");
        String decodedString = new String(Base64.decode(authToken));
        StringTokenizer stringTokenizer = new StringTokenizer(decodedString, ":");
        String username = stringTokenizer.nextToken();
        String password = stringTokenizer.nextToken();

        return username.equals(USERNAME) && password.equals(PASSWORD);
    }
}