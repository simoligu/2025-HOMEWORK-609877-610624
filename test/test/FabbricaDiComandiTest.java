package test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.comandi.*;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;

class FabbricaDiComandiFisarmonicaTest {

	private FabbricaDiComandiFisarmonica fabbrica;

	@BeforeEach
	void setUp() {
		IO io = new IOConsole();
		fabbrica = new FabbricaDiComandiFisarmonica(io);
	}

	@Test
	void testCostruttore() {
		assertNotNull(fabbrica);
	}

	@Test
	void testComandoVaiConParametro() {
		Comando comando = fabbrica.costruisciComando("vai nord");
		assertTrue(comando instanceof ComandoVai);
		assertEquals("nord", comando.getParametro());
	}

	@Test
	void testComandoPrendiConParametro() {
		Comando comando = fabbrica.costruisciComando("prendi chiave");
		assertTrue(comando instanceof ComandoPrendi);
		assertEquals("chiave", comando.getParametro());
	}

	@Test
	void testComandoPosaConParametro() {
		Comando comando = fabbrica.costruisciComando("posa libro");
		assertTrue(comando instanceof ComandoPosa);
		assertEquals("libro", comando.getParametro());
	}

	@Test
	void testComandoAiutoSenzaParametro() {
		Comando comando = fabbrica.costruisciComando("aiuto");
		assertTrue(comando instanceof ComandoAiuto);
		assertNull(comando.getParametro());
	}

	@Test
	void testComandoFineSenzaParametro() {
		Comando comando = fabbrica.costruisciComando("fine");
		assertTrue(comando instanceof ComandoFine);
		assertNull(comando.getParametro());
	}

	@Test
	void testComandoGuarda() {
		Comando comando = fabbrica.costruisciComando("guarda");
		assertTrue(comando instanceof ComandoGuarda);
		assertNull(comando.getParametro());
	}

	@Test
	void testIstruzioneVuota() {
		Comando comando = fabbrica.costruisciComando("");
		assertTrue(comando instanceof ComandoNonValido);
		assertNull(comando.getParametro());
	}

	@Test
	void testComandoConTroppiParametri() {
		Comando comando = fabbrica.costruisciComando("vai nord est");
		assertTrue(comando instanceof ComandoVai);
		assertEquals("nord", comando.getParametro());
	}

	@Test
	void testComandoNonValido() {
		Comando comando = fabbrica.costruisciComando("bau");
		assertTrue(comando instanceof ComandoNonValido);
	}
}
