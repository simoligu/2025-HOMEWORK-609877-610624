package test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;
public class PartitaTest {
	//partitatest
	@Test
	public void testGetStanzaCorrente() {
	    Partita partita = new Partita();
	    Stanza stanza = partita.getStanzaCorrente();
	    assertNotNull(stanza);
	}

	@Test
	public void testGetStanzaCorrenteNome() {
	    Partita partita = new Partita();
	    assertEquals("Atrio", partita.getStanzaCorrente().getNome());
	}

	@Test
	public void testGetStanzaCorrenteIniziale() {
	    Partita partita = new Partita();
	    Stanza stanza = partita.getStanzaCorrente();
	    assertTrue(stanza.getNome().equals("Atrio"));
	}
	@Test
	public void testGetStanzaVincente() {
	    Partita partita = new Partita();
	    Stanza stanza = partita.getStanzaVincente();
	    assertNotNull(stanza);
	}

	@Test
	public void testGetStanzaVincenteNome() {
	    Partita partita = new Partita();
	    assertEquals("Biblioteca", partita.getStanzaVincente().getNome());
	}

	@Test
	public void TestGetStanzaVincenteIniziale() {
	    Partita partita = new Partita();
	    Stanza stanza = partita.getStanzaVincente();
	    assertTrue(stanza.getNome().equals("Biblioteca"));
	}
	@Test
	public void TestGetStanzaVincente() {
	    Partita partita = new Partita();
	    Stanza stanza = partita.getStanzaVincente();
	    assertNotNull(stanza);
	}

	@Test
	public void TestGetStanzaVincenteNome() {
	    Partita partita = new Partita();
	    assertEquals("Biblioteca", partita.getStanzaVincente().getNome());
	}

	@Test
	public void testGetStanzaVincenteIniziale() {
	    Partita partita = new Partita();
	    Stanza stanza = partita.getStanzaVincente();
	    assertTrue(stanza.getNome().equals("Biblioteca"));
	}
	@Test
	public void testSetStanzaCorrente() {
	    Partita partita = new Partita();
	    Stanza nuovaStanza = new Stanza("Aula N11");
	    partita.setStanzaCorrente(nuovaStanza);
	    assertEquals("Aula N11", partita.getStanzaCorrente().getNome());
	}

	@Test
	public void testSetStanzaCorrenteNull() {
	    Partita partita = new Partita();
	    partita.setStanzaCorrente(null);
	    assertNull(partita.getStanzaCorrente());
	}

	@Test
	public void testSetStanzaCorrenteDiversa() {
	    Partita partita = new Partita();
	    Stanza nuovaStanza = new Stanza("Laboratorio");
	    partita.setStanzaCorrente(nuovaStanza);
	    assertEquals("Laboratorio", partita.getStanzaCorrente().getNome());
	}
	@Test
	public void testGetGiocatore() {
	    Partita partita = new Partita();
	    Giocatore giocatore = partita.getGiocatore();
	    assertNotNull(giocatore);
	    assertEquals("Mario", giocatore.getNome());
	}

	@Test
	public void testGetGiocatoreCFU() {
	    Partita partita = new Partita();
	    Giocatore giocatore = partita.getGiocatore();
	    assertEquals(20, giocatore.getCfu());
	}

	@Test
	public void testGetGiocatoreNome() {
	    Partita partita = new Partita();
	    Giocatore giocatore = partita.getGiocatore();
	    assertEquals("Mario", giocatore.getNome());
	}
	@Test
	public void testVinta() {
	    Partita partita = new Partita();
	    partita.setStanzaCorrente(partita.getStanzaVincente());
	    assertTrue(partita.vinta());
	}

	@Test
	public void testNonVinta() {
	    Partita partita = new Partita();
	    assertFalse(partita.vinta());
	}

	@Test
	public void testVintaQuandoStanzaCorrenteUguale() {
	    Partita partita = new Partita();
	    partita.setStanzaCorrente(partita.getStanzaVincente());
	    assertTrue(partita.vinta());
	}
	@Test
	public void testIsFinitaNonFinita() {
	    Partita partita = new Partita();
	    assertFalse(partita.isFinita());
	}

	@Test
	public void testIsFinitaVinta() {
	    Partita partita = new Partita();
	    partita.setStanzaCorrente(partita.getStanzaVincente());
	    assertTrue(partita.isFinita());
	}

	@Test
	public void testIsFinitaConCFUZero() {
	    Partita partita = new Partita();
	    partita.getGiocatore().setCfu(0);
	    assertTrue(partita.isFinita());
	}
	@Test
	public void testSetFinita() {
	    Partita partita = new Partita();
	    partita.setFinita();
	    assertTrue(partita.isFinita());
	}

	@Test
	public void testSetFinitaDueVolte() {
	    Partita partita = new Partita();
	    partita.setFinita();
	    partita.setFinita();
	    assertTrue(partita.isFinita());
	}

	@Test
	public void testSetFinitaNonFinitaInizialmente() {
	    Partita partita = new Partita();
	    assertFalse(partita.isFinita());
	    partita.setFinita();
	    assertTrue(partita.isFinita());
	}
	@Test
	public void testGetCfu() {
	    Partita partita = new Partita();
	    assertEquals(20, partita.getCfu());
	}

	@Test
	public void testGetCfuModificato() {
	    Partita partita = new Partita();
	    partita.setCfu(15);
	    assertEquals(15, partita.getCfu());
	}

	@Test
	public void testGetCfuDopoCambio() {
	    Partita partita = new Partita();
	    partita.setCfu(10);
	    assertEquals(10, partita.getCfu());
	}
	@Test
	public void testSetCfu() {
	    Partita partita = new Partita();
	    partita.setCfu(10);
	    assertEquals(10, partita.getCfu());
	}

	@Test
	public void testSetCfuNegativo() {
	    Partita partita = new Partita();
	    partita.setCfu(-5);
	    assertEquals(-5, partita.getCfu());
	}

	@Test
	public void testSetCfuZero() {
	    Partita partita = new Partita();
	    partita.setCfu(0);
	    assertEquals(0, partita.getCfu());
	}

}
