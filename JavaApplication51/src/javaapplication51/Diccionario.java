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
    public Diccionario(String palabra){
        this.palabra=palabra;
        puntos=valorPalabra(palabra);
        siguiente=null;
    }
    public void setPalabra(String palabra){
        this.palabra=palabra;
        puntos=valorPalabra(palabra);
    }
    public void setSiguiente(Diccionario valor){
        siguiente=valor;
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
    private int valorPalabra(String palabra){
        int retorno=0;
        for(int i=0;i<palabra.length();i++){
            retorno=retorno+valorLetra(palabra.charAt(i));
        }
        return retorno;
    }
    private int valorLetra(char c){
        switch (c){
            case 'A':
            case 'a':
            case 'E':
            case 'e':
            case 'O':
            case 'o':
            case 'I':
            case 'i':
            case 'S':
            case 's':
            case 'N':
            case 'n':
            case 'L':
            case 'l':
            case 'R':
            case 'r':
            case 'u':
            case 'U':
            case 'T':
            case 't':
                return 1;
            case 'd':
            case 'D':
            case 'g':
            case 'G':
                return 2;
            case 'c':
            case 'C':
            case 'b':
            case 'B':
            case 'm':
            case 'M':
            case 'p':
            case 'P':
                return 3;
            case 'h':
            case 'H':
            case 'f':
            case 'F':
            case 'v':
            case 'V':
            case 'y':
            case 'Y':
                return 4;
            case 'q':
            case 'Q':
                return 5;
            case 'j':
            case 'J':
            case 'ñ':
            case 'Ñ':
            case 'x':
            case 'X':
                return 8;
            case 'z':
            case 'Z':
                return 10;
        }
        return 0;
                
    }
    
    
}
