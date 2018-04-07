package lab4.StatusOperation;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResultStatusOperation {
    StatusCrudOperation status;
    String message;
    //будет содержать id вставленной записи
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

    public StatusCrudOperation getStatus(){
        return this.status;
    }

    public void setStatus(StatusCrudOperation status){
        this.status = status;
    }

    public String getMessage(){
        return this.message;
    }

    public void setMessage(String msg){
        this.message = msg;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

}