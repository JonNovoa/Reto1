/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Exceptions.BDException;

/**
 *
 * @author somor
 */
public interface ModelInterface {
    
    
    public String getGreeting() throws BDException;
    
}
