package test;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {
	private StanzaBuia stanza;
	
	@BeforeEach
	public void setUp() {
		stanza = new StanzaBuia("N11", "lanterna");
	}
	
	@Test
	public void getDescrizioneSenzaLanterna() {
		setUp();
		assertTrue(stanza.getDescrizione().contains("qui c'è un buio pesto"));
	}
	
	@Test
	public void getDescrizioneConLanterna() {
		setUp();
		Attrezzo lanterna = new Attrezzo("lanterna", 3);
		stanza.addAttrezzo(lanterna);
		assertTrue(stanza.getDescrizione().contains("Attrezzi nella stanza: lanterna"));
	}
	
	@Test
	public void getDescrizioneConUnAltroAttrezzo() {
		setUp();
		Attrezzo random = new Attrezzo("random", 4);
		stanza.addAttrezzo(random);
		assertTrue(stanza.getDescrizione().contains("qui c'è un buio pesto"));
	}
}
