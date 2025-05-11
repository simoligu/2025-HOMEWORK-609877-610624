package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoVai;

public class ComandoVaiTest {
	private Partita partita;
	private Stanza stanza1;
	private Stanza stanza2;
	private IO ioConsole;
	private Comando comando;
	
	@BeforeEach
	void setUp() {
		partita = new Partita();
		stanza1 = new Stanza("aula1");
		stanza2 = new Stanza("aula2");
		comando = new ComandoVai();
		ioConsole = new IOConsole();
	}
	
	@Test
	public void testVaiStanzaDirezione() {
		setUp();
		partita.setStanzaCorrente(stanza1);
		stanza1.impostaStanzaAdiacente("nord", stanza2);
		comando.setParametro("nord");
		comando.esegui(partita);
		assertEquals(stanza2, partita.getStanzaCorrente());
	}
	
	@Test
	public void testVaiInDirezioneSbagliata() {
		setUp();
		partita.setStanzaCorrente(stanza1);
		stanza1.impostaStanzaAdiacente("sud", stanza2);
		comando.setParametro("nord");
		comando.esegui(partita);
		assertNotEquals(stanza2, partita.getStanzaCorrente());
	}
	
	@Test
	public void testDirezioneNull() {
		setUp();
		partita.setStanzaCorrente(stanza1);
		stanza1.impostaStanzaAdiacente("nord", stanza2);
		comando.setParametro(null);
		comando.esegui(partita);
		assertEquals(stanza1, partita.getStanzaCorrente());
	}
	public void testVaiInDirezioneInesistente() {
		setUp();
		partita.setStanzaCorrente(stanza1);
		stanza1.impostaStanzaAdiacente("nord", stanza2);
		comando.setParametro("nordnord");
		comando.esegui(partita);
		assertEquals(stanza1, partita.getStanzaCorrente());
		comando.setParametro("nord");
		comando.esegui(partita);
		assertEquals(stanza2, partita.getStanzaCorrente());
	}
}

