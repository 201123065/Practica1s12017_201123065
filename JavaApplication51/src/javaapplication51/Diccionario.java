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
public class Diccionario {
    private String palabra;
    private int puntos;
    
    private Diccionario siguiente;
    public Diccionario(){
        palabra="";
        puntos=0;
        siguiente=null;
    }
    public void setPalabra(String palabra){
        this.palabra=palabra;
    }
    public void setPuntos(int puntos){
        this.puntos=puntos;
    }
    
    public String getPalabra(){
        return palabra;
    }
    public int getPuntos(){
        return puntos;
    }
    public Diccionario getSiguiente(){
        return siguiente;
    }
}
