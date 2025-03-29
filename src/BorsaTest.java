import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

class BorsaTest {

	@Test
	public void testRemoveAttrezzo() {
	    Borsa borsa = new Borsa();
	    Attrezzo spada = new Attrezzo("Spada", 5);
	    Attrezzo scudo = new Attrezzo("Scudo", 8);
	    
	    // Aggiungi attrezzi alla borsa
	    borsa.addAttrezzo(spada);
	    borsa.addAttrezzo(scudo);
	    
	    // Rimuovi l'attrezzo "Spada"
	    Attrezzo attrezzoRimosso = borsa.removeAttrezzo("Spada");
	    
	    // Verifica che l'attrezzo rimosso sia quello giusto
	    assertEquals("Spada", attrezzoRimosso.getNome());
	    
	    // Verifica che la borsa non contenga più "Spada"
	    assertNull(borsa.getAttrezzo("Spada"));
	    
	    // Verifica che la borsa contenga ancora "Scudo"
	    assertNotNull(borsa.getAttrezzo("Scudo"));
	}
	
	@Test
	public void testRemoveAttrezzoRiduceNumeroAttrezzi() {
	    Borsa borsa = new Borsa();
	    Attrezzo spada = new Attrezzo("Spada", 5);
	    Attrezzo scudo = new Attrezzo("Scudo", 8);
	    
	    // Aggiungi attrezzi alla borsa
	    borsa.addAttrezzo(spada);
	    borsa.addAttrezzo(scudo);
	    
	    // Verifica che inizialmente la borsa contenga due attrezzi
	    assertEquals(2, borsa.getNumeroAttrezzi());
	    
	    // Rimuovi l'attrezzo "Spada"
	    borsa.removeAttrezzo("Spada");
	    
	    // Verifica che il numero di attrezzi nella borsa sia ora 1
	    assertEquals(1, borsa.getNumeroAttrezzi());
	    
	    // Verifica che la borsa contenga ancora "Scudo"
	    assertNotNull(borsa.getAttrezzo("Scudo"));
	}


}
