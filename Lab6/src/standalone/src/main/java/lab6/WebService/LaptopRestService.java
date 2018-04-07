package lab6.WebService;

import lab6.DAL;
import lab6.Laptop;
import lab6.LaptopConnection;
import lab6.LaptopFilter;
import lab6.StatusOperation.ResultStatusOperation;
import lab6.StatusOperation.StatusCrudOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/laptops")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LaptopRestService {
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
    public ResultStatusOperation createLaptop(Laptop laptop) throws IllegalQueryBadRequestException{
        DAL dal = new DAL(LaptopConnection.getConnection());
        ResultStatusOperation status = dal.insertLaptop(laptop);
        if(status.getStatus() == StatusCrudOperation.InsertError){
            throw new IllegalQueryBadRequestException(status.getMessage());
        }
        return status;
    }

    @PUT
    public ResultStatusOperation updateLaptop(Laptop laptop) throws IllegalQueryBadRequestException{
        DAL dal = new DAL(LaptopConnection.getConnection());
        ResultStatusOperation statusOperation = dal.updateLaptop(laptop);
        if(statusOperation.getStatus() != StatusCrudOperation.UpdateSuccess){
            throw new IllegalQueryBadRequestException(statusOperation.getMessage());
        }
        return statusOperation;
    }

    @DELETE
    @Path("/{id}")
    public ResultStatusOperation deleteLaptop(@PathParam("id") int id)throws IllegalQueryBadRequestException{
        DAL dal = new DAL(LaptopConnection.getConnection());
        ResultStatusOperation statusOperation = dal.deleteLaptop(id);
        if(statusOperation.getStatus() != StatusCrudOperation.DeleteSuccess){
            throw new IllegalQueryBadRequestException(statusOperation.getMessage());
        }
        return dal.deleteLaptop(id);
    }
}