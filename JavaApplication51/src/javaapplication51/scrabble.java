package javaapplication51;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;


public class scrabble extends JFrame implements MouseListener, MouseMotionListener{
    private Image dbiImage;
    private Graphics dbg;
    boolean mouseDragged;
    int mx,my;
    
    public scrabble(int DIMENSION){
        setSize(DIMENSION*20, DIMENSION*20);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    public void repaint(Graphics g){
            dbiImage= createImage(getWidth(),getHeight());
            dbg=dbiImage.getGraphics();
            paintComponents(dbg);
            g.drawImage(dbiImage, 0, 0, this);
    }
    
    public void paintcomponent(Graphics g){
        if(mouseDragged){
            g.setColor(Color.red);
            g.fillRect(0, 0, getWidth(),getHeight());
            
        }
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mx= e.getX();
        my=e.getY();
        e.consume();
        mouseDragged=true;
    }
    

    @Override
    public void mouseMoved(MouseEvent e) {
        mx= e.getX();
        my=e.getY();
        e.consume();
        mouseDragged=false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
