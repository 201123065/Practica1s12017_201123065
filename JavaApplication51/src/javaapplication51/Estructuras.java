/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication51;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author marcosmayen
 */
public class Estructuras {
    
    //EDD de la matriz
    protected Matriz celda,val_x,val_y,raizM,pivote;
    //EDD de la lista circular para usuarios
    protected usuarios apuntador,aux,ref;
    //EDD del diccionario
    protected Diccionario lista,apuntador_D;
    public Estructuras(){
        //usuarios
        apuntador=aux=ref=null;
        
        //matriz
        celda=val_x=val_y=null;
        
        //Diccionario
        
    }
    public Boolean hay_usuarios(){
        return (apuntador==null)?true:false;
    }
    public void agregarCircular(String nombre){
        if(hay_usuarios()){
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
    public String corroborarLista(){
        usuarios recorrer=apuntador.Siguiente;
        String cadena=apuntador.nombre+"\n";
        while(recorrer!=apuntador){
            cadena=cadena+recorrer.nombre+"\n";
            recorrer=recorrer.Siguiente;
        }
        return cadena;
    }
    
    public boolean existe_palabra(){return (lista==null)?true:false;}
    public void agregarPalabra(String palabra){
        if(!existe_palabra()){
            lista=apuntador_D=new Diccionario(palabra);
        }else{
            lista.setSiguiente(new Diccionario(palabra));
            lista=lista.getSiguiente();
        }
    }
    public boolean existe_casilla(){return (celda==null)?true:false;}
    
    
    public void MATRIZ(){
        celda=null;
        for( int i=0;i<=DIMENSION;i++){
            for(int j=0;j<=DIMENSION;j++){
                if(celda==null){raizM=celda=val_y=val_x=new Matriz();}
                else{
                    val_x=new Matriz();
                    if(i==0){
                        val_y.setDerecha(val_x);
                        val_x.setIzquierda(val_y);
                    }else if(j==0){
                        val_x.setArriba(val_y);
                        val_y.setAbajo(val_x);
                        celda=pivote=val_x;
                    }
                    else{
                        val_x.setArriba(val_y);
                        val_y.setAbajo(val_x);
                        val_x.setIzquierda(pivote);
                        pivote.setDerecha(val_x);
                        pivote=val_x;
                    }
                    val_y=val_y.getDerecha();
                }
            }
            val_y=celda;
        }
    }
    
    public void llerM(){
        Matriz recorrer,apuntador;
        apuntador=recorrer=raizM;
        
        while(apuntador.getAbajo()!=null){
            while(recorrer.getDerecha()!=null){
                System.out.print("["+recorrer.getMultiplicador()+"]");
                recorrer=recorrer.getDerecha();
            }
            System.out.println("");
            apuntador=recorrer=apuntador.getAbajo();
        }
        
    }
    //LEER ARCHIVOS INGRESADOS
    File f;
    FileReader FR;
    FileWriter FW;
    public Boolean leer(){
        try{
        File f;
        javax.swing.JFileChooser j = new javax.swing.JFileChooser();
        j.showOpenDialog(j);
        String path = j.getSelectedFile().getAbsolutePath();
        String lectura ="";
        f = new File(path);
        separador(f);
        }catch(NullPointerException e){
            System.out.println(MISTAKE);
        }
        return false;
    }
    String MISTAKE="";
    String SUCCESS="";
    int DIMENSION=3;
    public Boolean separador(File cadena)
    {
        DocumentBuilderFactory buildFactory = DocumentBuilderFactory.newInstance();
        try{
            DocumentBuilder dBuilder = buildFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new FileInputStream(cadena));
            doc.normalize();
            //<scrabble></scrabble>
            NodeList Scrabble = doc.getElementsByTagName("scrabble");
            Node raiz=Scrabble.item(0);
            Element elementoScrabble = (Element)raiz;
            //dimensiones
            NodeList dimensionList = elementoScrabble.getElementsByTagName("dimension");
            Element dimensionL = (Element)dimensionList.item(0);
            DIMENSION=Integer.parseInt(dimensionL.getTextContent());
            MATRIZ();
            Matriz nodoAux;
            NodeList dobles = elementoScrabble.getElementsByTagName("dobles");
            Node dobles_item = dobles.item(0);
            Element dob = (Element)dobles_item;
            //System.out.println("DOBLES"); 
            NodeList casilla = dob.getElementsByTagName("casilla");
            for(int i=0;i<casilla.getLength();i++){
                Node varXY = casilla.item(i);
                Element XY =(Element)varXY;
                NodeList X=XY.getElementsByTagName("x");
                NodeList Y =XY.getElementsByTagName("y");
                Node var_X=X.item(0);
                Node var_Y=Y.item(0);
                //valor de X
                Element valx=(Element)var_X;
                int x=Integer.parseInt(valx.getTextContent());
                //valor de Y
                Element valy=(Element)var_Y;
                int y =Integer.parseInt(valy.getTextContent());
                
                //System.out.println(x+"---"+y );
                potenciador_matriz(x,y,2); 
                
                    
                
            }
            //System.out.println("TRIPLES");
            NodeList triples = elementoScrabble.getElementsByTagName("triples");
            Node triples_item = triples.item(0);
            Element tri = (Element)triples_item;
            NodeList casillaT = tri.getElementsByTagName("casilla");
            for(int i=0;i<casillaT.getLength();i++){
                Node varXY = casillaT.item(i);
                Element XY =(Element)varXY;
                NodeList X=XY.getElementsByTagName("x");
                NodeList Y =XY.getElementsByTagName("y");
                Node var_X=X.item(0);
                Node var_Y=Y.item(0);
                //valor de X
                Element x=(Element)var_X;
                //valor de Y
                Element y=(Element)var_Y;
                //System.out.println(x.getTextContent()+"___"+y.getTextContent());
                potenciador_matriz(Integer.parseInt(x.getTextContent()), Integer.parseInt(y.getTextContent()), 3);
            }
           
            NodeList diccionario = elementoScrabble.getElementsByTagName("diccionario");
            Node diccionario_item = diccionario.item(0);
            Element diccionario_e = (Element)diccionario_item;
            NodeList palabra = diccionario_e.getElementsByTagName("palabra");
            
            for(int i=0;i<palabra.getLength();i++){
                Node varP = palabra.item(i);
                Element x=(Element)varP;
                //valor de la palabra ingresada
                //IMPRIMIR DICCIONARIO
                //System.out.println(x.getTextContent());
            }
            
            return true;
        }catch(ParserConfigurationException e){}
        catch(SAXException e){}
        catch(IOException e){}
        return false;
    }
    
    public void potenciador_matriz(int x, int y,int potencia) {
        if((x>0 && x<=DIMENSION) && (y>0 && y<=DIMENSION)){
            celda=raizM;
            for(int i=0;i<x-1;i++){
                celda=celda.getDerecha();
            }
            for(int j=0;j<y-1;j++){
                celda=celda.getAbajo();
            }
            celda.setmultiplicador(potencia);

        }
        else{
            System.out.println("hay un tufo por aca? :"+x+","+y);
            MISTAKE = (x>DIMENSION && y>DIMENSION)?MISTAKE+"'X' y 'Y' se salen del parametro":(x>DIMENSION)?MISTAKE+"'X' se sale del parametro ["+x+"]":MISTAKE+"'Y' se sale del parametro["+y+"]";
        }
    }
    
    
    
}








