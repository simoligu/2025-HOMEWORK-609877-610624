package test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;;
public class LabirintoTest {
	@Test
	public void testEntrata() {

		Labirinto labirinto = new Labirinto();
		assertEquals("Atrio", labirinto.entrata.getNome(), "La stanza di entrata dovrebbe essere 'Atrio'");
	}

	@Test
	public void testUscita() {
		Labirinto labirinto = new Labirinto();
		assertEquals("Biblioteca", labirinto.uscita.getNome(), "La stanza di uscita dovrebbe essere 'Biblioteca'");
	}

	@Test
	public void testStanzaAdiacenteNord() {
		Labirinto labirinto = new Labirinto();

		Stanza atrio = labirinto.entrata;
		Stanza biblioteca = labirinto.uscita;
		assertEquals(biblioteca, atrio.getStanzaAdiacente("nord"), "La stanza a nord di Atrio dovrebbe essere Biblioteca");
	}
}

