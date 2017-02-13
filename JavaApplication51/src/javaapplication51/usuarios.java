/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication51;

public class usuarios {
    public String nombre;
    public int punteo;
    public usuarios Siguiente;
    
    public usuarios(String n){
        nombre=n;
        Siguiente=null;
        punteo=0;
    }
    
    public usuarios(String n, usuarios sig){
        nombre=n;
        Siguiente = sig;
        
    }
}
