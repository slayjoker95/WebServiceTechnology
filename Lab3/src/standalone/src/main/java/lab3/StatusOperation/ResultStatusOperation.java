package lab3.StatusOperation;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "ResultStatusOperation" )
public class ResultStatusOperation implements java.io.Serializable {
    StatusCrudOperation status;
    String message;
    int id;

    public ResultStatusOperation(){

    }

    public ResultStatusOperation(StatusCrudOperation _status,
                                 String msg){
        this.status = _status;
        this.message = msg;
        this.id = -1;
    }

    public ResultStatusOperation(StatusCrudOperation _status,
                                 String msg,
                                 int _id){
        this.status = _status;
        this.message = msg;
        this.id = _id;
    }
    @XmlElement(name = "Status")
    public StatusCrudOperation getStatus(){
        return this.status;
    }
    @XmlElement(name = "Message")
    public String getMessage(){
        return this.message;
    }
    @XmlElement(name = "Id")
    public int getId(){
        return this.id;
    }

}