package dprating;
import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ForgetPassword extends javax.swing.JFrame {
private static ForgetPassword obj=null;
    
    private ForgetPassword() {
        initComponents();
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
                    int windowWidth = 400;
                    int windowHeight = 350;
                    this.setBounds(center.x - windowWidth / 2, center.y - windowHeight / 2, windowWidth,
                    windowHeight);
                    this.setResizable(false);
                    this.setTitle("Forget password");
    }
public static ForgetPassword getobj()
{
    if(obj==null)
    {
        obj=new ForgetPassword();
    }return obj;
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pass = new javax.swing.JTextField();
        cancle = new java.awt.Button();
        button1 = new java.awt.Button();
        empid = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setForeground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel4.setText("Employee ID:");

        jLabel3.setText("Your Password:");

        pass.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        pass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pass.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        pass.setEnabled(false);
        pass.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        pass.setSelectionColor(new java.awt.Color(0, 0, 0));

        cancle.setLabel("Cancel");
        cancle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancleMouseClicked(evt);
            }
        });
        cancle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancleActionPerformed(evt);
            }
        });

        button1.setLabel("OK");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        empid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(153, 153, 153));
        jLabel49.setText("FORGOTTEN PASSWORD?");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/octicons_f02c(1)_64.png"))); // NOI18N
        jLabel1.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel49)
                .addGap(170, 170, 170))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(empid, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(cancle, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(empid, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cancle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(100, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
          
         forgetPass();
       
// TODO add your handling code here:
    }//GEN-LAST:event_button1ActionPerformed
    public void forgetPass()
    {
        
    try
       { 
            JFrame frame=new JFrame();
            SearchEmpId sc=new SearchEmpId();
            String Empid=empid.getText().trim();
            int count=sc.search(Empid);

            if(Empid.equals(""))
            {
                JOptionPane.showMessageDialog(frame,
                "please enter employee id",
                "Retrival problem",
                JOptionPane.WARNING_MESSAGE);
                
            }
            else if(count<1)
            {
                JOptionPane.showMessageDialog(frame,
                "Employee id is invalid",
                "Retrival problem",
                 JOptionPane.WARNING_MESSAGE);
                  empid.setText("");
                 pass.setText("");
        
            }
            else
                {
                    Connection con = DBConnection.getConnection();
                    if (con != null) {
                        Statement stmt = con.createStatement();  
                        ResultSet rs = stmt.executeQuery("select * from registration");  
           
                        while (rs.next()) {
                            String dbEmp = rs.getString(1);
                            if (dbEmp != null && Empid != null && Empid.trim().equalsIgnoreCase(dbEmp.trim())) {
                                pass.setText(rs.getString(2));
                            }       
                        }
                        rs.close();
                        stmt.close();
                        con.close();            
                    }
                }
        }catch(Exception e){ System.out.println(e);}
    }
    private void cancleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancleActionPerformed
        this.dispose();
        empid.setText("");
        pass.setText("");
    }//GEN-LAST:event_cancleActionPerformed

    private void cancleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancleMouseClicked
      HomePage.jLabel3.setForeground(Color.BLUE);
    }//GEN-LAST:event_cancleMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        HomePage.jLabel3.setForeground(Color.BLUE);
    }//GEN-LAST:event_formWindowClosed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ForgetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForgetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForgetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForgetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForgetPassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    public java.awt.Button cancle;
    private javax.swing.JTextField empid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JTextField pass;
    // End of variables declaration//GEN-END:variables
}
