package test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.giocatore.Giocatore;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;


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
    public void testGiocatoreConstructor() {
        Giocatore giocatore = new Giocatore("Marco", 10);
        assertNotNull(giocatore);
        assertEquals("Marco", giocatore.getNome());
        assertEquals(10, giocatore.getCfu());
        assertEquals("Giocatore: Marco, CFU: 10, Borsa vuota", giocatore.toString()); // Supponendo che la borsa sia vuota
    }

    @Test
    public void testGiocatoreToString() {
        Giocatore giocatore = new Giocatore("Alice", 20);
        Attrezzo spada = new Attrezzo("spada", 1);
        giocatore.aggiungiAttrezzoAllaBorsa(spada);
        assertEquals("Giocatore: Alice, CFU: 20, Contenuto borsa (1kg/10kg): spada (1kg)", giocatore.toString().trim());
    }

    @Test
    public void testGiocatoreBorsaVuota() {
        Giocatore giocatore = new Giocatore("Giorgio", 15);
        assertTrue(giocatore.getContenutoBorsa().equals("Borsa vuota"));
    }
    @Test
    public void testRemoveAttrezzoInesistente() {
        Giocatore giocatore = new Giocatore("Sara", 10);
        assertNull(giocatore.removeAttrezzoDallaBorsa("nonEsistente"));  // Attrezzo non presente
    }
    @Test
    public void testHaAttrezzo() {
        Giocatore giocatore = new Giocatore("Francesca", 50);
        Attrezzo attrezzo = new Attrezzo("chiave", 1);
        assertFalse(giocatore.haAttrezzo("chiave"));  // Borsa vuota
        giocatore.aggiungiAttrezzoAllaBorsa(attrezzo);
        assertTrue(giocatore.haAttrezzo("chiave"));   // Borsa contiene il chiave
    }

    @Test
    public void testGetBorsa() {
        Giocatore giocatore = new Giocatore("Andrea", 5);
        Borsa borsa = giocatore.getBorsa();
        assertNotNull(borsa);
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
        assertTrue(giocatore.haAttrezzo("lanterna"));
        assertTrue(giocatore.posaAttrezzo(attrezzo, stanza));
        assertFalse(giocatore.haAttrezzo("lanterna"));
        assertTrue(stanza.hasAttrezzo("lanterna"));
    }
    @Test
    public void testPosaAttrezzoInesistente() {
        Giocatore giocatore = new Giocatore("Paolo", 20);
        Stanza stanza = new Stanza("cucina");
        Attrezzo attrezzo = new Attrezzo("ascia", 3);
        assertFalse(giocatore.posaAttrezzo(attrezzo, stanza));  // L'attrezzo non è nella borsa
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
        assertEquals("Contenuto borsa (3kg/10kg): lanterna (3kg)", giocatore.getContenutoBorsa().trim());
    }

    @Test
    public void testToString() {
    	setUp();
        giocatore.aggiungiAttrezzoAllaBorsa(attrezzo);
        assertEquals("Giocatore: Mario, CFU: 10, Contenuto borsa (3kg/10kg): lanterna (3kg) ", giocatore.toString());
    }
}

