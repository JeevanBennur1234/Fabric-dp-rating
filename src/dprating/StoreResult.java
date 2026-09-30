package dprating;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StoreResult {
    int lot;
    float st;
    String tester, fabric, weave, finish, dateVal;

    public void setstatus(float category) {
        st = category;
    }

    public void setlot(int lotnum) {
        lot = lotnum;
    }

    public void setDetails(String testerName, String fabricName, String weaveType, String finishType, String date) {
        tester  = testerName;
        fabric  = fabricName;
        weave   = weaveType;
        finish  = finishType;
        dateVal = date;
    }

    public void InsertRseult() {
        try {
            Connection con = DBConnection.getConnection();
            if (con != null) {
                PreparedStatement ps = con.prepareStatement("insert into result values(?,?)");
                ps.setInt(1, lot);
                ps.setFloat(2, st);
                ps.executeUpdate();
                con.close();
            }
        } catch (Exception ex) {
            System.out.println("Oracle unavailable, saving locally: " + ex);
        }

        LocalStorage.saveRecord(
            String.valueOf(lot),
            tester  != null ? tester  : "",
            fabric  != null ? fabric  : "",
            weave   != null ? weave   : "",
            finish  != null ? finish  : "",
            st,
            dateVal != null ? dateVal : new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss").format(new Date())
        );
    }
}
