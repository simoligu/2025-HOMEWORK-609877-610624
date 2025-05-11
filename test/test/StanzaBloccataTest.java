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
	    private static final String CHIAVE = "chiave";
	    private static final String DIREZIONE_BLOCCATA = "nord";

	    @BeforeEach
	    void setUp() {
	        stanzaBloccata = new StanzaBloccata("Atrio", CHIAVE, DIREZIONE_BLOCCATA);
	        stanzaLibera = new Stanza("Biblioteca");
	        stanzaBloccata.impostaStanzaAdiacente(DIREZIONE_BLOCCATA, stanzaLibera);
	    }

	    @Test
	    void testGetStanzaAdiacenteDirezioneBloccataSenzaChiave() {
	        Stanza stanza = stanzaBloccata.getStanzaAdiacente(DIREZIONE_BLOCCATA);
	        assertEquals(stanzaBloccata, stanza);
	    }

	    @Test
	    void testGetStanzaAdiacenteDirezioneBloccataConChiave() {
	        stanzaBloccata.addAttrezzo(new Attrezzo(CHIAVE, 1));
	        Stanza stanza = stanzaBloccata.getStanzaAdiacente(DIREZIONE_BLOCCATA);
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
	        stanzaBloccata.addAttrezzo(new Attrezzo(CHIAVE, 1));
	        String descrizione = stanzaBloccata.getDescrizione();
	        assertFalse(descrizione.contains("c'è una serratura, serve una chiave per aprirla."));
	    }
	}

