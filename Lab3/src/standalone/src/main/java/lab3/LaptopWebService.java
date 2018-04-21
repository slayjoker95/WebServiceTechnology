package lab3;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import lab3.SoapExceptions.AuthException;
import lab3.SoapExceptions.BaseServiceException;
import lab3.SoapExceptions.ServiceExceptionFault;
import lab3.StatusOperation.ResultStatusOperation;
import lab3.StatusOperation.StatusCrudOperation;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

@WebService(serviceName = "LaptopService")
public class LaptopWebService {

    private static final String AUTH_HEADER_KEY = "Authorization";
    private static final String AUTH_HEADER_PREFIX = "Basic ";

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";

    @Resource
    private WebServiceContext webServiceContext;

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
    public ResultStatusOperation updateLaptop(@WebParam(name = "laptop") Laptop laptop) throws BaseServiceException, AuthException {
        MessageContext messageContext = webServiceContext.getMessageContext();
        if (!isAuth(messageContext))
        {
            ServiceExceptionFault fault = ServiceExceptionFault.defaultInstance();
            fault.setMessage("Authentication error");
            throw new AuthException("Invalid login-password", fault);
        }
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
    public ResultStatusOperation deleteLaptop(@WebParam(name = "id") Integer id) throws BaseServiceException, AuthException{
        if (id == null){
            throw new BaseServiceException("ID удаляемой записи не может быть равен null", new ServiceExceptionFault(""));
        }
        MessageContext messageContext = webServiceContext.getMessageContext();
        if (!isAuth(messageContext))
        {
            ServiceExceptionFault fault = ServiceExceptionFault.defaultInstance();
            fault.setMessage("Authentication error");
            throw new AuthException("Invalid login-password", fault);
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
    public ResultStatusOperation insertLaptop(@WebParam(name = "laptop") Laptop laptop) throws BaseServiceException, AuthException{
        MessageContext messageContext = webServiceContext.getMessageContext();
        if (!isAuth(messageContext))
        {
            ServiceExceptionFault fault = ServiceExceptionFault.defaultInstance();
            fault.setMessage("Authentication error");
            throw new AuthException("Invalid login-password", fault);
        }
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

    private boolean isAuth(MessageContext ctx) {
        Map headers = (Map) ctx.get(MessageContext.HTTP_REQUEST_HEADERS);
        if (!headers.containsKey(AUTH_HEADER_KEY)) {
            return false;
        }

        List<String> authHeader = (List<String>) headers.get(AUTH_HEADER_KEY);
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

