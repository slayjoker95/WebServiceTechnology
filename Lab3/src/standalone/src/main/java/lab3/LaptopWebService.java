package lab3;

import lab3.SoapExceptions.BaseServiceException;
import lab3.SoapExceptions.ServiceExceptionFault;
import lab3.StatusOperation.ResultStatusOperation;
import lab3.StatusOperation.StatusCrudOperation;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

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
    public ResultStatusOperation updateLaptop(@WebParam(name = "laptop") Laptop laptop) throws BaseServiceException{
        DAL dal = new DAL(LaptopConnection.getConnection());
        ResultStatusOperation res = dal.updateLaptop(laptop);
        switch (res.getStatus()){
            case UpdateEmpty:
                throw new BaseServiceException("Не обновлено ни одной записи", new ServiceExceptionFault(res.getMessage()));
            case UpdateError:
                throw new BaseServiceException("При обновлении произошла непредвиденная ошибка", ServiceExceptionFault.defaultInstance());
        }
        return res;
    }

    @WebMethod(operationName = "deleteLaptop")
    public ResultStatusOperation deleteLaptop(@WebParam(name = "id") Integer id) throws BaseServiceException{
        if (id == null){
            throw new BaseServiceException("ID удаляемой записи не может быть равен null", new ServiceExceptionFault(""));
        }
        DAL dal = new DAL(LaptopConnection.getConnection());
        ResultStatusOperation res = dal.deleteLaptop(id);
        switch (res.getStatus()){
            case DeleteEmpty:
                throw new BaseServiceException(res.getMessage(), new ServiceExceptionFault("Записи с ID = " + id + " не найдено"));
            case DeleteError:
                throw new BaseServiceException("", ServiceExceptionFault.defaultInstance());
        }
        return res;
    }

    @WebMethod(operationName = "insertLaptop")
    public ResultStatusOperation insertLaptop(@WebParam(name = "laptop") Laptop laptop) throws BaseServiceException{
        DAL dal = new DAL(LaptopConnection.getConnection());
        ResultStatusOperation res = dal.insertLaptop(laptop);
        if (res.getStatus() != StatusCrudOperation.InsertSuccess){
            throw new BaseServiceException("Не удалось выполнить операцию вставки", ServiceExceptionFault.defaultInstance());
        }
        return res;
    }

    @WebMethod(operationName = "deleteAllLaptops")
    public ResultStatusOperation deleteAllLaptops(){
        DAL dal = new DAL(LaptopConnection.getConnection());
        return dal.deleteAllLaptops();
    }
}

