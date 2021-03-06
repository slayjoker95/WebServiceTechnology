
package wst;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "LaptopWebService", targetNamespace = "http://wst/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface LaptopWebService {


    /**
     * 
     * @param videoCard
     * @param name
     * @param cpu
     * @param hdd
     * @param ram
     * @return
     *     returns java.util.List<wst.Laptop>
     */
    @WebMethod(operationName = "find-laptops")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "find-laptops", targetNamespace = "http://wst/", className = "wst.FindLaptops")
    @ResponseWrapper(localName = "find-laptopsResponse", targetNamespace = "http://wst/", className = "wst.FindLaptopsResponse")
    @Action(input = "http://wst/LaptopWebService/find-laptopsRequest", output = "http://wst/LaptopWebService/find-laptopsResponse")
    public List<Laptop> findLaptops(
        @WebParam(name = "name", targetNamespace = "")
        String name,
        @WebParam(name = "CPU", targetNamespace = "")
        String cpu,
        @WebParam(name = "RAM", targetNamespace = "")
        String ram,
        @WebParam(name = "video_card", targetNamespace = "")
        String videoCard,
        @WebParam(name = "HDD", targetNamespace = "")
        String hdd);

    /**
     * 
     * @return
     *     returns java.util.List<wst.Laptop>
     */
    @WebMethod(operationName = "get-laptops")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "get-laptops", targetNamespace = "http://wst/", className = "wst.GetLaptops")
    @ResponseWrapper(localName = "get-laptopsResponse", targetNamespace = "http://wst/", className = "wst.GetLaptopsResponse")
    @Action(input = "http://wst/LaptopWebService/get-laptopsRequest", output = "http://wst/LaptopWebService/get-laptopsResponse")
    public List<Laptop> getLaptops();

}
