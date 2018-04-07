package lab3;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.lang.*;

public class App {

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
                                                   Laptop laptop) throws BaseServiceException_Exception{
        ResultStatusOperation res = laptopService.getLaptopWebServicePort().insertLaptop(laptop);
        System.out.println(res.getMessage());
        return res;
    }

    private static StatusCrudOperation deleteRow(LaptopService laptopService,
                                                 int id) throws BaseServiceException_Exception{
        ResultStatusOperation res = laptopService.getLaptopWebServicePort().deleteLaptop(id);
        System.out.println(res.getMessage());
        return res.getStatus();
    }

    private static StatusCrudOperation updateRow(LaptopService laptopService,
                                                 Laptop laptop) throws BaseServiceException_Exception{
        ResultStatusOperation res = laptopService.getLaptopWebServicePort().updateLaptop(laptop);
        System.out.println(res.getMessage());
        return res.getStatus();
    }


    private static void CrudOperationSample(LaptopService laptopService){
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

    public static void main(String[] args) throws MalformedURLException{
        URL url = new URL("http://localhost:8080/LaptopService?wsdl");
        LaptopService laptopService = new LaptopService(url);
        CrudOperationSample(laptopService);
    }
}
