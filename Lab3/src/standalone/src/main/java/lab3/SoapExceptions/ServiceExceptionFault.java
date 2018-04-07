package lab3.SoapExceptions;

public class ServiceExceptionFault {
    protected static String DEFAULT_MESSAGE = "При выполнении операции произошла непредвиденная ошибка";
    protected String message;

    public ServiceExceptionFault(){
        this.message = DEFAULT_MESSAGE;
    }

    public ServiceExceptionFault(String _message){
        this.message = _message;
    }

    public String getMessage(){
        return this.message;
    }

    public static ServiceExceptionFault defaultInstance(){
        ServiceExceptionFault fault = new ServiceExceptionFault();
        fault.message = DEFAULT_MESSAGE;
        return fault;
    }

}