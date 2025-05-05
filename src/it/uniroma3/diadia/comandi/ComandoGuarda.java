package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IO;

public class ComandoGuarda implements Comando{
	private IO io;
	public void esegui(Partita partita) {
		io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		io.mostraMessaggio(partita.getGiocatore().toString());
		io.mostraMessaggio(partita.getCfu()+"cfu");
	}
	public void setParametro(String parametro) {
		
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
