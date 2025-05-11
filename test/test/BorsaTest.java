package test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

class BorsaTest {

	@Test
	public void testRemoveAttrezzo() {
	    Borsa borsa = new Borsa();
	    Attrezzo spada = new Attrezzo("Spada", 5);
	    
	    // Aggiungi attrezzi alla borsa
	    borsa.addAttrezzo(spada);
	    
	    //Verifica che la borsa contenga l'attrezzo "Spada"
	    assertNotNull("Spada");
	    
	    // Rimuovi l'attrezzo "Spada"
	    Attrezzo attrezzoRimosso = borsa.removeAttrezzo("Spada");
	    
	    // Verifica che l'attrezzo rimosso sia quello giusto
	    assertEquals("Spada", attrezzoRimosso.getNome());
	    
	    // Verifica che la borsa non contenga più "Spada"
	    assertNull(borsa.getAttrezzo("Spada"));
	}
	
	@Test
	public void testRemoveAttrezzoRiduceNumeroAttrezzi() {
	    Borsa borsa = new Borsa();
	    Attrezzo spada = new Attrezzo("Spada", 5);
	    Attrezzo scudo = new Attrezzo("Scudo", 4);
	    
	    // Aggiungi attrezzi alla borsa
	    borsa.addAttrezzo(spada);
	    borsa.addAttrezzo(scudo);
	    
	    // Verifica che inizialmente la borsa contenga due attrezzi
	    assertEquals(2, borsa.getNumeroAttrezzi());
	    
	    // Rimuovi l'attrezzo "Spada"
	    borsa.removeAttrezzo("Spada");
	    
	    // Verifica che ora la borsa non contenga più "Spada"
	    assertFalse(borsa.hasAttrezzo("Spada"));
	    
	    // Verifica che il numero di attrezzi nella borsa sia ora 1
	    assertEquals(1, borsa.getNumeroAttrezzi());
	    
	    // Verifica che la borsa contenga ancora "Scudo"
	    assertNotNull(borsa.getAttrezzo("Scudo"));
	}
	
	@Test
	public void testPesoBorsa() {
		Borsa borsa = new Borsa();
	    Attrezzo spada = new Attrezzo("Spada", 5);
	    Attrezzo scudo = new Attrezzo("Scudo", 4);
	    
	    // Aggiungi attrezzi alla borsa
	    borsa.addAttrezzo(spada);
	    borsa.addAttrezzo(scudo);
	    
	    //verifica che la borsa abbia il peso corretto
	    assertEquals(9, borsa.getPeso());
	}
	
	@Test
	public void testPesoMaxBorsa() {
		Borsa borsa = new Borsa();
		Attrezzo spada = new Attrezzo("Spada", 5);
		Attrezzo scudo = new Attrezzo("Scudo", 5);
		// Questo attrezzo non deve essere aggiunto perchè il peso della borsa risulterebbe essere maggiore del peso massimo
		Attrezzo extra = new Attrezzo("Extra", 1);
		
		// Aggiungi attrezzi alla borsa
		borsa.addAttrezzo(spada);
	    borsa.addAttrezzo(scudo);
	    borsa.addAttrezzo(extra);
	    
	    // Verifica che il terzo attrezzo non sia stato aggiunto
	    assertNull(borsa.getAttrezzo("Extra"));
	    
	    // Verifica che il peso del terzo oggetto non influisca nel peso della borsa e che quindi quest'ultimo sia uguale a 10
	    assertEquals(10, borsa.getPeso());
	}
	
	@Test
	public void testIsEmpty() {
		Borsa borsa = new Borsa();
		
		// Verifica che la borsa sia vuota
		assertTrue(borsa.isEmpty());
		
		// aggiungi un attrezzo alla borsa
		Attrezzo attrezzo1 = new Attrezzo("attrezzo 1", 2);
		borsa.addAttrezzo(attrezzo1);
		
		// Verifica che ora non sia vuota
		assertFalse(borsa.isEmpty());
		
		// Rimuovi attrezzo1
		borsa.removeAttrezzo("attrezzo 1");
		
		// Verifica che ora sia nuovamente vuota
		assertTrue(borsa.isEmpty());
	}
	
