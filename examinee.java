/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examautomation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import javax.swing.*;
/**
 *
 * @author Mk3s
 */
public class examinee extends javax.swing.JFrame {
    Connection conn=new dbconnection().connect();
   
    public String id,name,questionnumber,answer;
    public String q1,q2,q3,q4,q5,q6,q7;
    public String a1,a2,a3;
     Object qselect;
     Object aselect; 
    public examinee(String n){
        
      name=n;
        id=n;
      
    initComponents();
    }

    examinee(Object object, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      
    }
 @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    public void initComponents() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Examinee-Student UI");
        //set name 
        
        
        
        
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        drawbutton = new javax.swing.JButton();
        //timer 
        
        
        
            
        //graphcode
        
        
      
        
        
        

        jComboBox2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Question 1 (any 2)", "Question 2 (any 2)", "Question 3 (any 2)", "Question 4 (any 2)", "Question 5 (any 2)", "Question 6 (any 2)", "Question 7 (any 3)" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jComboBox3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Answer A", "Answer B", "Answer C", "Answer D", "Answer E", "Answer F" }));
        jComboBox3.setToolTipText("");
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
          try{
         String sql="select Name from record where id=?";
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setString(1,name);
          ResultSet rs = ps.executeQuery();
           if(rs.next()){
               //name=rs.getString(1);
            jLabel2.setText("Student id: "+name);    
           }
           else{
           jLabel2.setText("name");
           }
        }catch(Exception e){}
        

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Subject");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        
    ActionListener al = new ActionListener(){
        public void actionPerformed(ActionEvent ae){
        LocalTime time = LocalTime.now();
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();
        
        jLabel4.setText(String.valueOf(hour)+":"+String.valueOf(minute)+":"+String.valueOf(second));
        }
};          new javax.swing.Timer(1000, al).start();
        
        //countdown
        
        
       /* ActionListener al = new ActionListener(){
        long x = TOTAL_TIME - 1000;
        public void actionPerformed(ActionEvent ae){
        jLabel4.setText(sdf.format(new Date(x)));
        x -= 1000;
        }
        };
        new javax.swing.Timer(1000, al).start();
        */
                
       

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Submit Answers");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
            
        });
        
        
        //draw dutton
        drawbutton.setText("Draw Diagram");
        drawbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drawbuttonActionPerformed(evt);
            }
        });
        
        
        
        
         javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(409, 409, 409)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(drawbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(70, 70, 70)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(60, 60, 60)
                                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 934, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 13, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(430, 430, 430)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(drawbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(144, 144, 144)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                
     public void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {  
        qselect=jComboBox2.getSelectedItem();
        
        
         
    }                                   

    public void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {
        repaint();
           qselect=jComboBox2.getSelectedItem();
         aselect=jComboBox3.getSelectedItem();
        //validation
         if(qselect=="Question 1 (any 2)" || qselect=="Question 2 (any 2)" || qselect=="Question 3 (any 2)" || qselect=="Question 4 (any 2)"
                 || qselect=="Question 5 (any 2)" || qselect=="Question 6 (any 2)"){
        if(aselect=="Answer E" || aselect=="Answer F"){
             JOptionPane.showMessageDialog(null, "Invalid Selection");
             jComboBox3.setSelectedItem("Answer A");
             aselect="Answer A";
             
             }
        }
         //option counter
          if(qselect=="Question 1 (any 2)"){
          if (toptions[0]>2){
                JOptionPane.showMessageDialog(null, "you have attempted all options in this question");
                }}
         else if(qselect=="Question 2 (any 2)"){
          if (toptions[1]>2){
                JOptionPane.showMessageDialog(null, "you have attempted all options in this question");
                }}
          else if(qselect=="Question 3 (any 2)"){
          if (toptions[2]>2){
                JOptionPane.showMessageDialog(null, "you have attempted all options in this question");
                }}
          else if(qselect=="Question 4 (any 2)"){
          if (toptions[3]>2){
                JOptionPane.showMessageDialog(null, "you have attempted all options in this question");
                }}
          else if(qselect=="Question 5 (any 2)"){
          if (toptions[4]>2){
                JOptionPane.showMessageDialog(null, "you have attempted all options in this question");
                }}
          else if(qselect=="Question 6 (any 2)"){
          if (toptions[5]>2){
                JOptionPane.showMessageDialog(null, "you have attempted all options in this question");
                }}
          else if(qselect=="Question 7 (any 3)"){
          if (toptions[6]>3){
                JOptionPane.showMessageDialog(null, "you have attempted all options in this question");
                }}
          
        // TODO add your handling code here:
    }                                          

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
      

         
         
         
        
 
           
         
         
         //q1
         questionnumber="q1a1"; //default
         if(qselect=="Question 1 (any 2)"){
             if(aselect=="Answer A"){
                questionnumber="q1a1";
                
                toptions[0]++;
                 
         }      else if(aselect=="Answer B"){
                questionnumber="q1a2";
                toptions[0]++;
         }      else if(aselect=="Answer C"){
                questionnumber="q1a3";
                toptions[0]++;
        
         }      else if(aselect=="Answer D"){
                questionnumber="q1a4";
                toptions[0]++;
         }
            
         }
         
         
         if(qselect=="Question 2 (any 2)"){
             if(aselect=="Answer A"){
                questionnumber="q2a1";
                toptions[1]++;
         }      else if(aselect=="Answer B"){
                questionnumber="q2a2";
                toptions[1]++;
         }      else if(aselect=="Answer C"){
                questionnumber="q2a3";
                toptions[1]++;
         }      else if(aselect=="Answer D"){
                questionnumber="q2a4";
                toptions[1]++;
         }
         }
         
         if(qselect=="Question 3 (any 2)"){
             if(aselect=="Answer A"){
                questionnumber="q3a1";
                toptions[2]++;
         }      else if(aselect=="Answer B"){
                questionnumber="q3a2";
                toptions[2]++;
         }      else if(aselect=="Answer C"){
                questionnumber="q3a3";
                toptions[2]++;
         }      else if(aselect=="Answer D"){
                questionnumber="q3a4";
                toptions[2]++;
         }
         }
         
         if(qselect=="Question 4 (any 2)"){
             if(aselect=="Answer A"){
                questionnumber="q4a1";
                toptions[3]++;
         }      else if(aselect=="Answer B"){
                   questionnumber="q4a2";
                   toptions[3]++;
         }      else if(aselect=="Answer C"){
                questionnumber="q4a3";
                toptions[3]++;
         }      else if(aselect=="Answer D"){
                questionnumber="q4a4";
                toptions[3]++;
         }
         }
         
         if(qselect=="Question 5 (any 2)"){
             if(aselect=="Answer A"){
                questionnumber="q5a1";
                toptions[4]++;
         }      else if(aselect=="Answer B"){
                questionnumber="q5a2";
                toptions[4]++;
         }      else if(aselect=="Answer C"){
                questionnumber="q5a3";
                toptions[4]++;
         }      else if(aselect=="Answer D"){
                questionnumber="q5a4";
                toptions[4]++;
         }
         }
         
         if(qselect=="Question 6 (any 2)"){
             if(aselect=="Answer A"){
                questionnumber="q6a1";
                toptions[5]++;
         }      else if(aselect=="Answer B"){
                questionnumber="q6a2";
                toptions[5]++;
         }      else if(aselect=="Answer C"){
                questionnumber="q6a3";
                toptions[5]++;
         }      else if(aselect=="Answer D"){
                questionnumber="q6a4";
                toptions[5]++;
         }
         }
         
         if(qselect=="Question 7 (any 3)"){
             if(aselect=="Answer A"){
                questionnumber="q7a1";
                toptions[6]++;
         }      else if(aselect=="Answer B"){
                questionnumber="q7a2";
                toptions[6]++;
         }      else if(aselect=="Answer C"){
                questionnumber="q7a3";
                toptions[6]++;
         }      else if(aselect=="Answer D"){
                questionnumber="q7a4";
                toptions[6]++;
         }      else if(aselect=="Answer E"){
                questionnumber="q7a5";
                toptions[6]++;
         }      else if(aselect=="Answer F"){
                questionnumber="q7a6";
                toptions[6]++;
         }
         }
         
         answer=jTextArea1.getText();
         try{
         String ansadd="UPDATE answers SET "+questionnumber+" =? WHERE id=?";
         PreparedStatement aps = conn.prepareStatement(ansadd);
         aps.setString(1,answer);
         aps.setString(2,id);
         int rs = aps.executeUpdate();
         if(rs!=0){
         JOptionPane.showMessageDialog(null, "Answer Uploaded");
         jTextArea1.setText("");
         }
         else{
         JOptionPane.showMessageDialog(null, "not uploaded");
         }
        // TODO add your handling code here:
    }catch(HeadlessException | SQLException e){
    JOptionPane.showMessageDialog(null,e);
    }
    }
    
     public void drawbuttonActionPerformed(java.awt.event.ActionEvent evt){
     da e = new da(questionnumber,id);
     e.setVisible(true);
        // TODO add your handling code here:
    }   

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
            java.util.logging.Logger.getLogger(learn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(learn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(learn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(learn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new learn().setVisible(true);
               
            }
        });
    }

    // Variables declaration - do not modify   
    
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton drawbutton;
      private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
     int [] toptions={1,1,1,1,1,1,1};
     
    
     
   // final long TOTAL_TIME = 100;
    //final java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("hh : mm : ss");
    DrawArea drawArea = new DrawArea();
    private javax.swing.JLabel jLabel4 = new JLabel();
    // End of variables declaration   
    
  
}
   
