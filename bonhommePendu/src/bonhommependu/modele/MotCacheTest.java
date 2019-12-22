/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quebec.crosemont.g04.bonhommependu;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author socce
 */
public class MotCacheTest {

    /**
     * Test of revelerLettreIndex method, of class MotCache.
     */
    @Test
    public void testRevelerLettreIndex() {
        System.out.println("revelerLettreIndex");
        int index = 2;
        MotCache instance = new MotCache("allo");
        instance.revelerLettreIndex(index);
        
        String expResult = "al_o";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of revelerLettre method, of class MotCache.
     */
    @Test
    public void testRevelerLettre() {
        System.out.println("revelerLettre");
        String uneLettre = "a";
       MotCache instance = new MotCache("allo");
        instance.revelerLettre(uneLettre);

        String expResult = "_llo";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of reveler method, of class MotCache.
     */
    @Test
    public void testReveler() {
        System.out.println("reveler");
        MotCache instance = new MotCache("allo");
        instance.reveler();
        
        String expResult = "allo";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of cacher method, of class MotCache.
     */
    @Test
    public void testCacher() {
        System.out.println("cacher");
        MotCache instance = new MotCache("allo");
        
        instance.cacher();
        
        String expResult = "____";
        String result = instance.toString();
        assertEquals(expResult, result);
    }   
}
