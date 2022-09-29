/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Exceptions.BDException;

/**
 * Interface del modelo
 * @author grupoJG
 */
public interface ModelInterface {
 
    /**
     * Metodo de la implementacion
     * @return
     * @throws BDException 
     */

    public String getGreeting() throws BDException;
    
}
