
package lab3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for insertLaptop complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="insertLaptop">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="laptop" type="{http://lab3/}laptop" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insertLaptop", propOrder = {
    "laptop"
})
public class InsertLaptop {

    protected Laptop laptop;

    /**
     * Gets the value of the laptop property.
     * 
     * @return
     *     possible object is
     *     {@link Laptop }
     *     
     */
    public Laptop getLaptop() {
        return laptop;
    }

    /**
     * Sets the value of the laptop property.
     * 
     * @param value
     *     allowed object is
     *     {@link Laptop }
     *     
     */
    public void setLaptop(Laptop value) {
        this.laptop = value;
    }

}
