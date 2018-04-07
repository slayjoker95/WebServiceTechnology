package lab3.SoapExceptions;

import javax.xml.ws.WebFault;
import java.lang.Exception;

@WebFault(faultBean = "lab1.soap_exceptions.ServiceExceptionFault", name = "BaseServiceException")
public class BaseServiceException extends Exception {
    private final ServiceExceptionFault serviceExceptionFault;

    private static final long serialVersionUID = -6647544772732631047L;

    public BaseServiceException(){
        super();
        serviceExceptionFault = ServiceExceptionFault.defaultInstance();
    }

    public BaseServiceException(String msg, ServiceExceptionFault fault){
        super(msg);
        this.serviceExceptionFault = fault;
    }

    public BaseServiceException(String msg, ServiceExceptionFault fault, Throwable cause){
        super(msg, cause);
        this.serviceExceptionFault = fault;
    }

    public ServiceExceptionFault getServiceExceptionFault() {
        return serviceExceptionFault;
    }
}