/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Exceptions.BDException;

/**
 *
 * @author somor
 */
public interface ViewInterface {
    
    public void showGreeting(String message) throws BDException;
}
