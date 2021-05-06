package Model;
import java.sql.*;
public class ListofMedicines {
    private String ID;
    private String Medicine;
    private String Status;
    private String query;
    private ResultSet rs;
    private Statement stmt;
    private ResultSet rs_c;
    private Statement stmt_c;
    private int amoRow;
    
    public String [][] getMedicine(){
        Connection con = new Connection();
        java.sql.Connection connect = con.DatabaseConnection();
        String data[][] = null;
        try{
            stmt = connect.createStatement();
            query = "SELECT medicines.ID_Medicine, Medicines_Name, Status, Name from medicines, admin_record, admin_data where "
                    + "medicines.ID_Medicine = admin_record.ID_Medicine AND admin_data.ID = admin_record.ID_Admin order by ID_Medicine";
            rs = stmt.executeQuery(query);
            ResultSetMetaData meta = rs.getMetaData();
            int amoColumn = meta.getColumnCount();
            data = new String[1000][amoColumn];
            int r = 0;
            while(rs.next()){
                for(int c=0; c<amoColumn; c++){
                    data[r][c] = rs.getString(c+1);
                }
                r++;
            }
            int amoRow = r;
            String [][] tmparray = data;
            data = new String[amoRow][amoColumn];
            for(r=0; r<amoRow; r++){
                for(int c=0; c<amoColumn; c++){
                    data[r][c]=tmparray[r][c];
                }
            }
            stmt.close();
            connect.close();
        }   
        catch(SQLException ex){
            System.out.println("Error : "+ex.getMessage());
        }
        return data;
    }
    
    public int AddMedicine(String ID, String Medicine, String Status){
        amoRow = 0;
        Connection con = new Connection();
        java.sql.Connection connect = con.DatabaseConnection();
        try{
            stmt = connect.createStatement();
            query = "insert into medicines (ID_Medicine, Medicines_Name, Status) values('"+ID+"','"+Medicine+"','"+Status+"')";
            stmt.executeUpdate(query);
            stmt_c = connect.createStatement();
            rs_c = stmt_c.executeQuery("SELECT COUNT(*) FROM medicines");
            while(rs_c.next()){
                amoRow = rs_c.getInt(1);
            }
            stmt.close();
            connect.close();
            stmt_c.close();
        }   
        catch(SQLException ex){
            System.out.println("Error : "+ex.getMessage());
        }
        return amoRow;
    }
    
    public int AddRecord(String ID, String Admin){
        amoRow = 0;
        Connection con = new Connection();
        java.sql.Connection connect = con.DatabaseConnection();
        try{
            stmt = connect.createStatement();
            query = "insert into admin_record (ID_Medicine, ID_Admin) values('"+ID+"','"+Admin+"')";
            stmt.executeUpdate(query);
            stmt.close();
            connect.close();
        }   
        catch(SQLException ex){
            System.out.println("Error : "+ex.getMessage());
        }
        return amoRow;
    }
    
    public String [][] getDataMedicine(String ID){
        Connection con = new Connection();
        java.sql.Connection connect = con.DatabaseConnection();
        String data[][] = null;
        try{
            stmt = connect.createStatement();
            query = "SELECT medicines.ID_Medicine, Medicines_Name, Status, Name from medicines, admin_record, admin_data where "
                    + "medicines.ID_Medicine = admin_record.ID_Medicine AND admin_data.ID = admin_record.ID_Admin AND medicines.ID_Medicine = '"+ID+"' ";
            rs = stmt.executeQuery(query);
            ResultSetMetaData meta = rs.getMetaData();
            int amoColumn = meta.getColumnCount();
            data = new String[1000][amoColumn];
            int r = 0;
            while(rs.next()){
                for(int c=0; c<amoColumn; c++){
                    data[r][c] = rs.getString(c+1);
                }
                r++;
            }
            int amoRow = r;
            String [][] tmparray = data;
            data = new String[amoRow][amoColumn];
            for(r=0; r<amoRow; r++){
                for(int c=0; c<amoColumn; c++){
                    data[r][c]=tmparray[r][c];
                }
            }
            stmt.close();
            connect.close();
        }   
        catch(SQLException ex){
            System.out.println("Error : "+ex.getMessage());
        }
        return data;
    }
    
    public void EditMedicine(String ID, String Medicine, String Status){
        Connection con = new Connection();
        java.sql.Connection connect = con.DatabaseConnection();
        try{
            stmt = connect.createStatement();
            query = "update medicines set ID_Medicine = '"+ID+"', Medicines_Name = '"+Medicine+"', Status = '"+Status+"' where ID_Medicine = '"+ID+"' ";
            stmt.executeUpdate(query);
            
            stmt.close();
            connect.close();
        }   
        catch(SQLException ex){
            System.out.println("Error : "+ex.getMessage());
        }
    }
    
    public void EditRecord(String ID, String Admin){
        Connection con = new Connection();
        java.sql.Connection connect = con.DatabaseConnection();
        try{
            stmt = connect.createStatement();
            query = "update admin_record set ID_Medicine = '"+ID+"', ID_Admin = '"+Admin+"' where ID_Medicine = '"+ID+"' ";
            stmt.executeUpdate(query);
            
            stmt.close();
            connect.close();
        }   
        catch(SQLException ex){
            System.out.println("Error : "+ex.getMessage());
        }
    }
    
    public void DeleteMedicine(String ID){
        Connection con = new Connection();
        java.sql.Connection connect = con.DatabaseConnection();
        try{
            stmt = connect.createStatement();
            query = "DELETE FROM medicines WHERE ID_Medicine = '"+ID+"'";
            stmt.executeUpdate(query);
            
            stmt.close();
            connect.close();
        }   
        catch(SQLException ex){
            System.out.println("Error : "+ex.getMessage());
        }
    }
    
    public String [][] FindMedicine(String Keyword){
        Connection con = new Connection();
        java.sql.Connection connect = con.DatabaseConnection();
        String data[][] = null;
        try{
            stmt = connect.createStatement();
            query = "select medicines.ID_Medicine, Medicines_Name, Status, Name from medicines, admin_data, admin_record where "
                    + "(medicines.ID_Medicine LIKE '%"+Keyword+"%' or Medicines_Name LIKE '%"+Keyword+"%' or Status LIKE '"+Keyword+"%' "
                    + "or Name LIKE '%"+Keyword+"%') AND medicines.ID_Medicine = admin_record.ID_Medicine AND admin_data.ID = admin_record.ID_Admin "
                    + "order by 'ID_Medicine'";
            rs = stmt.executeQuery(query);
            ResultSetMetaData meta = rs.getMetaData();
            int amoColumn = meta.getColumnCount();
            data = new String[1000][amoColumn];
            int r = 0;
            while(rs.next()){
                for(int c=0; c<amoColumn; c++){
                    data[r][c] = rs.getString(c+1);
                }
                r++;
            }
            int amoRow = r;
            String [][] tmparray = data;
            data = new String[amoRow][amoColumn];
            for(r=0; r<amoRow; r++){
                for(int c=0; c<amoColumn; c++){
                    data[r][c]=tmparray[r][c];
                }
            }
            stmt.close();
            connect.close();
        }   
        catch(SQLException ex){
            System.out.println("Error : "+ex.getMessage());
        }
        return data;
    }
}
