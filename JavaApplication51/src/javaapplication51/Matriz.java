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
    public char letra;
    public int punteo,multiplicador;
    public int posx,posy;
    public Matriz derecha,izquierda,arriba,abajo;
    
    public Matriz(int x , int y){
        posx=x;
        posy=y;
        derecha=izquierda=arriba=abajo=null;
    }
    
    public Matriz(char n,int x , int y,int mult,int punto){
        posx=x;
        posy=y;
        multiplicador=mult;
        letra=n;
        derecha=izquierda=arriba=abajo=null;
        punteo=punto;
    }
    
    public Matriz(char n,int x , int y,int mult,int punto, Matriz der,Matriz izq, Matriz up, Matriz down){
        posx=x;
        posy=y;
        multiplicador=mult;
        punteo=punto;
        letra=n;
        derecha = der;
        izquierda=izq;
        arriba =up;
        abajo=down;
        
    }
}
