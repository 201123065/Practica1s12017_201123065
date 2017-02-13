/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication51;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import jdk.internal.org.xml.sax.XMLReader;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author marcosmayen
 */
public class ControladorArchivo {
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
    int DIMENSION=0;
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
            System.out.println("do");
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
                System.out.println(x.getTextContent()+"___"+y.getTextContent());
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
            
            
            
            /* for (int i=0;i<dobles.getLength();i++){
                Node casilla = dobles.item(i);
                Element casillaE = (Element)casilla;
                NodeList x = casillaE.getElementsByTagName("x");
                Element val_x=(Element)x.item(i);
                NodeList y = casillaE.getElementsByTagName("y");
                Element val_y=(Element)y.item(i);
                System.out.println(val_x.getTextContent());
                System.out.println("------");
                System.out.println(val_y.getTextContent());
            }
            */
            
            
            
            NodeList diccionario = elementoScrabble.getElementsByTagName("diccionario");
            //dobles
            
            
            
            return true;
        }catch(ParserConfigurationException e){}
        catch(SAXException e){}
        catch(IOException e){}
        return false;
    }
}
