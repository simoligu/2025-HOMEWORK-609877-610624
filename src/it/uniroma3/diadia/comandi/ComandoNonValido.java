package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IOConsole;
public class ComandoNonValido implements Comando{
	public void esegui(Partita partita) {
		System.out.println("Comando non valido.");
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
