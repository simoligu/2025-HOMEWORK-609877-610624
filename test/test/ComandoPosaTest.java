package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoPosa;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPosaTest {
	private Partita partita;
	private Stanza stanza;
	private IO ioConsole;
	private Comando comando;
	private Attrezzo attrezzo;
	private Borsa borsa;
	
	@BeforeEach
	public void setUp(){
		partita = new Partita();
		stanza = new Stanza("aula");
		comando = new ComandoPosa();
		ioConsole = new IOConsole();
		attrezzo = new Attrezzo("attrezzo", 2);
		borsa = new Borsa();
	}
	
	@Test
	public void posaConParametro() {
		setUp();
		partita.setStanzaCorrente(stanza);
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		comando.setParametro("attrezzo");
		comando.esegui(partita);
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("attrezzo"));
		assertTrue(partita.getStanzaCorrente().hasAttrezzo("attrezzo"));
		assertEquals(0,partita.getGiocatore().getBorsa().getPeso());
	}
	@Test
	public void posaSenzaParametro() {
		setUp();
		partita.setStanzaCorrente(stanza);
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		comando.setParametro(null);
		comando.esegui(partita);
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("attrezzo"));
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("attrezzo"));
		assertEquals(2, partita.getGiocatore().getBorsa().getPeso());
	}
	@Test
	public void posaConParametroErrato() {
		setUp();
		partita.setStanzaCorrente(stanza);
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		comando.setParametro("chiave");
		comando.esegui(partita);
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("attrezzo"));
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("chiave"));
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("attrezzo"));
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("chiave"));
	}
	@Test
	public void posaDueAttrezziConParametro() {
		setUp();
		partita.setStanzaCorrente(stanza);
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		partita.getGiocatore().getBorsa().addAttrezzo(new Attrezzo("lanterna", 5));
		comando.setParametro("attrezzo");
		comando.esegui(partita);
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("attrezzo"));
		assertTrue(partita.getStanzaCorrente().hasAttrezzo("attrezzo"));
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("lanterna"));
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("lanterna"));
		comando.setParametro("lanterna");
		comando.esegui(partita);
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("attrezzo"));
		assertTrue(partita.getStanzaCorrente().hasAttrezzo("attrezzo"));
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("lanterna"));
		assertTrue(partita.getStanzaCorrente().hasAttrezzo("lanterna"));
	}
	@Test
	public void posaConStanzaPiena() {
		setUp();
		partita.setStanzaCorrente(stanza);
		stanza.addAttrezzo(new Attrezzo("attrezzo 1", 1));
		stanza.addAttrezzo(new Attrezzo("attrezzo 2", 1));
		stanza.addAttrezzo(new Attrezzo("attrezzo 3", 1));
		stanza.addAttrezzo(new Attrezzo("attrezzo 4", 1));
		stanza.addAttrezzo(new Attrezzo("attrezzo 5", 1));
		assertTrue(partita.getStanzaCorrente().hasAttrezzo("attrezzo 5"));
		stanza.addAttrezzo(new Attrezzo("attrezzo 6", 1));
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("attrezzo 7"));
		stanza.addAttrezzo(new Attrezzo("attrezzo 7", 1));
		stanza.addAttrezzo(new Attrezzo("attrezzo 8", 1));
		stanza.addAttrezzo(new Attrezzo("attrezzo 9", 1));
		stanza.addAttrezzo(new Attrezzo("attrezzo 10", 1));
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		comando.setParametro("attrezzo");
		comando.esegui(partita);
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("attrezzo"));
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("attrezzo"));
	}
}
