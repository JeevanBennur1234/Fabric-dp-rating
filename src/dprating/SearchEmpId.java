package dprating;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class SearchEmpId {
    
    public int search(String emp)
    {
         int count=0;
         try
         {   
            Connection con=DBConnection.getConnection();
            if (con == null) return 0;
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("select * from registration");  
           
            while(rs.next())
            {
                String dbEmp = rs.getString(1);
                if(dbEmp != null && emp != null && emp.trim().equalsIgnoreCase(dbEmp.trim()))
                {
                    count++;
                }
            }           
            rs.close();
            stmt.close();
            con.close();  
            
        }catch(Exception e){ System.out.println(e);}  
         
         return count;
    }    
}