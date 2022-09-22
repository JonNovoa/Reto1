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
    File fich = new File("C:/saludo.txt");
    
    public String getGreeting() throws FileNotFoundException{
        String text = "";
        Scanner obj = new Scanner(fich);
        while (obj.hasNextLine()){
            text = obj.nextLine();
        }
        return text;
       
    }
}
