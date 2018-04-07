package lab7;

public class App {
    public static void main(String args[]) throws Exception{
        UddiApacheInteraction publishWebService =
                new UddiApacheInteraction("META-INF/uddi.xml");
        String URL = "http://localhost:8080/LaptopService?wsdl";
        //публикуем веб-сервис
        String serviceKey = publishWebService.publish("Laptops", "laptops", URL);

        publishWebService.getServiceListByName("");

        publishWebService.logOut();

    }
}
