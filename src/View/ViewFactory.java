/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.ResourceBundle;
import javax.annotation.Resource;

/**
 *
 * @author somor
 */
public class ViewFactory {
    
     private ResourceBundle config ;
     
    public void getView(){
        
      config = ResourceBundle.getBundle("Application.Config");
        switch(config.getString("view_style")){
            
            case "text":
                
                break;
        }
        
        
        
    }
    
    
    
}
