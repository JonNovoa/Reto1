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
public class BDModelImplementation implements ModelInterface {
    private Connection con = null;
    private Properties prope;
    private PreparedStatement stmnt = null;
    
    private  String url;
    private String user;
    private String passwd;
    private ResourceBundle connectFile;
    
    private final String getGreeting = "SELECT message from greet";
    
    public BDModelImplementation(){
        this.connectFile = ResourceBundle.getBundle("Model.BDconnect");
        this.url = connectFile.getString("Url");
        this.user = connectFile.getString("User");
        this.passwd = connectFile.getString("Passwd");
    }
    
    public void openConnection(){
        try {
            con = DriverManager.getConnection(url,user,passwd);
        } catch (SQLException ex) {
            Logger.getLogger(BDModelImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void closeConnection() throws SQLException{
        if(con != null){
            con.close();
        }
        if(stmnt != null){
            con.close();
        }
    }
    
    
    
    public String getGreeting() {
        String text = "No entra";
        ResultSet rs = null;
        this.openConnection();
        
        try {
            stmnt = con.prepareStatement(getGreeting);
            System.out.println(stmnt);
            rs = stmnt.executeQuery();
            
            text=rs.getString("message");
        } catch (SQLException ex) {
            Logger.getLogger(BDModelImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                this.closeConnection();
                if(rs!=null){
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(BDModelImplementation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       return text;
        
    }
    
     

    
    
}

