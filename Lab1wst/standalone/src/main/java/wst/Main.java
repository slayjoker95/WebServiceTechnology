package wst;

import javax.xml.ws.Endpoint;

public class Main {
    public static void main(String[] args) {
        String url = "http://localhost:8080/laptop-service";
        Endpoint.publish(url, new LaptopWebService());
    }
}
