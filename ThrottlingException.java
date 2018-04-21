public class ThrottlingException extends Exception{
    public ThrottlingException(String message){     
        super(message);
    }
    public ThrottlingException(){
        super("Превышено количество запросов!");
    }
}