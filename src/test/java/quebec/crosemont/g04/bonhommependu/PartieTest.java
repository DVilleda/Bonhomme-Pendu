/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quebec.crosemont.g04.bonhommependu;

import java.time.LocalDateTime;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author socce
 */
public class PartieTest {
    
    public PartieTest() {
    }
    
    /**
     * Test of getPseudo method, of class Partie.
     */
    @Test
    public void testGetPseudo() {
        System.out.println("getPseudo");
        Partie instance = new Partie("GioGio",Difficulte.FACILE);
        
        String expResult = "GioGio";
        String result = instance.getPseudo();
        assertEquals(expResult, result);
    }



    /**
     * Test of changerPseudo method, of class Partie.
     */
    @Test
    public void testChangerPseudo() {
        System.out.println("changerPseudo");
        String unNom = "Mr Silver";
        Partie instance = new Partie("GioGio",Difficulte.FACILE);
        
        instance.changerPseudo(unNom);
        
        String expResult = "Mr Silver";
        String result = instance.getPseudo();
        assertEquals(expResult, result);
    }


    /**
     * Test of toString method, of class Partie.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Partie instance = new Partie("GioGio",Difficulte.FACILE);
        
        String expResult = "Pseudonyme: GioGio Difficulte: FACILE";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
