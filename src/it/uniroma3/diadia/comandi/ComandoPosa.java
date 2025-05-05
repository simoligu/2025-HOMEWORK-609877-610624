package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IOConsole;

public class ComandoPosa implements Comando{
	IOConsole ioConsole = new IOConsole();
	String nomeAttrezzo;
	public void esegui(Partita partita) {
		Borsa borsa=partita.getGiocatore().getBorsa();
		Attrezzo attrezzo=borsa.getAttrezzo(nomeAttrezzo);
		if(attrezzo!=null) {
			boolean	posato=partita.getGiocatore().posaAttrezzo(attrezzo,partita.getStanzaCorrente());
			if(posato) {
				ioConsole.mostraMessaggio("Hai posato: "+nomeAttrezzo+". Peso borsa: "+partita.getGiocatore().getBorsa().getPeso()+"Kg/"+partita.getGiocatore().getBorsa().getPesoMax()+"Kg");
			}
			else {
				ioConsole.mostraMessaggio("impossibile posare: "+nomeAttrezzo);
			}
		}
		else {
			ioConsole.mostraMessaggio("L`attrezzo non è presente nella Borsa");
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

