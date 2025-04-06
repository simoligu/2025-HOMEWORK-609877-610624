package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai","aiuto","fine","prendi","posa"};

	private Partita partita;
	private IOConsole ioConsole;		//dichiarazione di ioconsole

	public DiaDia(IOConsole ioConsole) {
		this.partita = new Partita();
		this.ioConsole = ioConsole;		//inizializzo l'istanza di ioconsole a quella che gli viene passata dal costruttore
	}

	public void gioca() {
		String istruzione; 
//		Scanner scannerDiLinee;		//rimuovo lo scanner perchè ora farà tutto ioConsole

		ioConsole.mostraMessaggio(MESSAGGIO_BENVENUTO);		//stampa il messaggio tramite ioConsole.mostraMessaggio
//		scannerDiLinee = new Scanner(System.in);		
		do		
			istruzione = ioConsole.leggiRiga();				//leggi input tramite ioConsole.leggiRiga
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);
		if(comandoDaEseguire.getNome()!=null)		//entra nel secondo if solo se il comando inserito è diverso da null 
			if (comandoDaEseguire.getNome().equals("fine")) {
				this.fine(); 
				return true;
			} else if (comandoDaEseguire.getNome().equals("vai"))
				this.vai(comandoDaEseguire.getParametro());
			else if (comandoDaEseguire.getNome().equals("prendi"))
				this.prendi(comandoDaEseguire.getParametro());
			else if (comandoDaEseguire.getNome().equals("posa"))
				this.posa(comandoDaEseguire.getParametro());
			else if (comandoDaEseguire.getNome().equals("aiuto"))
				this.aiuto();
			else
				ioConsole.mostraMessaggio("Comando sconosciuto");
		
			if(this.partita.isFinita()) {
				if(this.partita.vinta()) {
					ioConsole.mostraMessaggio("CONGRATULAZIONI HAI VINTO!");
				}
				else {
				ioConsole.mostraMessaggio("HAI PERSO! CFU ESAURITI");
				}
				return true;
			}
			return false;
	}   
	private void prendi(String nomeAttrezzo) {
		Stanza stanzaCorrente=this.partita.getStanzaCorrente();
		Attrezzo attrezzo=stanzaCorrente.getAttrezzo(nomeAttrezzo);
		if(attrezzo!=null) {
			boolean aggiunto=this.partita.getGiocatore().prendiAttrezzo(attrezzo,stanzaCorrente);
			if(aggiunto) {
				ioConsole.mostraMessaggio("Hai preso: "+nomeAttrezzo+". Peso borsa: "+this.partita.getGiocatore().getBorsa().getPeso()+"Kg/"+this.partita.getGiocatore().getBorsa().getPesoMax()+"Kg");
			}
			else {
				ioConsole.mostraMessaggio("impossibile prendere "+nomeAttrezzo+" perchè non hai abbastanza spazio.");
			}
		}
		else {
			ioConsole.mostraMessaggio("L`attrezzo non è presente nella stanza");
		}
	}
	private void posa(String nomeAttrezzo) {
		Borsa borsa=this.partita.getGiocatore().getBorsa();
		Attrezzo attrezzo=borsa.getAttrezzo(nomeAttrezzo);
		if(attrezzo!=null) {
			boolean	posato=this.partita.getGiocatore().posaAttrezzo(attrezzo,this.partita.getStanzaCorrente());
			if(posato) {
				ioConsole.mostraMessaggio("Hai posato: "+nomeAttrezzo+". Peso borsa: "+this.partita.getGiocatore().getBorsa().getPeso()+"Kg/"+this.partita.getGiocatore().getBorsa().getPesoMax()+"Kg");
			}
			else {
				ioConsole.mostraMessaggio("impossibile posare: "+nomeAttrezzo);
			}
		}
		else {
			ioConsole.mostraMessaggio("L`attrezzo non è presente nella Borsa");
		}
	}
	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			System.out.print(elencoComandi[i]+" ");
		System.out.println();
	}
	

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null) {
			ioConsole.mostraMessaggio("Dove vuoi andare ?");
		}

		Stanza prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null) {
			ioConsole.mostraMessaggio("Direzione inesistente");
		}
		else {
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(--cfu);
			ioConsole.mostraMessaggio("CFU rimanenti: " +cfu);
		}
		if(prossimaStanza!=null) {
			this.partita.setStanzaCorrente(prossimaStanza);
			ioConsole.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		}
	}

	
	/**
	 * Comando "Fine".
	 */
	private void fine() {
		ioConsole.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		IOConsole ioConsole = new IOConsole();		//creo un'istanza di ioconsole
		DiaDia gioco = new DiaDia(ioConsole);		//passo l'istanza di ioconsole al costruttore di diadia
		gioco.gioca();
	}
}