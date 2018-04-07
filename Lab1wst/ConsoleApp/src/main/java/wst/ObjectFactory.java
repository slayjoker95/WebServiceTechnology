
package wst;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the wst package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetLaptopsResponse_QNAME = new QName("http://wst/", "get-laptopsResponse");
    private final static QName _FindLaptops_QNAME = new QName("http://wst/", "find-laptops");
    private final static QName _GetLaptops_QNAME = new QName("http://wst/", "get-laptops");
    private final static QName _FindLaptopsResponse_QNAME = new QName("http://wst/", "find-laptopsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: wst
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindLaptopsResponse }
     * 
     */
    public FindLaptopsResponse createFindLaptopsResponse() {
        return new FindLaptopsResponse();
    }

    /**
     * Create an instance of {@link GetLaptopsResponse }
     * 
     */
    public GetLaptopsResponse createGetLaptopsResponse() {
        return new GetLaptopsResponse();
    }

    /**
     * Create an instance of {@link FindLaptops }
     * 
     */
    public FindLaptops createFindLaptops() {
        return new FindLaptops();
    }

    /**
     * Create an instance of {@link GetLaptops }
     * 
     */
    public GetLaptops createGetLaptops() {
        return new GetLaptops();
    }

    /**
     * Create an instance of {@link Laptop }
     * 
     */
    public Laptop createLaptop() {
        return new Laptop();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLaptopsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wst/", name = "get-laptopsResponse")
    public JAXBElement<GetLaptopsResponse> createGetLaptopsResponse(GetLaptopsResponse value) {
        return new JAXBElement<GetLaptopsResponse>(_GetLaptopsResponse_QNAME, GetLaptopsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindLaptops }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wst/", name = "find-laptops")
    public JAXBElement<FindLaptops> createFindLaptops(FindLaptops value) {
        return new JAXBElement<FindLaptops>(_FindLaptops_QNAME, FindLaptops.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLaptops }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wst/", name = "get-laptops")
    public JAXBElement<GetLaptops> createGetLaptops(GetLaptops value) {
        return new JAXBElement<GetLaptops>(_GetLaptops_QNAME, GetLaptops.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindLaptopsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wst/", name = "find-laptopsResponse")
    public JAXBElement<FindLaptopsResponse> createFindLaptopsResponse(FindLaptopsResponse value) {
        return new JAXBElement<FindLaptopsResponse>(_FindLaptopsResponse_QNAME, FindLaptopsResponse.class, null, value);
    }

}
