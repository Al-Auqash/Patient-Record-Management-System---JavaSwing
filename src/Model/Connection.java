package Model;
import java.sql.*;
public class Connection {
    public java.sql.Connection connection = null;
    public java.sql.Connection DatabaseConnection() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql:///prms","root","");    
        }catch (ClassNotFoundException | SQLException e) {
            System.out.println("Connection Error : " + e.getMessage());
        }
        return connection;
    }
}