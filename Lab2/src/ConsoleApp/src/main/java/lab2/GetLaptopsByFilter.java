
package lab2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getLaptopsByFilter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getLaptopsByFilter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CPU" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RAM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="video_card" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HDD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getLaptopsByFilter", propOrder = {
    "name",
    "cpu",
    "ram",
    "videoCard",
    "hdd"
})
public class GetLaptopsByFilter {

    protected String name;
    @XmlElement(name = "CPU")
    protected String cpu;
    @XmlElement(name = "RAM")
    protected String ram;
    @XmlElement(name = "video_card")
    protected String videoCard;
    @XmlElement(name = "HDD")
    protected String hdd;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the cpu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCPU() {
        return cpu;
    }

    /**
     * Sets the value of the cpu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCPU(String value) {
        this.cpu = value;
    }

    /**
     * Gets the value of the ram property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRAM() {
        return ram;
    }

    /**
     * Sets the value of the ram property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRAM(String value) {
        this.ram = value;
    }

    /**
     * Gets the value of the videoCard property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVideoCard() {
        return videoCard;
    }

    /**
     * Sets the value of the videoCard property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVideoCard(String value) {
        this.videoCard = value;
    }

    /**
     * Gets the value of the hdd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHDD() {
        return hdd;
    }

    /**
     * Sets the value of the hdd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHDD(String value) {
        this.hdd = value;
    }

}
