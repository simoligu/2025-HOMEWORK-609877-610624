package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IOConsole;

public class ComandoGuarda implements Comando{
	private IOConsole io = new IOConsole();
	public void esegui(Partita partita) {
		io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		io.mostraMessaggio(partita.getGiocatore().toString());
//		io.mostraMessaggio(partita.getCfu()+"cfu");
	}
	public void setParametro(String parametro) {
		
	}
	@Override
	public String getNome() {
		return null;
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getParametro() {
		return null;
		// TODO Auto-generated method stub
		
	}
}
