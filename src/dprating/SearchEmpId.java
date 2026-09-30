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
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("select * from registration");  
           
            while(rs.next())
            {
                
                if(emp.equals(rs.getString(1)))
                {
                    count++;
                }
                else
                {
                   count=count; 
                }
                
            }           
            con.close();  
            
  }catch(Exception e){ System.out.println(e);}  
         
         return count;
       
    }    
}