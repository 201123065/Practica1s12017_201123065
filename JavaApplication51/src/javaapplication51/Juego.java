/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication51;

import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.TransferHandler;

/**
 *
 * @author marcosmayen
 */
public class Juego extends JFrame{
    
    private Diccionario DICCIONARIO;
    private Matriz MATRIZ;
    private usuarios USUARIOS;
    JLabel L1,L2,L3,L4,L5,L6,L7;
    public Juego(Diccionario DICCIONARIO, Matriz MATRIZ, usuarios USUARIOS,int DIMENSION,int jugadores){
        super("Juego");
        this.DICCIONARIO=DICCIONARIO;
        this.MATRIZ=MATRIZ;
        this.USUARIOS=USUARIOS;
        Matriz temporal= MATRIZ;
        Matriz raiz = MATRIZ;
        int E=30;
        JLabel[][] etiqueta = new JLabel[DIMENSION][DIMENSION];
        for(int i=0;i<DIMENSION;i++){
            for(int j=0;j<DIMENSION;j++){
                etiqueta[i][j] = new JLabel();
                etiqueta[i][j].setBounds(E*i+2,E*j+2, E-3, E-3);
                System.out.print(temporal.getMultiplicador());
                if(temporal.getMultiplicador()==1){
                    etiqueta[i][j].setIcon(new ImageIcon(System.getProperty("user.dir")+"/imagenes/blanco.jpg"));
                    etiqueta[i][j].setText("x1");
                }else if (temporal.getMultiplicador()==2){
                    etiqueta[i][j].setIcon(new ImageIcon(System.getProperty("user.dir")+"/imagenes/amarillo.jpg"));
                    
                }else if(temporal.getMultiplicador()==3){
                    etiqueta[i][j].setIcon(new ImageIcon(System.getProperty("user.dir")+"/imagenes/verde.jpg"));
                }
                add(etiqueta[i][j]);
                etiqueta[i][j].setText("?");
                temporal=temporal.getDerecha();
            }
            System.out.println("");
            raiz=temporal=raiz.getAbajo();
            
        }
        usuarios ahora =USUARIOS;
        JTextField turno = new JTextField();
        for(int i=0;i<(int)Math.floor(Math.random()*jugadores);i++){
            ahora=ahora.Siguiente;
        }
        JLabel sigue = new JLabel("Turno de: '"+ahora.nombre+"'");
        JLabel punteo = new JLabel("Punteo :'"+ahora.punteo+"'");
        sigue.setBounds(E*DIMENSION+10, 20, 270, 20);
        punteo.setBounds(E*DIMENSION+280, 20, 200, 20);
        add(punteo);
        add(sigue);
        
        MouseListener m1 = new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                JComponent jc = (JComponent)e.getSource();
                TransferHandler th = jc.getTransferHandler();
                th.exportAsDrag(jc, e, TransferHandler.COPY);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };
        
        
        setLayout(null);
        setSize(DIMENSION*E+500, DIMENSION*E+200);
        setLocationRelativeTo(null);
        setVisible(true);

        
        
    }
    
    
}
