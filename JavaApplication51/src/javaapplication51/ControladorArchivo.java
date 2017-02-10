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
        File f;
        javax.swing.JFileChooser j = new javax.swing.JFileChooser();
        j.showOpenDialog(j);
        String path = j.getSelectedFile().getAbsolutePath();
        String lectura ="";
        f = new File(path);
        System.out.println(f);
        separador(f);
        /*
        try{
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String aux;
            while((aux=br.readLine())!=null){
                lectura = lectura+aux+"\n";
            }
            return separador(lectura);
        }catch(IOException e){
            System.out.println("ERROR");
        }
                */
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
            //scrabble
            NodeList raizNodo = doc.getElementsByTagName("scrabble");
            Node raiz=raizNodo.item(0);
            Element elementoRaiz = (Element)raiz;
            //dimensiones
            NodeList dimensionList = elementoRaiz.getElementsByTagName("dimension");
            Element dimensionL = (Element)dimensionList.item(0);
            DIMENSION=Integer.parseInt(dimensionL.getTextContent());
            //dobles
            
            
            
            return true;
        }catch(ParserConfigurationException e){}
        catch(SAXException e){}
        catch(IOException e){}
        return false;
    }
}
