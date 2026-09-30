package dprating;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() throws Exception {
        Connection con = null;
        try {
            String driver   = "oracle.jdbc.driver.OracleDriver";
            String url      = "jdbc:oracle:thin:@localhost:1521:xe";
            String username = "system";
            String password = "dkte";
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            System.out.println("connected");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            System.out.println("function over");
        }
        return con;
    }
}
