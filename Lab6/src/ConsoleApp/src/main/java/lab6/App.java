package lab6;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import lab6.StatusOperation.ResultStatusOperation;
import lab6.StatusOperation.StatusCrudOperation;

import javax.ws.rs.core.MediaType;
import java.net.MalformedURLException;

public class App {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";

    private static void printHttpError(ClientResponse response){
        String printOutString = String.format("Error code: %s\nMessage: %s",
                response.getStatus(),
                response.getEntity(String.class));
        System.out.println(printOutString);
    }

    private static void printLaptop(Laptop laptop){
        if(laptop != null) {
            System.out.println(laptop.toString());
        }
    }

    private static void deleteLaptop(Client client, String URL, int id, String auth){
        WebResource webResource = client.resource(URL + String.valueOf(id));
        ClientResponse response = webResource.type(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .header("Authorization", auth)
                .delete(ClientResponse.class);
        if(response.getStatus() != ClientResponse.Status.OK.getStatusCode()){
            System.out.println("----Error delete: -----");
            printHttpError(response);
            return;
        }
        ResultStatusOperation result = response.getEntity(ResultStatusOperation.class);
        System.out.println(result.getMessage());
    }

    private static void updateLaptop(Client client, String URL, Laptop laptop, String auth){
        WebResource webResource = client.resource(URL);
        ClientResponse response = webResource.type(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .header("Authorization", auth)
                .put(ClientResponse.class, laptop);
        if(response.getStatus() != ClientResponse.Status.OK.getStatusCode()){
            System.out.println("----Error update:----");
            printHttpError(response);
            return;
        }
        ResultStatusOperation result = response.getEntity(ResultStatusOperation.class);
        System.out.println(result.getMessage());
    }

    private static int createLaptop(Client client, String URL, Laptop laptop, String auth){
        WebResource webResource = client.resource(URL);
        ClientResponse response = webResource.type(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .header("Authorization", auth)
                .post(ClientResponse.class, laptop);
        if(response.getStatus() != ClientResponse.Status.OK.getStatusCode()){
            System.out.println("----Error insert:----");
            printHttpError(response);
            return 0;
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
            System.out.println("----Error getObjectQuery:----");
            printHttpError(response);
            return null;
        }
        Laptop result = response.getEntity(Laptop.class);
        return result;
    }

    private static void CrudOperationSample(Client client, String URL, String auth){
        System.out.println("-----Пытаемся получить запись с id=10000 (такой записи не существует)------");
        Laptop laptop = getLaptop(client, URL, 10000);
        printLaptop(laptop);

        System.out.println("-------------------------Запись с id = 2---------------------------");
        laptop = getLaptop(client, URL, 2);
        printLaptop(laptop);
        //обновляем запись - вносим другие значения параметров
        laptop.setName("Abracadabra");
        laptop.setRAM("50000 Mb");
        //id изменяем на 0 (с таким идентификатором записей не может быть
        laptop.setId(0);
        updateLaptop(client, URL, laptop, auth);
        //пытаемся удалить запись с id = 0
        deleteLaptop(client, URL, 0, auth);
    }

    public static void main(String[] args) throws MalformedURLException {
        String authToken = "Basic " + Base64.encodeBytes((USERNAME + ":" + PASSWORD).getBytes());
        Client client = Client.create();
        String url = "http://localhost:8080/laptops/";
        CrudOperationSample(client, url, authToken);
    }
}
