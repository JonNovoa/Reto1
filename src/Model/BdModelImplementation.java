/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
 * @author somor
 */
public class BdModelImplementation implements ModelInterface {
 
    
    private Connection conex;
    private PreparedStatement stmt;
    private ResourceBundle archivoConfig;
    private String url;
    private String usuario;
    private String contraseña;
    private String driver;
    
    private final String getGreeting = "SELECT message from greet";
    
    public BdModelImplementation(){
        this.archivoConfig = ResourceBundle.getBundle("Model.BDconnect");
        this.url = archivoConfig.getString("Conn");
        this.usuario = archivoConfig.getString("BDuser");
        this.contraseña = archivoConfig.getString("BDPass");
        this.driver = archivoConfig.getString("Driver");
    }

    public void openConnection() throws ClassNotFoundException{
        try{
            Class.forName(driver);
            conex = DriverManager.getConnection(url,usuario,contraseña);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void closeConnection() throws SQLException{
        if(conex != null){
            conex.close();
        }
        if(stmt !=null){
            conex.close();
        }
    }
    
    
    
    public String getGreeting() {
        
        ResultSet rs = null;
        String saludo = "";
       
        
        try {
            this.openConnection();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BdModelImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            stmt = conex.prepareStatement(getGreeting);
             
            rs = stmt.executeQuery();
            
            if(rs.next()){
                saludo = rs.getString(1);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(BdModelImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            this.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(BdModelImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return saludo;
      
        
    }
    
     

    
    
}