package lab2.StatusOperation;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "StatusCrudOperation" )
public enum StatusCrudOperation implements java.io.Serializable {
    DeleteSuccess,
    DeleteError,
    DeleteEmpty,
    UpdateSuccess,
    UpdateError,
    UpdateEmpty,
    InsertSuccess,
    InsertError
}
