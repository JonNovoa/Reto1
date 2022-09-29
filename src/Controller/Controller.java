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
 * @author JG
 */
public class Controller {
    
    /**
     * 
     * @param view tipo de vista: text o swing;
     * @param model de donde se lee el saludo: Bd o File
     * @throws BDException, excepcion cuando intentas conectar con la BD
     * Metodo que recoje el mensaje de la Bd o fichero y lo devuelve mediante consola o swing
     */
    public void run (ViewInterface view,ModelInterface model) throws BDException{
        String dato="";
        
        dato = model.getGreeting();    
        view.showGreeting(dato);
    }
    
}
