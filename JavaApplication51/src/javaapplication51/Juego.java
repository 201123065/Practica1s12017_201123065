/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication51;

import java.awt.Image;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.TransferHandler;

/**
 *
 * @author marcosmayen
 */
public class Juego extends JFrame implements MouseListener, MouseMotionListener{
    int mx,my;
    Boolean mouseDragged=false;
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
        
        JButton Limpiar = new JButton("Limpiar jugadas");
        JButton Aceptar = new JButton("Validar tiro");
        Limpiar.setBounds(0, DIMENSION*E+80, 200, 50);
        Aceptar.setBounds(DIMENSION*E-200, DIMENSION*E+80, 200, 50);
        add(Limpiar);
        add(Aceptar);
        
        for(int i=0;i<DIMENSION;i++){
            for(int j=0;j<DIMENSION;j++){
                etiqueta[i][j] = new JLabel("0");
                etiqueta[i][j].setBounds(E*i+2,E*j+2, E-3, E-3);
                System.out.print(temporal.getMultiplicador());
                if(temporal.getMultiplicador()==1){
                    etiqueta[i][j].setIcon(new ImageIcon(System.getProperty("user.dir")+"/imagenes/blanco.png"));
                }else if (temporal.getMultiplicador()==2){
                    etiqueta[i][j].setIcon(new ImageIcon(System.getProperty("user.dir")+"/imagenes/amarillo.png"));
                    
                }else if(temporal.getMultiplicador()==3){
                    etiqueta[i][j].setIcon(new ImageIcon(System.getProperty("user.dir")+"/imagenes/verde.png"));
                }
                add(etiqueta[i][j]);
                etiqueta[i][j].setTransferHandler(new TransferHandler("icon"));
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
        usuarios lista = ahora.Siguiente;
        String lista_J = "jugador :"+ahora.nombre+" Punteo: "+ahora.punteo;
        while(lista!=ahora){
            lista=lista.Siguiente;
            lista_J+="\n"+"jugador :"+lista.nombre+" Punteo: "+lista.punteo;
        }
        JTextArea jtf1 = new JTextArea(lista_J);
        jtf1.setBounds(E*DIMENSION+50, 50, 200, 580);
        add(jtf1);
        JLabel sigue = new JLabel("Turno de: '"+ahora.nombre+"'");
        JLabel punteo = new JLabel("Punteo :'"+ahora.punteo+"'");
        sigue.setBounds(E*DIMENSION+10, 20, 270, 20);
        punteo.setBounds(E*DIMENSION+280, 20, 200, 20);
        add(punteo);
        add(sigue);
       
        JLabel fichas = new JLabel("Fichas actuales: ");
        fichas.setBounds(15, DIMENSION*E+20, 120, 10);
        JLabel []letra=new JLabel[7];
        for(int i=0;i<7;i++){
            letra[i]=new JLabel();
            letra[i].setBounds(i*51+125, DIMENSION*E+20, 50, 50);
            letra[i].addMouseListener(this);
            letra[i].setIcon(new ImageIcon(System.getProperty("user.dir")+"/Letras/AMARILLO/a.png"));
            add(letra[i]);
            letra[i].setTransferHandler(new TransferHandler("icon"));
        }
        add(fichas);
        
        ImageIcon ii = new ImageIcon(System.getProperty("user.dir")+"/imagenes/live.png");
        Icon i = new ImageIcon(ii.getImage().getScaledInstance(500, 500,Image.SCALE_DEFAULT));
        
        JLabel liveGraphviz = new JLabel();
        liveGraphviz.setBounds(E*DIMENSION+260, 130, 500, 500);
        liveGraphviz.setIcon(i);
        liveGraphviz.repaint();
        add(liveGraphviz);
        
        addMouseMotionListener(this);
        setLayout(null);
        setSize(DIMENSION*E+800, DIMENSION*E+200);
        setLocationRelativeTo(null);
        setVisible(true);

        JButton Diccionario = new JButton("Lista Diccionario");
        JButton Fichas = new JButton("Fichas Activas");
        JButton matrizT = new JButton("Matriz tablero");
        JButton cola_Fichas = new JButton("Cola de fichas");
        JButton lista_D_Jugadores = new JButton("Lista de jugadores");
        
        
    }
    

    @Override
    public void mouseDragged(MouseEvent e) {
        mx= e.getX();
        my=e.getY();
        mouseDragged=true;
        e.consume();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mx= e.getX();
        my=e.getY();
        System.out.println(mx+"-"+my);
        mouseDragged=false;
        e.consume();
    
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        JComponent jc = (JComponent)e.getSource();
        TransferHandler th = jc.getTransferHandler();
        th.exportAsDrag(jc, e, TransferHandler.COPY);
        if(mouseDragged){
            System.out.println("...");
        }else{
            System.out.println("---");
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println(":c");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    
}
