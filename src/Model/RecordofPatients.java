package Model;
import java.sql.*;
public class RecordofPatients {
    private String query;
    private ResultSet rs;
    private Statement stmt;
    private ResultSet rs_c;
    private Statement stmt_c;
    private int amoRow;
    
    public String [][] getRecord(){
        Connection con = new Connection();
        java.sql.Connection connect = con.DatabaseConnection();
        String data[][] = null;
        try{
            stmt = connect.createStatement();
            query = "SELECT patient_record.ID_Patient, Name, Complain, medicines.Medicines_Name, Administration, Date from patient_record, medicines, medicine_record"
                    + " where patient_record.ID_Patient = medicine_record.ID_Patient AND medicines.ID_Medicine = medicine_record.ID_Medicine order by ID_Patient";
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
    
    public int AddRecord(String ID_Patient, String Name, String Complain, String Administration, String Date){
        amoRow = 0;
        Connection con = new Connection();
        java.sql.Connection connect = con.DatabaseConnection();
        try{
            stmt = connect.createStatement();
            query = "insert into patient_record (ID_Patient, Name, Complain, Administration, Date) "
                    + "values('"+ID_Patient+"','"+Name+"','"+Complain+"','"+Administration+"','"+Date+"')";
            stmt.executeUpdate(query);
            stmt.close();
            connect.close();
        }   
        catch(SQLException ex){
            System.out.println("Error : "+ex.getMessage());
        }
        return amoRow;
    }
    
    public int AddMed(String ID_Patient, String Medicine){
        amoRow = 0;
        Connection con = new Connection();
        java.sql.Connection connect = con.DatabaseConnection();
        try{
            stmt = connect.createStatement();
            query = "insert into medicine_record (ID_Patient, ID_Medicine) values('"+ID_Patient+"','"+Medicine+"')";
            stmt.executeUpdate(query);
            stmt.close();
            connect.close();
        }   
        catch(SQLException ex){
            System.out.println("Error : "+ex.getMessage());
        }
        return amoRow;
    }
    
    public String [][] getDataRecord(String ID){
        Connection con = new Connection();
        java.sql.Connection connect = con.DatabaseConnection();
        String data[][] = null;
        try{
            stmt = connect.createStatement();
            query = "SELECT patient_record.ID_Patient, Name, Complain, medicines.ID_Medicine, Administration, Date from patient_record, medicines, medicine_record"
                    + " where patient_record.ID_Patient = medicine_record.ID_Patient AND medicines.ID_Medicine = medicine_record.ID_Medicine AND patient_record.ID_Patient = '"+ID+"' ";
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
    
    public void EditRecord(String ID_Patient, String Name, String Complain, String Administration, String Date){
        Connection con = new Connection();
        java.sql.Connection connect = con.DatabaseConnection();
        try{
            stmt = connect.createStatement();
            query = "update patient_record set ID_Patient = '"+ID_Patient+"', Name = '"+Name+"', Complain = '"+Complain+"', "
                    + "Administration = '"+Administration+"', Date = '"+Date+"' where ID_Patient = '"+ID_Patient+"' ";
            stmt.executeUpdate(query);
            
            stmt.close();
            connect.close();
        }   
        catch(SQLException ex){
            System.out.println("Error : "+ex.getMessage());
        }
    }
    
    public void EditMed(String ID_Patient, String Medicine){
        Connection con = new Connection();
        java.sql.Connection connect = con.DatabaseConnection();
        try{
            stmt = connect.createStatement();
            query = "update medicine_record set ID_Medicine = '"+Medicine+"' where ID_Patient = '"+ID_Patient+"' ";
            stmt.executeUpdate(query);
            
            stmt.close();
            connect.close();
        }   
        catch(SQLException ex){
            System.out.println("Error : "+ex.getMessage());
        }
    }
    
    public void DeleteRecord(String ID){
        Connection con = new Connection();
        java.sql.Connection connect = con.DatabaseConnection();
        try{
            stmt = connect.createStatement();
            query = "DELETE FROM patient_record WHERE ID_Patient = '"+ID+"'";
            stmt.executeUpdate(query);
            
            stmt.close();
            connect.close();
        }   
        catch(SQLException ex){
            System.out.println("Error : "+ex.getMessage());
        }
    }
    
    public String [][] FindRecord(String Keyword){
        Connection con = new Connection();
        java.sql.Connection connect = con.DatabaseConnection();
        String data[][] = null;
        try{
            stmt = connect.createStatement();
            query = "select patient_record.ID_Patient, Name, Complain, medicines.Medicines_Name, Administration, Date from patient_record, medicines, medicine_record "
                    + "where (patient_record.ID_Patient LIKE '%"+Keyword+"%' or Name LIKE '%"+Keyword+"%' or Complain LIKE '%"+Keyword+"%' or medicines.Medicines_Name LIKE '%"+Keyword+"%' "
                    + "or Administration LIKE '%"+Keyword+"%' or Date LIKE '%"+Keyword+"%') AND patient_record.ID_Patient = medicine_record.ID_Patient AND medicines.ID_Medicine = medicine_record.ID_Medicine order by 'ID_Patient'";
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