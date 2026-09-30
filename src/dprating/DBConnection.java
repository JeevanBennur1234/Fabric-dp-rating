package dprating;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {
    private static boolean fallbackInitialized = false;

    public static Connection getConnection() throws Exception {
        Connection con = null;

        // 1. Attempt connection to primary Oracle Database
        try {
            String driver   = System.getProperty("db.driver", "oracle.jdbc.driver.OracleDriver");
            String url      = System.getProperty("db.url", "jdbc:oracle:thin:@localhost:1521:xe");
            String username = System.getProperty("db.user", "system");
            String password = System.getProperty("db.password", "dkte");

            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to Oracle Database (" + url + ")");
            return con;
        } catch (Throwable ex) {
            System.out.println("Oracle Database connection not available: " + ex.getMessage());
            System.out.println("Falling back to local embedded database...");
        }

        // 2. Fallback to local embedded database (H2 in Oracle compatibility mode)
        try {
            String h2Driver = "org.h2.Driver";
            String h2Url    = "jdbc:h2:./database/dprating;MODE=Oracle;AUTO_SERVER=TRUE;DB_CLOSE_DELAY=-1";
            Class.forName(h2Driver);
            con = DriverManager.getConnection(h2Url, "sa", "");
            initFallbackDatabase(con);
            System.out.println("Connected to embedded database (Oracle mode)");
        } catch (Throwable h2Ex) {
            System.err.println("Fallback database connection failed: " + h2Ex.getMessage());
            h2Ex.printStackTrace();
        }

        return con;
    }

    private static synchronized void initFallbackDatabase(Connection con) {
        if (fallbackInitialized || con == null) {
            return;
        }
        try {
            Statement stmt = con.createStatement();

            // 1. registration table
            stmt.execute("CREATE TABLE IF NOT EXISTS registration (" +
                         "EMPLOYEEID VARCHAR2(50) PRIMARY KEY, " +
                         "PASSWORD VARCHAR2(50) NOT NULL, " +
                         "CONFIRMPASS VARCHAR2(50) NOT NULL)");

            // 2. testinginformation1 table
            stmt.execute("CREATE TABLE IF NOT EXISTS testinginformation1 (" +
                         "LOT_NUM NUMBER PRIMARY KEY, " +
                         "TESTERNAME VARCHAR2(50) NOT NULL, " +
                         "FABRICNAME VARCHAR2(50) NOT NULL, " +
                         "EPI NUMBER NOT NULL, " +
                         "PPI NUMBER NOT NULL, " +
                         "READ_COUNT NUMBER NOT NULL, " +
                         "VIEW1 VARCHAR2(50) NOT NULL, " +
                         "FINISHTYPE VARCHAR2(100) NOT NULL, " +
                         "VARPCOUNT NUMBER NOT NULL, " +
                         "WEFTCOUNT NUMBER NOT NULL, " +
                         "CURRUNTDATE VARCHAR2(30))");

            // 3. result table
            stmt.execute("CREATE TABLE IF NOT EXISTS result (" +
                         "LOT_NUM NUMBER PRIMARY KEY, " +
                         "CATEGORY FLOAT NOT NULL)");

            // Seed default user account: ramesh12 / Arn@157744974
            ResultSet rsCheck = stmt.executeQuery("SELECT count(*) FROM registration WHERE EMPLOYEEID='ramesh12'");
            if (rsCheck.next() && rsCheck.getInt(1) == 0) {
                stmt.execute("INSERT INTO registration (EMPLOYEEID, PASSWORD, CONFIRMPASS) " +
                             "VALUES ('ramesh12', 'Arn@157744974', 'Arn@157744974')");
                System.out.println("Initialized pre-seeded user 'ramesh12' in registration table.");
            }
            rsCheck.close();
            stmt.close();

            fallbackInitialized = true;
        } catch (Exception e) {
            System.err.println("Warning: Could not initialize fallback database tables: " + e.getMessage());
        }
    }
}
