
package lab3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BaseServiceException complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BaseServiceException">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="serviceExceptionFault" type="{http://lab3/}serviceExceptionFault" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaseServiceException", propOrder = {
    "message",
    "serviceExceptionFault"
})
public class BaseServiceException {

    protected String message;
    protected ServiceExceptionFault serviceExceptionFault;

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Gets the value of the serviceExceptionFault property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceExceptionFault }
     *     
     */
    public ServiceExceptionFault getServiceExceptionFault() {
        return serviceExceptionFault;
    }

    /**
     * Sets the value of the serviceExceptionFault property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceExceptionFault }
     *     
     */
    public void setServiceExceptionFault(ServiceExceptionFault value) {
        this.serviceExceptionFault = value;
    }

}
