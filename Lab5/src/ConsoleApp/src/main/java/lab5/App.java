package lab5;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import lab5.StatusOperation.ResultStatusOperation;

import javax.ws.rs.core.MediaType;
import java.net.MalformedURLException;
import java.util.List;

import lab5.StatusOperation.StatusCrudOperation;

public class App {

    private static void printLaptop(Laptop laptop){
        System.out.println(laptop.toString());
    }

    private static void deleteLaptop(Client client, String URL, int id){
        WebResource webResource = client.resource(URL + String.valueOf(id));
        ClientResponse response = webResource.type(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .delete(ClientResponse.class);
        if(response.getStatus() != ClientResponse.Status.OK.getStatusCode()){
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }
        ResultStatusOperation result = response.getEntity(ResultStatusOperation.class);
        System.out.println(result.getMessage());
    }

    private static void updateLaptop(Client client, String URL, Laptop laptop){
        WebResource webResource = client.resource(URL);
        ClientResponse response = webResource.type(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .put(ClientResponse.class, laptop);
        if(response.getStatus() != ClientResponse.Status.OK.getStatusCode()){
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }
        ResultStatusOperation result = response.getEntity(ResultStatusOperation.class);
        System.out.println(result.getMessage());
    }

    private static int createLaptop(Client client, String URL, Laptop laptop){
        WebResource webResource = client.resource(URL);
        ClientResponse response = webResource.type(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .post(ClientResponse.class, laptop);
        if(response.getStatus() != ClientResponse.Status.OK.getStatusCode()){
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }
        ResultStatusOperation result = response.getEntity(ResultStatusOperation.class);
        System.out.println(result.getMessage());
        if(result.getStatus() == StatusCrudOperation.InsertSuccess){
            return result.getId();
        }
        return 0;
    }

    private static Laptop getLaptop(Client client, String URL, int id){
        WebResource webResource = client.resource(URL + String.valueOf(id));
        ClientResponse response = webResource
                .accept(MediaType.APPLICATION_JSON)
                .get(ClientResponse.class);
        if(response.getStatus() != ClientResponse.Status.OK.getStatusCode()){
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }
        Laptop result = response.getEntity(Laptop.class);
        return result;
    }

    private static void CrudOperationSample(Client client, String URL){
        System.out.println("-------------------------Запись с id = 2---------------------------");
        Laptop laptop = getLaptop(client, URL, 2);
        printLaptop(laptop);
        //вставляем новую запись
        laptop = new Laptop("Laptop", "Intel", "4096 Mb", "GeForce", "500 Gb");
        laptop.setId(createLaptop(client, URL, laptop));
        if(laptop.getId() != 0){
            System.out.println("---------Вновь вставленная запись:---------------");
            printLaptop(laptop);
            //обновляем запись - вносим другие значения параметров
            laptop.setRAM("8192");
            laptop.setHDD("1024 Gb");
            updateLaptop(client, URL, laptop);
            System.out.println("---------Обновленная запись:---------------");
            printLaptop(laptop);
            //удаляем запись
            deleteLaptop(client, URL, laptop.getId());
        }
    }

    public static void main(String[] args) throws MalformedURLException {
        Client client = Client.create();
        String url = "http://localhost:8080/laptops/";
        CrudOperationSample(client, url);
    }
}
