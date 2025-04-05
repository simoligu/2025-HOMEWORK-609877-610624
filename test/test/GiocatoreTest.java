package test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.giocatore.Giocatore;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;


public class GiocatoreTest {
    private Giocatore giocatore;
    private Attrezzo attrezzo;
    private Stanza stanza;
    
    public void setUp() {
        giocatore = new Giocatore("Mario", 10);
        attrezzo = new Attrezzo("lanterna", 3);
        stanza = new Stanza("Atrio");
    }

    @Test
    public void testAggiungiAttrezzoAllaBorsa() {
    	setUp();
        assertTrue(giocatore.aggiungiAttrezzoAllaBorsa(attrezzo));
        assertTrue(giocatore.haAttrezzo("lanterna"));
    }

    @Test
    public void testRemoveAttrezzoDallaBorsa() {
    	setUp();
        giocatore.aggiungiAttrezzoAllaBorsa(attrezzo);
        Attrezzo rimosso = giocatore.removeAttrezzoDallaBorsa("lanterna");
        assertEquals("lanterna", rimosso.getNome());
        assertFalse(giocatore.haAttrezzo("lanterna"));
    }

    @Test
    public void testPrendiAttrezzo() {
    	setUp();
        stanza.addAttrezzo(attrezzo);
        assertTrue(giocatore.prendiAttrezzo(attrezzo, stanza));
        assertFalse(stanza.hasAttrezzo("lanterna"));
        assertTrue(giocatore.haAttrezzo("lanterna"));
    }

    @Test
    public void testPosaAttrezzo() {
    	setUp();
        giocatore.aggiungiAttrezzoAllaBorsa(attrezzo);
        assertTrue(giocatore.posaAttrezzo(attrezzo, stanza));
        assertFalse(giocatore.haAttrezzo("lanterna"));
        assertTrue(stanza.hasAttrezzo("lanterna"));
    }

    @Test
    public void testSetCfu() {
    	setUp();
        giocatore.setCfu(15);
        assertEquals(15, giocatore.getCfu());
    }

    @Test
    public void testGetContenutoBorsa() {
    	setUp();
        giocatore.aggiungiAttrezzoAllaBorsa(attrezzo);
        assertEquals("Contenuto borsa (3kg/10kg): lanterna (3kg)", giocatore.getContenutoBorsa());
    }

    @Test
    public void testToString() {
    	setUp();
        giocatore.aggiungiAttrezzoAllaBorsa(attrezzo);
        assertEquals("Giocatore: Mario, CFU: 10, Contenuto borsa (3kg/10kg): lanterna (3kg)", giocatore.toString());
    }
}

