
package lab2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the lab2 package. 
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

    private final static QName _DeleteLaptopResponse_QNAME = new QName("http://lab2/", "deleteLaptopResponse");
    private final static QName _ResultStatusOperation_QNAME = new QName("http://lab2/", "ResultStatusOperation");
    private final static QName _DeleteAllLaptopsResponse_QNAME = new QName("http://lab2/", "deleteAllLaptopsResponse");
    private final static QName _DeleteLaptop_QNAME = new QName("http://lab2/", "deleteLaptop");
    private final static QName _GetLaptopsByFilter_QNAME = new QName("http://lab2/", "getLaptopsByFilter");
    private final static QName _UpdateLaptopResponse_QNAME = new QName("http://lab2/", "updateLaptopResponse");
    private final static QName _UpdateLaptop_QNAME = new QName("http://lab2/", "updateLaptop");
    private final static QName _GetLaptops_QNAME = new QName("http://lab2/", "getLaptops");
    private final static QName _GetLaptopsByFilterResponse_QNAME = new QName("http://lab2/", "getLaptopsByFilterResponse");
    private final static QName _StatusCrudOperation_QNAME = new QName("http://lab2/", "StatusCrudOperation");
    private final static QName _DeleteAllLaptops_QNAME = new QName("http://lab2/", "deleteAllLaptops");
    private final static QName _GetLaptopsResponse_QNAME = new QName("http://lab2/", "getLaptopsResponse");
    private final static QName _InsertLaptop_QNAME = new QName("http://lab2/", "insertLaptop");
    private final static QName _InsertLaptopResponse_QNAME = new QName("http://lab2/", "insertLaptopResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: lab2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InsertLaptop }
     * 
     */
    public InsertLaptop createInsertLaptop() {
        return new InsertLaptop();
    }

    /**
     * Create an instance of {@link InsertLaptopResponse }
     * 
     */
    public InsertLaptopResponse createInsertLaptopResponse() {
        return new InsertLaptopResponse();
    }

    /**
     * Create an instance of {@link DeleteAllLaptops }
     * 
     */
    public DeleteAllLaptops createDeleteAllLaptops() {
        return new DeleteAllLaptops();
    }

    /**
     * Create an instance of {@link GetLaptopsResponse }
     * 
     */
    public GetLaptopsResponse createGetLaptopsResponse() {
        return new GetLaptopsResponse();
    }

    /**
     * Create an instance of {@link ResultStatusOperation }
     * 
     */
    public ResultStatusOperation createResultStatusOperation() {
        return new ResultStatusOperation();
    }

    /**
     * Create an instance of {@link DeleteAllLaptopsResponse }
     * 
     */
    public DeleteAllLaptopsResponse createDeleteAllLaptopsResponse() {
        return new DeleteAllLaptopsResponse();
    }

    /**
     * Create an instance of {@link DeleteLaptop }
     * 
     */
    public DeleteLaptop createDeleteLaptop() {
        return new DeleteLaptop();
    }

    /**
     * Create an instance of {@link GetLaptopsByFilter }
     * 
     */
    public GetLaptopsByFilter createGetLaptopsByFilter() {
        return new GetLaptopsByFilter();
    }

    /**
     * Create an instance of {@link UpdateLaptopResponse }
     * 
     */
    public UpdateLaptopResponse createUpdateLaptopResponse() {
        return new UpdateLaptopResponse();
    }

    /**
     * Create an instance of {@link UpdateLaptop }
     * 
     */
    public UpdateLaptop createUpdateLaptop() {
        return new UpdateLaptop();
    }

    /**
     * Create an instance of {@link GetLaptops }
     * 
     */
    public GetLaptops createGetLaptops() {
        return new GetLaptops();
    }

    /**
     * Create an instance of {@link GetLaptopsByFilterResponse }
     * 
     */
    public GetLaptopsByFilterResponse createGetLaptopsByFilterResponse() {
        return new GetLaptopsByFilterResponse();
    }

    /**
     * Create an instance of {@link DeleteLaptopResponse }
     * 
     */
    public DeleteLaptopResponse createDeleteLaptopResponse() {
        return new DeleteLaptopResponse();
    }

    /**
     * Create an instance of {@link Laptop }
     * 
     */
    public Laptop createLaptop() {
        return new Laptop();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteLaptopResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab2/", name = "deleteLaptopResponse")
    public JAXBElement<DeleteLaptopResponse> createDeleteLaptopResponse(DeleteLaptopResponse value) {
        return new JAXBElement<DeleteLaptopResponse>(_DeleteLaptopResponse_QNAME, DeleteLaptopResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResultStatusOperation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab2/", name = "ResultStatusOperation")
    public JAXBElement<ResultStatusOperation> createResultStatusOperation(ResultStatusOperation value) {
        return new JAXBElement<ResultStatusOperation>(_ResultStatusOperation_QNAME, ResultStatusOperation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteAllLaptopsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab2/", name = "deleteAllLaptopsResponse")
    public JAXBElement<DeleteAllLaptopsResponse> createDeleteAllLaptopsResponse(DeleteAllLaptopsResponse value) {
        return new JAXBElement<DeleteAllLaptopsResponse>(_DeleteAllLaptopsResponse_QNAME, DeleteAllLaptopsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteLaptop }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab2/", name = "deleteLaptop")
    public JAXBElement<DeleteLaptop> createDeleteLaptop(DeleteLaptop value) {
        return new JAXBElement<DeleteLaptop>(_DeleteLaptop_QNAME, DeleteLaptop.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLaptopsByFilter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab2/", name = "getLaptopsByFilter")
    public JAXBElement<GetLaptopsByFilter> createGetLaptopsByFilter(GetLaptopsByFilter value) {
        return new JAXBElement<GetLaptopsByFilter>(_GetLaptopsByFilter_QNAME, GetLaptopsByFilter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateLaptopResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab2/", name = "updateLaptopResponse")
    public JAXBElement<UpdateLaptopResponse> createUpdateLaptopResponse(UpdateLaptopResponse value) {
        return new JAXBElement<UpdateLaptopResponse>(_UpdateLaptopResponse_QNAME, UpdateLaptopResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateLaptop }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab2/", name = "updateLaptop")
    public JAXBElement<UpdateLaptop> createUpdateLaptop(UpdateLaptop value) {
        return new JAXBElement<UpdateLaptop>(_UpdateLaptop_QNAME, UpdateLaptop.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLaptops }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab2/", name = "getLaptops")
    public JAXBElement<GetLaptops> createGetLaptops(GetLaptops value) {
        return new JAXBElement<GetLaptops>(_GetLaptops_QNAME, GetLaptops.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLaptopsByFilterResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab2/", name = "getLaptopsByFilterResponse")
    public JAXBElement<GetLaptopsByFilterResponse> createGetLaptopsByFilterResponse(GetLaptopsByFilterResponse value) {
        return new JAXBElement<GetLaptopsByFilterResponse>(_GetLaptopsByFilterResponse_QNAME, GetLaptopsByFilterResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StatusCrudOperation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab2/", name = "StatusCrudOperation")
    public JAXBElement<StatusCrudOperation> createStatusCrudOperation(StatusCrudOperation value) {
        return new JAXBElement<StatusCrudOperation>(_StatusCrudOperation_QNAME, StatusCrudOperation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteAllLaptops }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab2/", name = "deleteAllLaptops")
    public JAXBElement<DeleteAllLaptops> createDeleteAllLaptops(DeleteAllLaptops value) {
        return new JAXBElement<DeleteAllLaptops>(_DeleteAllLaptops_QNAME, DeleteAllLaptops.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLaptopsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab2/", name = "getLaptopsResponse")
    public JAXBElement<GetLaptopsResponse> createGetLaptopsResponse(GetLaptopsResponse value) {
        return new JAXBElement<GetLaptopsResponse>(_GetLaptopsResponse_QNAME, GetLaptopsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertLaptop }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab2/", name = "insertLaptop")
    public JAXBElement<InsertLaptop> createInsertLaptop(InsertLaptop value) {
        return new JAXBElement<InsertLaptop>(_InsertLaptop_QNAME, InsertLaptop.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertLaptopResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab2/", name = "insertLaptopResponse")
    public JAXBElement<InsertLaptopResponse> createInsertLaptopResponse(InsertLaptopResponse value) {
        return new JAXBElement<InsertLaptopResponse>(_InsertLaptopResponse_QNAME, InsertLaptopResponse.class, null, value);
    }

}
