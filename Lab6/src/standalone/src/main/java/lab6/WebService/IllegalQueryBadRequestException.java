package lab6.WebService;

public class IllegalQueryBadRequestException extends Exception {
    private static final long serialVersionUID = -6647544772732631047L;
    private static final String DEFAULT_MESSSAGE = "Произошла ошибка при обращении к базе данных. Возможно, ресурс временно недоступен";


    public IllegalQueryBadRequestException getInstance(){
        return new IllegalQueryBadRequestException(DEFAULT_MESSSAGE);
    }

    public IllegalQueryBadRequestException(String msg){
        super(msg);
    }
}