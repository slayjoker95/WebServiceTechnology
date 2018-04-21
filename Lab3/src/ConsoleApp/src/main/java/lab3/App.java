package lab3;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.lang.*;
import java.util.Map;

public class App {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";

    private static void PrintLaptops(List<Laptop> laptops){
        for (Laptop laptop: laptops) {
            System.out.println(String.format("Название %s:", laptop.getName()));
            System.out.println(String.format("CPU: %s", laptop.getCPU()));
            System.out.println(String.format("RAM: %s",laptop.getRAM()));
            System.out.println(String.format("Видео карта: %s", laptop.getVideoCard()));
            System.out.println(String.format("HDD: %s", laptop.getHDD()));
            System.out.println("-----------------------------------------------------");
        }
    }

    private static ResultStatusOperation insertRow(LaptopService laptopService,
                                                   Laptop laptop) throws BaseServiceException_Exception, AuthException{
        ResultStatusOperation res = laptopService.getLaptopWebServicePort().insertLaptop(laptop);
        System.out.println(res.getMessage());
        return res;
    }

    private static StatusCrudOperation deleteRow(LaptopService laptopService,
                                                 int id) throws BaseServiceException_Exception, AuthException{
        ResultStatusOperation res = laptopService.getLaptopWebServicePort().deleteLaptop(id);
        System.out.println(res.getMessage());
        return res.getStatus();
    }

    private static StatusCrudOperation updateRow(LaptopService laptopService,
                                                 Laptop laptop) throws BaseServiceException_Exception, AuthException{
        ResultStatusOperation res = laptopService.getLaptopWebServicePort().updateLaptop(laptop);
        System.out.println(res.getMessage());
        return res.getStatus();
    }


    private static void CrudOperationSample(LaptopService laptopService) throws AuthException{
        Laptop laptop = new Laptop();
        laptop.setName("New Laptop");
        laptop.setCPU("Intel");
        laptop.setRAM("8192 Mb");
        laptop.setVideoCard("GeForce");
        laptop.setHDD("1024 Gb");

        ResultStatusOperation res = null;
        try {
            res = insertRow(laptopService, laptop);
            deleteRow(laptopService, res.getId());
        }
        catch(BaseServiceException_Exception e){
            System.out.println(res.getMessage());
        }

        try{
            deleteRow(laptopService, 0);
        }
        catch(BaseServiceException_Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws MalformedURLException, AuthException{
        String authToken = "Basic " + Base64.encodeBytes((USERNAME + ":" + PASSWORD).getBytes());
        URL url = new URL("http://localhost:8080/LaptopService?wsdl");
        LaptopService laptopService = new LaptopService(url);
        LaptopWebService laptopWebService = laptopService.getLaptopWebServicePort();

        Map<String, List<String>> credentials = new HashMap<>();
        credentials.put("Authorization", Collections.singletonList(authToken));
        BindingProvider bindingProvider = (BindingProvider) laptopWebService;
        bindingProvider.getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS, credentials);
        System.out.println("Simple hard code client for service");
        CrudOperationSample(laptopService);
    }
}