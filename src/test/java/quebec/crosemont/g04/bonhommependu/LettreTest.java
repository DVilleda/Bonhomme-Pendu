package quebec.crosemont.g04.bonhommependu;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Danny Alexander
 */
public class LettreTest {
    
    public LettreTest() {
    }
    
    /**
     * Test of getLettre method, of class Lettre.
     */
    @Test
    public void testGetLettre() {
        System.out.println("getLettre");
        Lettre instance = new Lettre('b');
        
        char expResult = 'b';
        char result = instance.getLettre();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of estVisible method, of class Lettre.
     */
    @Test
    public void testEstVisible() {
        System.out.println("estVisible");
        Lettre instance = new Lettre('b');
        
        boolean expResult = false;
        boolean result = instance.estVisible();
        assertEquals(expResult, result);
    }

    /**
     * Test of setVisible method, of class Lettre.
     */
    @Test
    public void testSetVisible() {
        System.out.println("setVisible");
        Lettre instance = new Lettre('b');
        instance.setVisible();
        
        boolean expResult = true;
        boolean result = instance.estVisible();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCache method, of class Lettre.
     */
    @Test
    public void testSetCache() {
        System.out.println("setCache");
        Lettre instance = new Lettre('b');
        instance.setCache();
        
        boolean expResult = false;
        boolean result = instance.estVisible();
        assertEquals(expResult, result);
    }
    
}
