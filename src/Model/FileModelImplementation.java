/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 *
 * @author GRUPO JG
 */
public class FileModelImplementation implements ModelInterface {
   
    /**
     * metodo para leer del fichero y devolver el saludo
     * @return saludo
     */
    @Override
    public String getGreeting(){ 
        
        String greeting = ResourceBundle.getBundle("Model.greet").getString("message");
        
       return greeting;
    }
}
