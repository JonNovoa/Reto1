/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Exceptions.BDException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GRUPO JG
 */
public class BdModelImplementation implements ModelInterface {
 
    /**
     * prepara la conexion
     */
    private Connection conex;
    /**
     * prepara la sentencia
     */
    private PreparedStatement stmt;
    /**
     * lee el archivo de configuracion
     */
    private ResourceBundle archivoConfig;
    /**
     * url para conectarse a la base de datos
     */
    private String url;
    /**
     * usuario para conectarse a la base de datos
     */
    private String usuario;
    /**
     * contraseña para conectarse a la base de datos
     */
    private String contraseña;
    /**
     * driver para conectarse a la base de datos
     */
    private String driver;
    
    /**
     * selecciona el saludo
     */
    private final String getGreeting = "SELECT message from greet";
   
    /**
     * constructor en el que se agragan los datos necesarios para conectarse a la
     * base de datos
     */
    public BdModelImplementation(){
        this.archivoConfig = ResourceBundle.getBundle("Model.BDconnect");
        this.url = archivoConfig.getString("Conn");
        this.usuario = archivoConfig.getString("BDuser");
        this.contraseña = archivoConfig.getString("BDPass");
        this.driver = archivoConfig.getString("Driver");
    }
    /**
     * abre la conexion con la base de datos
     * @throws ClassNotFoundException
     * @throws BDException Excepcion para cuanto intentas conectar con la BD
     */

    public void openConnection() throws ClassNotFoundException,BDException{
        try{
            Class.forName(driver);
            conex = DriverManager.getConnection(url,usuario,contraseña);
        }catch(SQLException e){
            //e.printStackTrace();
            throw new BDException("ERROR");
        }
    }
    /**
     * cierra la conexion con la base de datos
     * @throws SQLException
     * @throws BDException Excepcion para cuanto intentas conectar con la BD
     */
    public void closeConnection() throws SQLException,BDException{
        if(conex != null){
            conex.close();
        }
        if(stmt !=null){
            conex.close();
        }
        throw new BDException("error");
    }
    
    /**
     * metodo para leer de la base de datos y devolver el saludo
     * @return el saludo
     * @throws BDException Excepcion para cuanto intentas conectar con la BD
     */
    @Override
    public String getGreeting() throws BDException{
        
        ResultSet rs = null;
        String saludo = "";
       
        
        try {
            this.openConnection();
            
        } catch (ClassNotFoundException ex) {
           // Logger.getLogger(BdModelImplementation.class.getName()).log(Level.SEVERE, null, ex);
           throw new BDException("ERROR SQL");
        }
        
        try {
            stmt = conex.prepareStatement(getGreeting);
             
            rs = stmt.executeQuery();
            
            if(rs.next()){
                saludo = rs.getString(1);
                
            }
        } catch (SQLException ex) {
            //Logger.getLogger(BdModelImplementation.class.getName()).log(Level.SEVERE, null, ex);
        throw new BDException("ERROR SQL");
        }
        
        try {
            this.closeConnection();
        } catch (SQLException ex) {
            //Logger.getLogger(BdModelImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw  new BDException("ERROR SQL");
        }
        
        return saludo;
      
        
    }
    
     

    
    
}