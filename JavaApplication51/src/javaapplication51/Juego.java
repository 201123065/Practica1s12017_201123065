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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author marcosmayen
 */
public class Juego extends JFrame{
    
    private Diccionario DICCIONARIO;
    private Matriz MATRIZ;
    private usuarios USUARIOS;
    JLabel L1,L2,L3,L4,L5,L6,L7;
    public Juego(Diccionario DICCIONARIO, Matriz MATRIZ, usuarios USUARIOS,int DIMENSION){
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
                }else if (temporal.getMultiplicador()==2){
                    etiqueta[i][j].setIcon(new ImageIcon(System.getProperty("user.dir")+"/imagenes/amarillo.jpg"));
                    
                }else if(temporal.getMultiplicador()==3){
                    etiqueta[i][j].setIcon(new ImageIcon(System.getProperty("user.dir")+"/imagenes/verde.jpg"));
                }
                add(etiqueta[i][j]);
                temporal=temporal.getDerecha();
            }
            System.out.println("");
            raiz=temporal=raiz.getAbajo();
            
        }
        usuarios ahora =USUARIOS;
        JTextField turno = new JTextField();
        JLabel sigue = new JLabel("Turno de: '"+ahora.nombre+"'");
        JLabel punteo = new JLabel("Punteo :'"+ahora.punteo+"'");
        sigue.setBounds(E*DIMENSION+10, 20, 270, 20);
        punteo.setBounds(E*DIMENSION+280, 20, 200, 20);
        add(punteo);
        add(sigue);
        
        
        setLayout(null);
        setSize(DIMENSION*E+500, DIMENSION*E+20);
        setLocationRelativeTo(null);
        setVisible(true);

        
        
    }
    
    
}
