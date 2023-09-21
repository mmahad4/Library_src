//Author:Madhangi_Mahadevan_660416598
//Establishes the database driver and the connections 
import java.sql.*;

public class DB {
    public static void main(String[] args) {
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement(); //displays the details to confirm the successful establishment
            System.out.println("Database product name: " + conn.getMetaData().getDatabaseProductName());
            System.out.println("Database product version: " + conn.getMetaData().getDatabaseProductVersion());
            System.out.println("Driver name: " + conn.getMetaData().getDriverName());
            System.out.println("Driver version: " + conn.getMetaData().getDriverVersion());
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String url = "jdbc:ucanaccess://C://Users//Madhangi//OneDrive//SpringScheduler//EAD//final//Library_src//Library_src//LibraryGenius.accdb";
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}

//Author:Madhangi_Mahadevan_660416598