	@Test
	public void testHasAttrezzo() {
		Borsa borsa = new Borsa();
		Attrezzo spada = new Attrezzo("Spada", 5);
		borsa.addAttrezzo(spada);
		//verifica che spada sia nella borsa e scudo no
		assertTrue(borsa.hasAttrezzo("Spada"));
		assertFalse(borsa.hasAttrezzo("Scudo"));
		
		// Rimuovo spada
		borsa.removeAttrezzo("Spada");
		// Verifico che ora non ci sia spada in borsa
		assertFalse(borsa.hasAttrezzo("Spada"));
	}
	
	@Test
	public void testRemoveAttrezzoNonEsistente() {
		Borsa borsa = new Borsa();
		Attrezzo spada = new Attrezzo("Spada", 5);
		borsa.addAttrezzo(spada);
		assertTrue(borsa.hasAttrezzo("Spada"));
		// rimuovo sia l'attrezzo esistente sia un attrezzo che non esiste
		borsa.removeAttrezzo("Spada");
		assertFalse(borsa.hasAttrezzo("Spada"));
		// Prima mi assicuro che scudo non ci sia in borsa
		assertFalse(borsa.hasAttrezzo("Scudo"));
		borsa.removeAttrezzo("Scudo");
	}
	
	@Test
	public void testGetPesoMax() {
		Borsa borsa = new Borsa();
		assertEquals(10, borsa.getPesoMax());
		
		// Creo una borsa con un peso personalizzato usando il secondo costruttore di Borsa
		Borsa borsa2 = new Borsa(15);
		assertEquals(15, borsa2.getPesoMax());
	}
	
	@Test
	public void aggiungiDueAttrezziConNomeUguale() {
		Borsa borsa = new Borsa();
		Attrezzo spada1 = new Attrezzo("Spada", 5);
		Attrezzo spada2 = new Attrezzo("Spada", 5);
		
		borsa.addAttrezzo(spada1);
		borsa.addAttrezzo(spada2);
		
		assertEquals(2, borsa.getNumeroAttrezzi());
	}
	
	@Test
	public void correttaGestioneRemoveAttrezzoBorsaVuota() {
		Borsa borsa = new Borsa();
		// Salvo l'attrezzo rimosso per verificare che questo sia nullo
		Attrezzo attrezzoRimosso = borsa.removeAttrezzo("Spada");
		assertNull(attrezzoRimosso);
	}
	
	@Test
	public void getAttrezzoNomeNonValido() {
		Borsa borsa = new Borsa();
		// Aggiungo alla borsa un attrezzo
		Attrezzo spada = new Attrezzo("Spada", 5);
		borsa.addAttrezzo(spada);
		// verifico che provando a ottenere dalla borsa un attrezzo con un nome non valido, ottengo un valore null
		assertNull(borsa.getAttrezzo("Scudo"));
	}
	
	@Test
	public void toStringBorsaVuota() {
		Borsa borsa = new Borsa();
		assertEquals("Borsa vuota", borsa.toString());
	}
	
	@Test
	public void toStringBorsaNonVuota() {
		Borsa borsa = new Borsa();
		Attrezzo spada = new Attrezzo("Spada", 5);
		Attrezzo scudo = new Attrezzo("Scudo", 4);
		borsa.addAttrezzo(spada);
		borsa.addAttrezzo(scudo);
		// Verifica che la rappresentazione della borsa includa gli attrezzi e il peso
		String expected = "Contenuto borsa ("+borsa.getPeso()+"kg/"+borsa.getPesoMax()+"kg): Spada (5kg) Scudo (4kg) ";
		assertEquals(expected, borsa.toString());
	}
}
