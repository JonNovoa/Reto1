/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author GRUPO JG
 * Excepcion para cuanto intentas conectar con la BD

 */
public class BDException extends Exception{
     
    public BDException(String message){
        super(message);
    }
}
