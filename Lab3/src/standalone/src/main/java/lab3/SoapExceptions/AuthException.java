package lab3.SoapExceptions;

import javax.xml.ws.WebFault;

@WebFault(faultBean = "lab3.SoapExceptions.ServiceExceptionFault")
public class AuthException extends Exception {
    private static final long serialVersionUID = -6647544772732631047L;
    private final ServiceExceptionFault fault;

    public AuthException(String message, ServiceExceptionFault fault) {
        super(message);
        this.fault = fault;
    }

    public AuthException(String message, ServiceExceptionFault fault, Throwable cause) {
        super(message, cause);
        this.fault = fault;
    }

    public ServiceExceptionFault getFaultInfo() {
        return fault;
    }
}
