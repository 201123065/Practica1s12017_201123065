/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication51;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author marcosmayen
 */
public class plotter {
    public void plotearImagen(){
        try{
            String dotPath ="/Applications/Graphviz.app/Contents/MacOS/Graphviz";
            String fileInput =System.getProperty("user.dir")+"/te.dot";
            String imagen = System.getProperty("user.dir")+"/grafo.png";
            
            String tParam = "-Tjpg";
            String tOParam ="-o";
            
            String []cmd = new String[5];
            cmd[0]=dotPath;
            cmd[1]=tParam;
            cmd[2]=fileInput;
            cmd[3]=tOParam;
            cmd[4]=imagen;
            Runtime rt = Runtime.getRuntime();
            
      
      rt.exec( cmd );
        }catch(Exception ex){
            ex.printStackTrace();
            
        }
    }
    public String llerG(){
        return "s";
    }
    
    public void generarMatriz(Matriz m){
        Matriz caballito = m;
        Matriz cabeza = m;
        int i,j;
        i=j=0;
        String cadena ="digraph G {";
        while(m.getAbajo()!=null){
            while(caballito.getDerecha()!=null){
                int n = j+1;
                int u=i-1;
                cadena+="\n\"["+i+","+caballito.getMultiplicador()+","+j+"]\"->\"["+i+","+caballito.getDerecha().getMultiplicador()+","+n+"]\";";
                cadena+="\n\"["+i+","+caballito.getDerecha().getMultiplicador()+","+n+"]\"->\"["+i+","+caballito.getMultiplicador()+","+j+"]\";";
                
                if(caballito.getArriba()!=null){
                    cadena+="\n\"["+i+","+caballito.getMultiplicador()+","+j+"]\"->\"["+u+","+caballito.getArriba().getMultiplicador()+","+j+"]\";";
                    cadena+="\n\"["+u+","+caballito.getArriba().getMultiplicador()+","+j+"]\"->\"["+i+","+caballito.getMultiplicador()+","+j+"]\";";
                }
                caballito=caballito.getDerecha();
                cabeza.getDerecha();
                j++;
            }    int u = i-1;
            if(caballito.getArriba()!=null){
                cadena+="\n\"["+i+","+caballito.getMultiplicador()+","+j+"]\"->\"["+u+","+caballito.getArriba().getMultiplicador()+","+j+"]\";";
                cadena+="\n\"["+u+","+caballito.getArriba().getMultiplicador()+","+j+"]\"->\"["+i+","+caballito.getMultiplicador()+","+j+"]\";";
            }
            i++;
            j=0;
            cabeza=m;
            m=caballito=m.getAbajo();
        }
        cadena+="\n}";
        System.out.println(cadena);
        generarARCHIVO(cadena);
    }
    
    public void generarARCHIVO(String cadena){
        try{
            File archivo = new File(System.getProperty("user.dir")+"/te.dot");
            FileWriter fw= new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.write(cadena);
            pw.close();
            bw.close();
        }catch(IOException e){}
        
    }
    
    public void jugadores(usuarios cad){
        usuarios c = cad.Siguiente;
        String cadena ="digraph G {";
        while(c!=cad){
            cadena+="\n "+c.nombre+"->"+c.Siguiente.nombre+";";
            c=c.Siguiente;
        }
        cadena+="\n "+c.nombre+"->"+c.Siguiente.nombre+";\n}";
        generarARCHIVO(cadena);
    }
    
    public void diccionario(Diccionario d){
        String cadena ="digraph G {";
        while(d.getSiguiente()!=null){
            cadena+="\n "+d.getPalabra()+"->"+d.getSiguiente().getPalabra();
            d=d.getSiguiente();
        }
        cadena+="}";
        generarARCHIVO(cadena);
        
    }
        

}
