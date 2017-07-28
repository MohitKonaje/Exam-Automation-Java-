/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examautomation;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JOptionPane;


/**
 *
 * @author Mk3s
 */
public class DrawArea extends JComponent{
     public BufferedImage paintImage;
    public int currentx,currenty,oldx,oldy,tx,ty;
       public Image image;
    public Graphics2D g2;
      public DrawArea(){
          
          setDoubleBuffered(false);

          addMouseListener(new MouseAdapter(){

             

               
            
            public void mousePressed(MouseEvent e) {
               oldx = e.getX();
               oldy = e.getY();
               
            }
            
        });
        
        addMouseMotionListener(new MouseAdapter(){
                    

            
            public void mouseDragged(MouseEvent e){
               currentx = e.getX();
               currenty = e.getY();
            
               if(g2 != null)
               {
                   g2.drawLine(oldx, oldy, currentx, currenty);
                   repaint();
                   oldx = currentx;
                   oldy = currenty;
                   
               }
            }
        });
        
        }
        
        public void paintComponent(Graphics g){
    if(image == null)
    {
        image = createImage(getSize().width,getSize().height);
        g2 = (Graphics2D) image.getGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        clear();
        }
    g.drawImage(image,0,0, null);
   
    }
    public void clear(){
    g2.setPaint(Color.white);
    g2.fillRect(0, 0, getSize().width, getSize().height);
    g2.setPaint(Color.black);
    repaint();
    }
    public void red(){
    g2.setPaint(Color.red);
    }
    public void blue(){
    g2.setPaint(Color.blue);
    }
    public void green(){
    g2.setPaint(Color.green);
    }
    public void white(){
    g2.setPaint(Color.white);
    }
    public void text(){
       String text= JOptionPane.showInputDialog(null,"Enter text");
        g2.drawString(text, oldx, oldy);
    }
    
    public void line( int click){
        
    if(click ==1){
    tx=currentx;
    ty=currenty;
    }
    else if(click ==2)
    {g2.drawLine(tx,ty,currentx,currenty);}
    //OptionPane.showMessageDialog(null,"click:" +click);
     if(click==2) 
     {
     click=0;}
    }
    
    public void circle( int click){
        
    if(click ==1){
    tx=currentx;
    ty=currenty;
    }
    else if(click ==2)
    {g2.drawOval(currentx,currenty,100,100);}
    //OptionPane.showMessageDialog(null,"click:" +click);
     if(click==2) 
     {
     click=0;}
    }
    public void black(){
    g2.setPaint(Color.black);
    }

    public void load() throws IOException {
        paintImage = ImageIO.read(new File("filename.png"));
        // update panel with new paint image
        repaint();
 
    }
}
