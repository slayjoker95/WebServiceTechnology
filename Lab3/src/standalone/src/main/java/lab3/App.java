package lab3;

import javax.xml.ws.Endpoint;

public class App {
    public static void main(String[] args) {
        System.setProperty("com.sun.xml.ws.fault.SOAPFaultBuilder.disableCaptureStackTrace",
                "false");
        String url = "http://localhost:8080/LaptopService";
        Endpoint.publish(url, new LaptopWebService());
        System.out.println("Done!");
    }
}
