package wst;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static void print(List<Laptop> laptops) {
        String separator = "----------------------------------------------------------------------------------------------------------------------------------";
        System.out.println(separator);
        System.out.printf("| %5s | %30s | %30s | %11s | %25s | %10s |%n",
                "ID",
                "Название",
                "CPU",
                "RAM",
                "Видео карта",
                "HDD");
        System.out.println(separator);
        laptops.forEach(laptop -> System.out.printf("| %5d | %30s | %30s | %11s | %25s | %10s |%n",
                laptop.getId(),
                laptop.getName(),
                laptop.getCPU(),
                laptop.getRAM(),
                laptop.getVideoCard(),
                laptop.getHDD()));
        System.out.println(separator);
        System.out.printf("Всего: %d.%n%n", laptops.size());
    }

    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:8080/laptop-service?wsdl");
            LaptopService laptopService = new LaptopService(url);
            System.out.printf("Все ноутбуки:%n");
            print(laptopService.getLaptopWebServicePort().getLaptops());
            System.out.printf("Поиск по HDD \"500 Gb\":%n");
            print(laptopService.getLaptopWebServicePort().findLaptops(
                    null,
                    null,
                    null,
                    null,
                    "500 Gb"));
            System.out.printf("Поиск по RAM \"4096 Mb\":%n");
            print(laptopService.getLaptopWebServicePort().findLaptops(
                    null,
                    null,
                    "4096 Mb",
                    null,
                    null));
            System.out.printf("Поиск по HDD \"500 Gb\" или RAM \"4096 Mb\":%n");
            print(laptopService.getLaptopWebServicePort().findLaptops(
                    null,
                    null,
                    "4096 Mb",
                    null,
                    "500 Gb"));

        } catch (MalformedURLException e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
