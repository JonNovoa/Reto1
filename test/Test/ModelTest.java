/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Exceptions.BDException;
import Model.BdModelImplementation;
import Model.FileModelImplementation;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author grupoJG
 */
public class ModelTest {
    private BdModelImplementation bdi;
    private FileModelImplementation fmi;
    
    public ModelTest() {
    }
    
    @Before
    public void setUp() throws ClassNotFoundException {
        bdi = new BdModelImplementation();
        fmi = new FileModelImplementation();
        try {
            bdi.openConnection();
        } catch (BDException ex) {
            Logger.getLogger(ModelTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @After
    public void tearDown() throws SQLException {
        try {
            bdi.closeConnection();
        } catch (BDException ex) {
            Logger.getLogger(ModelTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testGetGreetingBD(){
        String message;
        try {
            message = bdi.getGreeting();
            String expc = "Hola, buenas tardes";
        assertEquals(message, expc);
        } catch (BDException ex) {
            Logger.getLogger(ModelTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    @Test
    public void testGetGreetingFL(){
        String message = fmi.getGreeting();
        String expc = "Hola, buenos dias";
        assertEquals(message, expc);
    }
}
