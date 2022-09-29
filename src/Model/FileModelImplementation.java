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
 * @author somor
 */
public class FileModelImplementation implements ModelInterface {
   
    
    @Override
    public String getGreeting(){ 
        
        String greeting = ResourceBundle.getBundle("Model.greet").getString("message");
        
       return greeting;
    }
}
