package Model;
import java.sql.*;
public class Account {
    private String query;
    private ResultSet rs;
    private Statement stmt;
    public static int IDUser;
    
    public static void setIDUser(int ID){
        Account.IDUser = ID;
    }
    
    public static int getIDUser(){
        return IDUser;
    }
    
    public int CheckUser(String username, String password){
    Connection con = new Connection();
    java.sql.Connection connect = con.DatabaseConnection();
    int data = 0;
        try {
            stmt = connect.createStatement();
            query = "SELECT COUNT(ID) from admin_data where username= '"+username+"' and password = '"+password+"' ";
            rs = stmt.executeQuery(query);
            while(rs.next()){
                data = rs.getInt(1);
            }
            stmt.close();
            connect.close();
        } catch (SQLException ex) {
            System.out.println("Error : "+ex.getMessage());
        }
    return data;
    }
    
    public int GetIdUser(String username, String password){
    Connection con = new Connection();
    java.sql.Connection connect = con.DatabaseConnection();
    int data = 0;
        try {
            stmt = connect.createStatement();
            query = "SELECT ID from admin_data where username = '"+username+"' and password = '"+password+"' ";
            rs = stmt.executeQuery(query);
            while(rs.next()){
                data = rs.getInt(1);
            }
            stmt.close();
            connect.close();
        } catch (SQLException ex) {
            System.out.println("Error : "+ex.getMessage());
        }
    return data;
    }
    
    public String [][] getProfile(int ID){
    Connection con = new Connection();
    java.sql.Connection connect = con.DatabaseConnection();
    String data [][] = null;
        try {
            stmt = connect.createStatement();
            query = "SELECT ID, name, Profession, email from admin_data where ID = "+ID;
            rs = stmt.executeQuery(query);
            ResultSetMetaData meta = rs.getMetaData();
            int sumColumn = meta.getColumnCount();
            data = new String[1000][sumColumn];
            int r = 0;
            while (rs.next()) {
                for (int c = 0; c < sumColumn; c++) {
                    data[r][c] = rs.getString(c+1);
                }
                r++;
            }
            int sumRow = r;
            String [][] tmparray = data;
            for (r = 0; r < sumRow; r++) {
                for (int c = 0; c < sumRow; c++) {
                    data[r][c] = tmparray[r][c];
                }
            }
            stmt.close();
            connect.close();
        }catch (Exception ex) {
            System.out.println("Error : "+ex.getMessage());
        }
    return data;
    }
}
