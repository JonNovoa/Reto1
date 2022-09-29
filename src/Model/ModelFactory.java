/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ResourceBundle;

/**
 * Factoria del Modelo
 * @author grupoJG
 */
public class ModelFactory {
    
  //  private ResourceBundle config ;
    /**
     * Elije del properties de configuracion de donde va a coger los datos a mostrar
     * @return 
     */
    public ModelInterface getModel() {
        ModelInterface model = null;
       String Dato = ResourceBundle.getBundle("Application.Config").getString("model_style");
       if (Dato.equalsIgnoreCase("file")){
           model = new FileModelImplementation();
       }
       if(Dato.equalsIgnoreCase("bd")){
           model = new BdModelImplementation();
       }
            return model;
    }
}

