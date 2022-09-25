/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ResourceBundle;

/**
 *
 * @author somor
 */
public class ModelFactory {
    
  //  private ResourceBundle config ;
    
    public ModelInterface getModel() {
        ModelInterface model = null;
       String Dato = ResourceBundle.getBundle("Application.Config").getString("model_style");
       if (Dato.equalsIgnoreCase("file")){
           model = new FileModelImplementation();
       }
            return model;
    }
}

