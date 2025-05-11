package testAccettazione;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class IOSimulatorTest {
	@Test
	public void testSimulazionePartita() {
		String[] comandi = {"vai nord", "prendi chiave", "fine"};
		IOSimulator io = new IOSimulator(comandi);

		// Simulazione di gioco: solo per esempio
		io.mostraMessaggio("Sei nell'atrio");
		assertEquals("vai nord", io.leggiRiga());

		io.mostraMessaggio("Sei in aula N11");
		assertEquals("prendi chiave", io.leggiRiga());

		io.mostraMessaggio("Hai preso la chiave");
		assertEquals("fine", io.leggiRiga());

		assertEquals("Sei nell'atrio", io.nextMessaggio());
		assertEquals("Sei in aula N11", io.nextMessaggio());
		assertEquals("Hai preso la chiave", io.nextMessaggio());
		assertFalse(io.hasNextMessaggio());
	}
}