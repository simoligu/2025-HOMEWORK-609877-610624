package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IOConsole;

public class ComandoVai implements Comando{
	IOConsole ioConsole = new IOConsole();		//creo un'istanza di ioconsole
	private String direzione;
	public void esegui(Partita partita) {

		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza =	null;
		if(direzione==null) {
			ioConsole.mostraMessaggio("Dove vuoi andare ?");
		}
		prossimaStanza = partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null) {
			ioConsole.mostraMessaggio("Direzione inesistente");
			return;
		}
		else {
			int cfu = partita.getGiocatore().getCfu();
			partita.getGiocatore().setCfu(--cfu);
//			ioConsole.mostraMessaggio("CFU rimanenti: " +cfu);
		}
		if(prossimaStanza!=null) {
			partita.setStanzaCorrente(prossimaStanza);
//			ioConsole.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
			ioConsole.mostraMessaggio(partita.getStanzaCorrente().getNome());
		}
	}
	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
		
	}
	@Override
	public String getNome() {
		return direzione;
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getParametro() {
		return direzione;
		// TODO Auto-generated method stub
		
	}
}