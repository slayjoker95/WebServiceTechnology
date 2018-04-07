package lab2;

import lab2.StatusOperation.ResultStatusOperation;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName = "LaptopService")
public class LaptopWebService {
    @WebMethod(operationName = "getLaptops")
    public List<Laptop> getLaptops(){
        DAL dal = new DAL(LaptopConnection.getConnection());
        return dal.getLaptops();
    }
    @WebMethod(operationName = "getLaptopsByFilter")
    public List<Laptop> getLaptopsByFilter(@WebParam(name = "name") String name,
                                             @WebParam(name = "CPU") String CPU,
                                             @WebParam(name = "RAM") String RAM,
                                             @WebParam(name = "video_card") String video_card,
                                             @WebParam(name = "HDD") String HDD){
        LaptopFilter filter = new LaptopFilter(name,
                CPU,
                RAM,
                video_card,
                HDD);
        DAL dal = new DAL(LaptopConnection.getConnection());
        return dal.getLaptopsByFilter(filter);
    }

    @WebMethod(operationName = "updateLaptop")
    public ResultStatusOperation updateLaptop(@WebParam(name = "laptop") Laptop laptop){
        DAL dal = new DAL(LaptopConnection.getConnection());
        return dal.updateLaptop(laptop);
    }

    @WebMethod(operationName = "deleteLaptop")
    public ResultStatusOperation deleteLaptop(@WebParam(name = "id") int id){
        DAL dal = new DAL(LaptopConnection.getConnection());
        return dal.deleteLaptop(id);
    }

    @WebMethod(operationName = "insertLaptop")
    public ResultStatusOperation insertLaptop(@WebParam(name = "laptop") Laptop laptop){
        DAL dal = new DAL(LaptopConnection.getConnection());
        return dal.insertLaptop(laptop);
    }

    @WebMethod(operationName = "deleteAllLaptops")
    public ResultStatusOperation deleteAllLaptops(){
        DAL dal = new DAL(LaptopConnection.getConnection());
        return dal.deleteAllLaptops();
    }
}

