package lab6;

import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.ClassNamesResourceConfig;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import lab6.WebService.LaptopRestService;
import org.glassfish.grizzly.http.server.HttpServer;

import java.net.URI;

public class App {
    public static void main(String[] args) {
        URI uri_base = URI.create("http://localhost:8080/");
        HttpServer httpServer = null;
        try{
            ResourceConfig resourceConfig = new PackagesResourceConfig(LaptopRestService.class.getPackage().getName());
            httpServer = GrizzlyServerFactory.createHttpServer(uri_base, resourceConfig);
            httpServer.start();
            System.in.read();
            httpServer.stop();
        }
        catch(Exception ex){
            ex.printStackTrace();
            if(httpServer != null){
                httpServer.stop();
            }
        }
    }
}