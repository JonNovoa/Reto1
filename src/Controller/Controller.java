/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Exceptions.BDException;
import Model.ModelInterface;
import View.ViewInterface;

/**
 *
 * @author somor
 */
public class Controller {
    
    public void run (ViewInterface view,ModelInterface model) throws BDException{
        String dato="";
        
        dato = model.getGreeting();    
        view.showGreeting(dato);
    }
    
}
