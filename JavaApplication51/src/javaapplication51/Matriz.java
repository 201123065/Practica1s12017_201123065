/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication51;

/**
 *
 * @author marcosmayen
 */
public class Matriz {
    private char letra;
    private int punteo,multiplicador;
    private Matriz derecha,izquierda,arriba,abajo;
    
    public Matriz(){
        multiplicador=1;
        derecha=izquierda=arriba=abajo=null;
    }
    
    //getters
    public Matriz getDerecha(){return derecha;}
    public Matriz getIzquierda(){return izquierda;}
    public Matriz getArriba(){return arriba;}
    public Matriz getAbajo(){return  abajo;}
    public int getMultiplicador(){return multiplicador;}
    public int getPunteo(){return punteo;}
    //setters
    public void setDerecha(Matriz valor){derecha=valor;}
    public void setIzquierda(Matriz valor){izquierda=valor;}
    public void setArriba(Matriz valor){arriba=valor;}
    public void setAbajo(Matriz valor){abajo=valor;}
    public void setChar(char l){letra=l;}
    public void setmultiplicador(int valor){multiplicador=valor;}
}
