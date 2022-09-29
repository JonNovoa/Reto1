/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.ResourceBundle;
import javax.annotation.Resource;

/**
 * Factoria de vista
 * @author somor
 */
public class ViewFactory {
    
    /**
     * Elije del properties de configuracion el modo de salida del mensaje
     * @return 
     */    
    public ViewInterface getView(){
      ViewInterface view = null;
      String Dato = ResourceBundle.getBundle("Application.Config").getString("view_style");
      
  
      if(Dato.equalsIgnoreCase("text")){
          view =  new TextViewImplementation();
      }
      if(Dato.equalsIgnoreCase("swing")){
          view = (ViewInterface) new SwingViewImplementation();
      }
        return view;
        
    }
    
    
    
}
    
    

