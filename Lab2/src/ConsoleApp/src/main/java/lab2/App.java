package lab2;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

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
                                                   Laptop laptop){
        ResultStatusOperation res = laptopService.getLaptopWebServicePort().insertLaptop(laptop);
        System.out.println(res.getMessage());
        return res;
    }

    private static StatusCrudOperation deleteRow(LaptopService laptopService,
                                                 int id){
        ResultStatusOperation res = laptopService.getLaptopWebServicePort().deleteLaptop(id);
        System.out.println(res.getMessage());
        return res.getStatus();
    }

    private static StatusCrudOperation updateRow(LaptopService laptopService,
                                                 Laptop laptop){
        ResultStatusOperation res = laptopService.getLaptopWebServicePort().updateLaptop(laptop);
        System.out.println(res.getMessage());
        return res.getStatus();
    }

    private static void CrudOperationSample(LaptopService laptopService){
        Laptop laptop = new Laptop();
        laptop.setName("laptop");
        laptop.setCPU("Intel");
        laptop.setRAM("4096 Mb");
        laptop.setVideoCard("GeForce");
        laptop.setHDD("500 Gb");

        ResultStatusOperation res = insertRow(laptopService, laptop);
        switch (res.getStatus()){
            case INSERT_SUCCESS:
                deleteRow(laptopService, res.getId());
                break;
            case INSERT_ERROR:
                System.out.println("При вставке записи произошла ошибка, удалять нечего.");
                break;
        }

        res = insertRow(laptopService, laptop);
        switch (res.getStatus()){
            case INSERT_SUCCESS:
                Laptop updateLaptop = new Laptop();
                updateLaptop.setId(res.getId());
                updateLaptop.setName("Laptop new");
                updateLaptop.setCPU("AMD");
                updateLaptop.setRAM("8192 Mb");
                updateLaptop.setVideoCard("Intel");
                updateLaptop.setHDD("1024 Gb");
                updateRow(laptopService, updateLaptop);
                break;
            case INSERT_ERROR:
                System.out.println("При вставке записи произошла ошибка, обновление невозможно");
                break;
        }
        deleteRow(laptopService, res.getId());
    }

    public static void main(String[] args) throws MalformedURLException{
        URL url = new URL("http://localhost:8080/LaptopService?wsdl");
        LaptopService laptopService = new LaptopService(url);
        CrudOperationSample(laptopService);
    }
}
