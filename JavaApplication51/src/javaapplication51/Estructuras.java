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
    protected Matriz celda,val_x,val_y,raizM;
    
    //EDD de la lista circular para usuarios
    protected usuarios apuntador,aux,ref;
    public Estructuras(){
        //usuarios
        apuntador=aux=ref=null;
        
        //matriz
        celda=val_x=val_y=null;
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
    public void corroborarLista(){
        usuarios recorrer=apuntador.Siguiente;
        System.out.println(apuntador.nombre);
        while(recorrer!=apuntador){
            System.out.println(recorrer.nombre);
            recorrer=recorrer.Siguiente;
        }
    }
    
    public boolean existe_casilla(){return (celda==null)?true:false;}
    
    
    public void MATRIZ(){
        celda=null;
        for(int i=0;i<DIMENSION;i++){
            for(int j=0;j<DIMENSION;j++){
                if(celda==null){
                    raizM=celda =val_y=new Matriz(i, j);
                }
                else if(i==0){
                    val_x=new Matriz(i, j);
                    val_y.derecha=val_x;
                    val_x.izquierda=val_y;
                    val_y=val_y.derecha;
                }
                else if(j==0){
                    val_y=celda;
                    val_x=new Matriz(i, j);
                    val_y.abajo=val_x;
                    val_x.arriba=val_y;
                    val_y=val_y.derecha;
                    celda=val_x;
                }
                else{
                    Matriz naux = new Matriz(i, j);
                    naux.izquierda=val_x;
                    val_x.derecha=naux;
                    naux.arriba=val_y;
                    val_y.abajo=naux;
                    val_x=naux;
                    val_y=val_y.derecha;
                }
            }
            
        }
    }
    public void llerM(){
        Matriz recorrer,apuntador;
        apuntador=val_x;
        for(int i=apuntador.posy;i>=0;i--){ 
            recorrer=apuntador;
            apuntador=apuntador.arriba;
            for(int x=recorrer.posy;x>=0;x--){
                    System.out.print("["+recorrer.posx+" , "+recorrer.posy+"]");
                    recorrer=recorrer.izquierda;
            }
            System.out.println("");
            
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
            System.out.println("ERROR");
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
            System.out.println("dobles");
            NodeList dobles = elementoScrabble.getElementsByTagName("dobles");
            Node dobles_item = dobles.item(0);
            Element dob = (Element)dobles_item;
            NodeList casilla = dob.getElementsByTagName("casilla");
            for(int i=0;i<casilla.getLength();i++){
                Node varXY = casilla.item(i);
                Element XY =(Element)varXY;
                NodeList X=XY.getElementsByTagName("x");
                NodeList Y =XY.getElementsByTagName("y");
                Node var_X=X.item(0);
                Node var_Y=Y.item(0);
                //valor de X
                Element x=(Element)var_X;
                //valor de Y
                Element y=(Element)var_Y;
                nodoAux= new Matriz(Integer.parseInt(x.getTextContent()),Integer.parseInt( y.getTextContent()));
                System.out.println(x.getTextContent()+"___"+y.getTextContent());
                celda=raizM;
                    
                
            }
            System.out.println("TRIPLES");
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
                System.out.println(x.getTextContent()+"___"+y.getTextContent());
            }
           
            NodeList diccionario = elementoScrabble.getElementsByTagName("diccionario");
            Node diccionario_item = diccionario.item(0);
            Element diccionario_e = (Element)diccionario_item;
            NodeList palabra = diccionario_e.getElementsByTagName("palabra");
            
            for(int i=0;i<palabra.getLength();i++){
                Node varP = palabra.item(i);
                Element x=(Element)varP;
                //valor de la palabra ingresada
                System.out.println(x.getTextContent());
            }
            
            return true;
        }catch(ParserConfigurationException e){}
        catch(SAXException e){}
        catch(IOException e){}
        return false;
    }
    
    
    
    
    
    
}
