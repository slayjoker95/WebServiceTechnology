package lab4;

import java.awt.*;
import java.net.MalformedURLException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

import java.util.List;
import java.util.logging.Filter;
import javax.ws.rs.core.MediaType;

public class App {
    private static void PrintLaptops(List<Laptop> laptops){
        for (Laptop laptop: laptops) {
            System.out.println(String.format("Название %s:", laptop.getName()));
            System.out.println(String.format("CPU: %s", laptop.getCPU()));
            System.out.println(String.format("RAM: %s", laptop.getRAM()));
            System.out.println(String.format("Видео карта: %s", laptop.getVideo_card()));
            System.out.println(String.format("HDD: %s", laptop.getHDD()));
            System.out.println("-----------------------------------------------------");
        }
    }

    private static List<Laptop> getLaptops(Client client, String URL, LaptopFilter filter){
        WebResource webResource = client.resource(URL);
        ClientResponse response;
        if(filter == null){
            response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        }
        else{
            String json = "{\"id\": 1}";
            response = webResource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).post(ClientResponse.class, filter);
        }
        if(response.getStatus() != ClientResponse.Status.OK.getStatusCode()){
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }
        GenericType<List<Laptop>> type = new GenericType<List<Laptop>>(){};
        List<Laptop> tmp = response.getEntity(type);
        return tmp;
    }

    public static void main(String[] args) throws MalformedURLException {
        Client client = Client.create();
        String url = "http://localhost:8080/laptops";
        System.out.println("Все ноутбуки:");
        PrintLaptops(getLaptops(client, url, null));
        url = "http://localhost:8080/laptops/search";
        System.out.println("--------------------поиск без параметров (все фильтры пустые):---------------");
        PrintLaptops(getLaptops(client, url, new LaptopFilter()));
        System.out.println("--------Поиск по RAM -------------");
        PrintLaptops(getLaptops (client, url, new LaptopFilter(null, null, "4096 Mb", null, null)));
        System.out.println("----------Поиск по RAM и HDD");
        PrintLaptops(getLaptops(client, url, new LaptopFilter(null, null, "4096 Mb", null, "500 Gb")));
    }
}