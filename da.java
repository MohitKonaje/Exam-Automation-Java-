/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examautomation;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author Mk3s
 */
public class da extends DrawArea {
   Connection conn=new dbconnection().connect();
   int click,tx,ty;
    final String qnn,idn;
    JButton clearBtn,blackBtn, blueBtn,greenBtn,redBtn,whitebtn,addtext,lineBtn,circleBtn,submitBtn;
    DrawArea drawArea = new DrawArea();
    JFrame frame;
     public da(String questionnumber,String id){
         
        qnn=questionnumber;
        idn=id;
      
         
     
     
         
         
          
          
    
         
             
             
             
     frame = new JFrame("Draw Diagram");
        
        Container content = frame.getContentPane();
                content.setLayout(new BorderLayout());
                content.add(drawArea, BorderLayout.CENTER);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                JPanel controls = new JPanel();
               clearBtn = new JButton("Clear");
               clearBtn.addActionListener (actionListener);
               blackBtn = new JButton("Black");
               blackBtn.addActionListener (actionListener);
               blueBtn = new JButton("Blue");
               blueBtn.addActionListener (actionListener);
               greenBtn = new JButton("Green");
               greenBtn.addActionListener (actionListener);
               redBtn = new JButton("Red");
               redBtn.addActionListener (actionListener);
               whitebtn = new JButton("Eraser");
               whitebtn.addActionListener (actionListener);
               addtext = new JButton("Add Text");
               addtext.addActionListener (actionListener);
               lineBtn = new JButton("Draw Line");
               lineBtn.addActionListener (actionListener);
               circleBtn = new JButton("Draw circle");
               circleBtn.addActionListener (actionListener);
               submitBtn = new JButton("Submit Diagram");
               submitBtn.addActionListener (actionListener);
               
               
               controls.add(clearBtn);
               controls.add(greenBtn);
               controls.add(blackBtn);
               controls.add(blueBtn);
               controls.add(redBtn);
               controls.add(whitebtn);
               controls.add(addtext);
               controls.add(lineBtn);
               controls.add(circleBtn);
               controls.add(submitBtn);
               
               content.add(controls,BorderLayout.NORTH);
               frame.setSize(800,600);
               frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
               frame.setVisible(true);
             
              
     }
              
               
         
    
    
    
    ActionListener actionListener = new ActionListener() {
        
        
     @Override
     
     public void actionPerformed(ActionEvent e ) {
         
         if(e.getSource()== clearBtn){
         drawArea.clear();
         }
         else if(e.getSource()== blackBtn)
         {
             drawArea.black();
         }
         else if(e.getSource()== blueBtn)
         {
         drawArea.blue();
         }
         else if(e.getSource()== greenBtn)
         {
         drawArea.green();
         }
         else if(e.getSource()== whitebtn)
         {
             drawArea.white();
         }
         else if(e.getSource() == addtext)
         {  
         
         drawArea.text();
         }
         else if(e.getSource() == lineBtn)
         {  
         click = click+1;
          if(click==3)
         {
         click=0;
         }
         drawArea.line(click);
         }
         else if(e.getSource() == circleBtn)
         {  
         click = click+1;
          if(click==3)
         {
         click=0;
         }
         drawArea.circle(click);
         }
         else if(e.getSource() == redBtn)
         {
         drawArea.red();
         }
          else if(e.getSource() == submitBtn)
         {
           try{ 
             
               
         save();
         
         
           }
           catch(Exception ioe){
               JOptionPane.showMessageDialog(null, "Submit Text answer first");
               
           }}
             
             
             
             
     }  
             
             
             
             
           
     
    };
    
    

       public void save() throws IOException{
           
                     
          // JOptionPane.showMessageDialog(null,qnn);
           
           
           
           
      Container pane = frame.getContentPane();
BufferedImage img = new BufferedImage(pane.getWidth(), pane.getHeight(), BufferedImage.TYPE_INT_RGB);
Graphics2D g2d = img.createGraphics();
pane.printAll(g2d);
g2d.dispose();



try {
    ImageIO.write(img, "png", new File("C:\\images/save.png"));
    } catch (IOException ex) {
    ex.printStackTrace();
}
try{
    File imgfile = new File("C:\\temp/save.png");
    FileInputStream fin = new FileInputStream(imgfile);
    
    PreparedStatement pre =
       conn.prepareStatement("UPDATE diagram SET "+qnn+" = ? WHERE id = ?");
        pre.setBinaryStream(1,(InputStream)fin,(int)imgfile.length());
        pre.setString(2,idn);
        pre.executeUpdate();
}catch (Exception e1){
JOptionPane.showMessageDialog(null,"Submit Text answer first");
}
 }
       
       
       
       
       
       
       
       
       
       
       
       
   
 
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
     
    // draw painting
   
     
}
