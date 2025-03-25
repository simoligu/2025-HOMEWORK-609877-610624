import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StanzaTest {
	
	@Test
	public void AggiungiStanzaAdiacente() {
		//creo 3 stanze di cui 1 di partenza, e 2 adiacenti su 2 direzioni diverse
		Stanza stanza1 = new Stanza("Stanza 1");
		Stanza stanza2 = new Stanza("Stanza 2");
		Stanza stanza3 = new Stanza("Stanza 3");
		//imposto stanza 2 a sud di stanza 1
		stanza1.impostaStanzaAdiacente("sud", stanza2);
		//verifico che stanza 2 sia stata inserita a sud di stanza 1
		assertEquals(stanza2, stanza1.getStanzaAdiacente("sud"));
		//imposto stanza 3 a est di stanza 1
		stanza1.impostaStanzaAdiacente("est", stanza3);
		//verifico che stanza 3 sia stata inserita a sud di stanza 1
		assertEquals(stanza3, stanza1.getStanzaAdiacente("est"));
	}
	
	@Test
    public void AggiornaStanzaAdiacenteAssegnata() {
    	//Creo 2 stanze per effettuare il test
    	Stanza stanza1 = new Stanza("Stanza 1");
    	Stanza stanza2 = new Stanza("Stanza 2");
    	
    	//imposto una stanza adiacente alla stanza 1
    	stanza1.impostaStanzaAdiacente("nord", stanza2);
    	//verifico che la stanza adiacente sia stata associata con successo
    	assertEquals(stanza2, stanza1.getStanzaAdiacente("nord"));
    	//creo una nuova stanza per aggiornare quella inserita
    	Stanza stanza3 = new Stanza("Stanza 3");
    	//Aggiorno la stanza adiacente alla stanza 1 in direzione nord
    	stanza1.impostaStanzaAdiacente("nord", stanza3);
    	//verifico che la stanza 3 sia stata impostata correttamente
    	assertEquals(stanza3, stanza1.getStanzaAdiacente("nord"));
    }
	
	@Test
	public void limiteStanzeAdiacenti() {
		Stanza stanza1 = new Stanza("Stanza di partenza");
		
		for(int i=0; i<Stanza.getNumeroMassimoDirezioni(); i++) {
			Stanza stanza = new Stanza("Stanza " +(i+1));
			stanza1.impostaStanzaAdiacente("direzione "+i, stanza);
		}
		Stanza stanzaExtra = new Stanza("Stanza extra");
		stanza1.impostaStanzaAdiacente("extra", stanzaExtra);
		
		assertNull(stanza1.getStanzaAdiacente("extra"));
	}
	
	//questo test verifica che una stanza in cui non sia stata impostata alcuna stanza adiacente, non abbia effettivamente nessuna stanza adiacente
	@Test
	public void nessunaStanzaAdiacente() {
		Stanza stanza1 = new Stanza("Stanza di partenza");
		String direzioni[] = stanza1.getDirezioni();
		for(int i=0;i<direzioni.length;i++) {
			assertNull(stanza1.getStanzaAdiacente(direzioni[i]));	
		}
	}
	
	@Test
	public void aggiungiAttrezzo() {
		Stanza stanza = new Stanza("Stanza di prova");
		Attrezzo attrezzo = new Attrezzo("Palla", 1);
		boolean aggiunto = stanza.addAttrezzo(attrezzo);
		assertTrue(aggiunto);
		assertTrue(stanza.hasAttrezzo("Palla"));
	}
	
	@Test
	public void limiteAttrezzi() {
		//creo stanza di prova
		Stanza stanza = new Stanza("Stanza di prova");
		//riempio la stanza con il numero massimo di attrezzi
		for(int i=0;i<Stanza.getNumeroMassimoAttrezzi();i++) {
			stanza.addAttrezzo(new Attrezzo("Attrezzo" +(i+1), i));
		}
		//creo un attrezzo extra
		Attrezzo attrezzoExtra = new Attrezzo("Extra", 10);
		//assegno alla variabile booleana AGGIUNTO, l'esito del tentativo di aggiungere l'attrezzo extra alla stanza
		boolean aggiunto = stanza.addAttrezzo(attrezzoExtra);
		//verifico che la variabile booleana abbia assunto il valore "false"
		assertFalse(aggiunto);
	}
	
	@Test
	public void ricercaAttrezzoPresente() {
		//creo stanza e attrezzo di prova
		Stanza stanza = new Stanza("Stanza di prova");
		Attrezzo attrezzo = new Attrezzo("Roccia", 10);
		//aggiungo l'attrezzo alla stanza
		stanza.addAttrezzo(attrezzo);
		//se il metodo getAttrezzo trova un attrezzo con quel nome, attrezzoRecuperato viene eguagliato all'attrezzo trovato
		Attrezzo attrezzoRecuperato = stanza.getAttrezzo("Roccia");
		//verifico che quindi attrezzoRecuperato non sia null e abbia quindi un valore
		assertNotNull(attrezzoRecuperato);
		//verifico che attrezzoRecuperato abbia assunto il nome cercato tramite il metodo getNome
		assertEquals("Roccia", attrezzoRecuperato.getNome());
	}
	
	@Test
	public void ricercaAttrezzoInesistente() {
		//creo stanza di prova
		Stanza stanza = new Stanza("Stanza di prova");
		//cerco nella stanza un attrezzo che non è presente
		Attrezzo attrezzoRecuperato = stanza.getAttrezzo("Porta");
		//verifico che la variabile attrezzoRecuperato sia rimasta vuota perchè non ho trovato l'attrezzo cercato
		assertNull(attrezzoRecuperato);
	}
	
	@Test
	public void testHasAttrezzo() {
		Stanza stanza = new Stanza("Stanza di prova");
		Attrezzo attrezzo = new Attrezzo("Computer", 1);
		stanza.addAttrezzo(attrezzo);
		assertTrue(stanza.hasAttrezzo("Computer"));
		assertFalse(stanza.hasAttrezzo("Scatola"));
	}
}

	