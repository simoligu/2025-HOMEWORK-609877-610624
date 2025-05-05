package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IOConsole;

public class ComandoPrendi implements Comando{
	IOConsole ioConsole = new IOConsole();
	String nomeAttrezzo;
	public void esegui(Partita partita) {
		Stanza stanzaCorrente=partita.getStanzaCorrente();
		Attrezzo attrezzo=stanzaCorrente.getAttrezzo(nomeAttrezzo);
		if(attrezzo!=null) {
			boolean aggiunto=partita.getGiocatore().prendiAttrezzo(attrezzo,stanzaCorrente);
			if(aggiunto) {
				ioConsole.mostraMessaggio("Hai preso: "+nomeAttrezzo+". Peso borsa: "+partita.getGiocatore().getBorsa().getPeso()+"Kg/"+partita.getGiocatore().getBorsa().getPesoMax()+"Kg");
			}
			else {
				ioConsole.mostraMessaggio("impossibile prendere "+nomeAttrezzo+" perchè non hai abbastanza spazio.");
			}
		}
		else {
			ioConsole.mostraMessaggio("L`attrezzo non è presente nella stanza");
		}
	}
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}
	@Override
	public void getNome() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void getParametro() {
		// TODO Auto-generated method stub
		
	}
}