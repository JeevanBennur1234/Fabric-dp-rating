package dprating;
import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.sql.*;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class UserRegistration  extends javax.swing.JFrame {
private static UserRegistration obj=null;
     String empid11,password11,confirmpass11;
     int f=1;
    public UserRegistration () {
        initComponents();
        
         Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
                    int windowWidth = 400;
                    int windowHeight = 400;
                    this.setBounds(center.x - windowWidth / 2, center.y - windowHeight / 2, windowWidth,
                    windowHeight);
                    this.setResizable(false);
                    this.setTitle("Create new user");
                     empid11=empid.getText();
                        password11=password.getText();
                    confirmpass11=confirmpass.getText();
    }
public static UserRegistration getobj()
{
    if(obj==null)
    {
        obj=new UserRegistration();
    }return obj;
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        empid = new javax.swing.JTextField();
        button1 = new java.awt.Button();
        cancle = new java.awt.Button();
        jLabel49 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        confirmpass = new javax.swing.JPasswordField();
        password = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("Password:");

        jLabel2.setText("Confirm Password:");

        jLabel4.setText("Employee ID:");

        empid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        button1.setLabel("Save");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

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

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(153, 153, 153));
        jLabel49.setText("CREATE A NEW ACCOUNT");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/Entypo_e700(0)_64.png"))); // NOI18N
        jLabel5.setText(" ");

        confirmpass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        password.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setText("*(Enter strong password;ex.John@1125)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(empid, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(confirmpass, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel49))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(cancle, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 47, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel49)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(empid, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(confirmpass, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
    register(empid.getText(),password.getText(),confirmpass.getText(),f);  
     empid.setText("");
     password.setText("");
     confirmpass.setText("");
   this.dispose();
        
    }//GEN-LAST:event_button1ActionPerformed
public void register(String empid1,String password1,String confirmpass1,int flag )
{
    try
    { 
          SearchEmpId sc=new SearchEmpId();
         if(flag!=0)
         {
                 empid1=empid.getText();
                 password1=this.password.getText();
                confirmpass1=this.confirmpass.getText();
         }
          int count=sc.search(empid1);
         JFrame frame = new JFrame("JOptionPane showMessageDialog example");     
              
       if(empid1.equals("")||password1.equals("")||confirmpass1.equals(""))
       {
          JOptionPane.showMessageDialog(frame,
        "All fields are mandatory",
        "Registration problem",
        JOptionPane.WARNING_MESSAGE);
        
       }
        else if(empid1.length()<4  || empid1.length()>10)
        {
              JOptionPane.showMessageDialog(frame,
        "Employee id must be less than 10 and greater than 4",
        "Registration problem",
        JOptionPane.WARNING_MESSAGE);
        }
       else if(!Pattern.matches("^[a-zA-Z0-9]*+$", empid1))
       {
             JOptionPane.showMessageDialog(frame,
        "please enter valid employee id",
        "Registration problem",
        JOptionPane.WARNING_MESSAGE);
       }
       else if((password1.length())<8 || (password1.length()>15))
       {
             JOptionPane.showMessageDialog(frame,
        "password must be less than 15 and greater than 8",
        "Registration problem",
        JOptionPane.WARNING_MESSAGE);
       }
       else if(!Pattern.matches("^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$", password1))
       {
           System.out.println("Please enter strong password");
              JOptionPane.showMessageDialog(frame,
        "Enter strong password: '" + password1 + "'.",
        "registration problem",
        JOptionPane.WARNING_MESSAGE);
       }
        else if(!password1.equals(confirmpass1))
       {
              JOptionPane.showMessageDialog(frame,
        "password must same as above",
        "Registration problem",
        JOptionPane.WARNING_MESSAGE);
        }
       
       
       else if(count>=1)
        {
         JOptionPane.showMessageDialog(frame,
        "User already present",
        "Registration problem",
        JOptionPane.INFORMATION_MESSAGE);
        }
       
        else
        {             
            Connection con=DBConnection.getConnection();
              
            PreparedStatement ps=con.prepareStatement(  
            "insert into registration values(?,?,?)");  
                        
            ps.setString(1,empid1);  
            ps.setString(2,password1);
            ps.setString(3,confirmpass1);  
         
            int i=ps.executeUpdate();  
            

         JOptionPane.showMessageDialog(frame,
        "Record inserted sucessfully",
        "registration Sucessful",
        JOptionPane.INFORMATION_MESSAGE);
              
        empid.setText("");
        password.setText("");
        confirmpass.setText("");
            con.close();  
             
    } 
 }catch (Exception e) {e.printStackTrace();}
}
    
    private void cancleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancleActionPerformed
            this.dispose();
            empid.setText("");
            password.setText("");
            confirmpass.setText("");
    }//GEN-LAST:event_cancleActionPerformed

    private void cancleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancleMouseClicked
        HomePage.jLabel17.setForeground(Color.BLUE);
    }//GEN-LAST:event_cancleMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        HomePage.jLabel17.setForeground(Color.BLUE);
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(UserRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserRegistration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    public java.awt.Button cancle;
    private javax.swing.JPasswordField confirmpass;
    private javax.swing.JTextField empid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JPasswordField password;
    // End of variables declaration//GEN-END:variables
}
