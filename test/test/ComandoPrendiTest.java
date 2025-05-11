package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoPrendi;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPrendiTest {
	private Partita partita;
	private Stanza stanza;
	private IO ioConsole;
	private Comando comando;
	private Attrezzo attrezzo;
	private Borsa borsa;
	
	@BeforeEach
	public void setUp() {
		partita = new Partita();
		stanza = new Stanza("aula");
		ioConsole = new IOConsole();
		comando = new ComandoPrendi();
		attrezzo = new Attrezzo("attrezzo", 3);
		borsa = new Borsa();
	}
	
	@Test
	public void PrendiConParametro() {
		setUp();
		partita.setStanzaCorrente(stanza);
		stanza.addAttrezzo(attrezzo);
		comando.setParametro("attrezzo");
		comando.esegui(partita);
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("attrezzo"));
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("attrezzo"));
		assertEquals(3,partita.getGiocatore().getBorsa().getPeso());
	}
	
	@Test
	public void PrendiSenzaParametro() {
		setUp();
		partita.setStanzaCorrente(stanza);
		stanza.addAttrezzo(attrezzo);
		comando.setParametro(null);
		comando.esegui(partita);
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("attrezzo"));
		assertTrue(partita.getStanzaCorrente().hasAttrezzo("attrezzo"));
		assertEquals(0, partita.getGiocatore().getBorsa().getPeso());
	}
	
	@Test
	public void PrendiConParametroErrato() {
		setUp();
		partita.setStanzaCorrente(stanza);
		stanza.addAttrezzo(attrezzo);
		comando.setParametro("chiave");
		comando.esegui(partita);
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("attrezzo"));
		assertTrue(partita.getStanzaCorrente().hasAttrezzo("attrezzo"));
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("chiave"));
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("chiave"));
	}
	
	@Test
	public void PrendiConDueParametri() {
		setUp();
		partita.setStanzaCorrente(stanza);
		stanza.addAttrezzo(attrezzo);
		stanza.addAttrezzo(new Attrezzo("lanterna", 5));
		comando.setParametro("attrezzo");
		comando.esegui(partita);
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("attrezzo"));
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("lanterna"));
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("attrezzo"));
		assertTrue(partita.getStanzaCorrente().hasAttrezzo("lanterna"));
		
		comando.setParametro("lanterna");
		comando.esegui(partita);
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("lanterna"));
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("attrezzo"));
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("attrezzo"));
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("lanterna"));
	}
	
	@Test
	public void PrendiConBorsaPiena() {
		setUp();
		partita.setStanzaCorrente(stanza);
		stanza.addAttrezzo(new Attrezzo("lanterna", 9));
		comando.setParametro("lanterna");
		comando.esegui(partita);
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("lanterna"));
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("lanterna"));
		stanza.addAttrezzo(new Attrezzo("chiave", 5));
		comando.setParametro("chiave");
		comando.esegui(partita);
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("chiave"));
		assertTrue(partita.getStanzaCorrente().hasAttrezzo("chiave"));
	}
}


