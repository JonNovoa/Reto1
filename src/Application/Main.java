/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import Controller.Controller;
import Model.ModelFactory;
import View.ViewFactory;
import java.io.File;



/**
 *
 * @author somor
 */
public class Main {
    
   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ViewFactory view = new ViewFactory();
        ModelFactory model = new ModelFactory();
        Controller controller = new Controller();
        
       // model.run(getView,getModel);
        
       
    }
    
}

