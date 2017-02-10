/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication51;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author marcosmayen
 */
public class ControladorArchivo {
    File f;
    FileReader FR;
    FileWriter FW;
    public String leer(){
        File f;
        javax.swing.JFileChooser j = new javax.swing.JFileChooser();
        j.showOpenDialog(j);
        String path = j.getSelectedFile().getAbsolutePath();
        String lectura ="";
        f = new File(path);
        try{
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String aux;
            while((aux=br.readLine())!=null){
                lectura = lectura+aux+"\n";
            }
            return lectura;
        }catch(IOException e){
            System.out.println("ERROR");
        }
        return null;
    }
}
