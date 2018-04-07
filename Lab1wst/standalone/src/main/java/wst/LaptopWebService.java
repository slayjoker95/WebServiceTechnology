package wst;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "laptop-service")
public class LaptopWebService {

    @WebMethod(operationName = "get-laptops")
    public List<Laptop> getLaptops() {
        SQLDAO sqldao = new SQLDAO();

        return sqldao.getLaptops();
    }

    @WebMethod(operationName = "find-laptops")
    public List<Laptop> findLaptops(
            @WebParam(name = "name") String name,
            @WebParam(name = "CPU") String CPU,
            @WebParam(name = "RAM") String RAM,
            @WebParam(name = "video_card") String video_card,
            @WebParam(name = "HDD") String HDD
    ) {
        SQLDAO sqldao = new SQLDAO();

        return sqldao.findLaptops(new LaptopFilter(
                name,
                CPU,
                RAM,
                video_card,
                HDD
        ));
    }
}