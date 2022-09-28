/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Model.BdModelImplementation;
import Model.FileModelImplementation;
import java.sql.SQLException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author INFORMATICA
 */
public class ModelTest {
    private BdModelImplementation bdi;
    private FileModelImplementation fmi;
    private Model.ModelFactory mf;
    public ModelTest() {
    }
    
    @Before
    public void setUp() throws ClassNotFoundException {
        bdi = new BdModelImplementation();
        fmi = new FileModelImplementation();
        bdi.openConnection();
    }
    
    @After
    public void tearDown() throws SQLException {
        bdi.closeConnection();
    }
    
    @Test
    public void testGetGreetingBD(){
        String message = bdi.getGreeting();
        String expc = "Hola, buenas tardes";
        assertEquals(message, expc);
        
    }
    
    @Test
    public void testGetGreetingFL(){
        String message = fmi.getGreeting();
        String expc = "Hola, buenos dias";
        assertEquals(message, expc);
    }
}
