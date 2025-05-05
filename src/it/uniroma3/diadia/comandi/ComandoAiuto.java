package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IOConsole;

public class ComandoAiuto implements Comando{
	public void esegui(Partita partita) {
		String[] elencoComandi = {"vai","aiuto","fine","prendi","posa","guarda"};
		for(int i=0; i< elencoComandi.length; i++) 
			System.out.print(elencoComandi[i]+" ");
		System.out.println();
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		
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
