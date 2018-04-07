
package lab2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for statusCrudOperation.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="statusCrudOperation">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DeleteSuccess"/>
 *     &lt;enumeration value="DeleteError"/>
 *     &lt;enumeration value="DeleteEmpty"/>
 *     &lt;enumeration value="UpdateSuccess"/>
 *     &lt;enumeration value="UpdateError"/>
 *     &lt;enumeration value="UpdateEmpty"/>
 *     &lt;enumeration value="InsertSuccess"/>
 *     &lt;enumeration value="InsertError"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "statusCrudOperation")
@XmlEnum
public enum StatusCrudOperation {

    @XmlEnumValue("DeleteSuccess")
    DELETE_SUCCESS("DeleteSuccess"),
    @XmlEnumValue("DeleteError")
    DELETE_ERROR("DeleteError"),
    @XmlEnumValue("DeleteEmpty")
    DELETE_EMPTY("DeleteEmpty"),
    @XmlEnumValue("UpdateSuccess")
    UPDATE_SUCCESS("UpdateSuccess"),
    @XmlEnumValue("UpdateError")
    UPDATE_ERROR("UpdateError"),
    @XmlEnumValue("UpdateEmpty")
    UPDATE_EMPTY("UpdateEmpty"),
    @XmlEnumValue("InsertSuccess")
    INSERT_SUCCESS("InsertSuccess"),
    @XmlEnumValue("InsertError")
    INSERT_ERROR("InsertError");
    private final String value;

    StatusCrudOperation(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static StatusCrudOperation fromValue(String v) {
        for (StatusCrudOperation c: StatusCrudOperation.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
