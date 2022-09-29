/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Exceptions.BDException;

/**
 * Interfaz de vistas
 * @author somor
 */
public interface ViewInterface {
    
    /**
     * Metodo de la vista
     * @param message
     * @throws BDException 
     */
    public void showGreeting(String message) throws BDException;
}
