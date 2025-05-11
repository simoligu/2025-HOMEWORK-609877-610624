package test;
	import static org.junit.jupiter.api.Assertions.*;
	import org.junit.jupiter.api.BeforeEach;
	import org.junit.jupiter.api.Test;

	import it.uniroma3.diadia.ambienti.Stanza;
	import it.uniroma3.diadia.ambienti.StanzaBloccata;
	import it.uniroma3.diadia.attrezzi.Attrezzo;
	public class StanzaBloccataTest {

	    private StanzaBloccata stanzaBloccata;
	    private Stanza stanzaLibera;

	    @BeforeEach
	    void setUp() {
	        stanzaBloccata = new StanzaBloccata("Atrio", "chiave", "nord");
	        stanzaLibera = new Stanza("Biblioteca");
	        stanzaBloccata.impostaStanzaAdiacente("nord", stanzaLibera);
	    }

	    @Test
	    void testGetStanzaAdiacenteDirezioneBloccataSenzaChiave() {
	        Stanza stanza = stanzaBloccata.getStanzaAdiacente("nord");
	        assertEquals(stanzaBloccata, stanza);
	    }

	    @Test
	    void testGetStanzaAdiacenteDirezioneBloccataConChiave() {
	    	Attrezzo chiave = new Attrezzo("chiave",5);
	        stanzaBloccata.addAttrezzo(chiave);
	        Stanza stanza = stanzaBloccata.getStanzaAdiacente("nord");
	        assertEquals(stanzaLibera, stanza);
	    }

	    @Test
	    void testGetStanzaAdiacenteDirezioneNonBloccata() {
	        Stanza sud = new Stanza("Laboratorio");
	        stanzaBloccata.impostaStanzaAdiacente("sud", sud);
	        Stanza stanza = stanzaBloccata.getStanzaAdiacente("sud");
	        assertEquals(sud, stanza);
	    }

	    @Test
	    void testGetDescrizioneSenzaChiave() {
	        String descrizione = stanzaBloccata.getDescrizione();
	        assertTrue(descrizione.contains("c'è una serratura, serve una chiave per aprirla"));
	    }

	    @Test
	    void testGetDescrizioneConChiave() {
	        Attrezzo chiave = new Attrezzo("chiave",5);
	        stanzaBloccata.addAttrezzo(chiave);
	        String descrizione = stanzaBloccata.getDescrizione();
	        assertFalse(descrizione.contains("c'è una serratura, serve una chiave per aprirla."));
	    }
	}

