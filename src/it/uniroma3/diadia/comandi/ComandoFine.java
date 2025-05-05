package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IOConsole;

public class ComandoFine implements Comando{
	IOConsole ioConsole = new IOConsole();
	public void esegui(Partita partita) {
		ioConsole.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
		partita.setFinita();
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
