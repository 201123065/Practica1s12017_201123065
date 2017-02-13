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
public class circular_usuarios {
    protected usuarios inicio;
    protected usuarios fin;
    
    protected usuarios apuntador,aux,ref;
    public circular_usuarios(){
        inicio=null;
        fin=null;
    }
    public Boolean estaVacia(){
        return (apuntador==null)?true:false;
    }
    public void agregarCircular(String nombre){
        if(estaVacia()){
            apuntador = new usuarios(nombre);
            apuntador.Siguiente=apuntador;
            ref=apuntador;
            
        }else{
            aux = new usuarios(nombre);
            ref.Siguiente=aux;
            aux.Siguiente=apuntador;
            ref=ref.Siguiente;
        }
    }
    public void corroborarLista(){
        usuarios recorrer=apuntador.Siguiente;
        System.out.println(apuntador.nombre);
        while(recorrer!=apuntador){
            System.out.println(recorrer.nombre);
            recorrer=recorrer.Siguiente;
        }
    }
}
