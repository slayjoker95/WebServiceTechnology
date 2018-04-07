package lab5;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LaptopConnection {
    private static String url = "jdbc:mysql://localhost:3306/web_services";
    private static String user = "chris";
    private static String pass = "qwerty";

    public static Connection getConnection(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(url, user, pass);
        }
        catch (SQLException e){
            Logger.getLogger(LaptopConnection.class.getName()).log(Level.SEVERE, null, e);
        }
        return connection;
    }
}
