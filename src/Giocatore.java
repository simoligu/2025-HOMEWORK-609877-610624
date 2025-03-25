public class Giocatore {
	String nome;		
	int cfu;			//cfu del giocatore
	Borsa borsa;		//la borsa del giocatore
	
	public Giocatore(String nome, int CFUiniziali) {
		this.nome = nome;
		this.cfu = CFUiniziali;
		this.borsa = new Borsa();		//ogni giocatore ha la propria borsa
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getCfu() {
		return cfu;
	}
	
	public void setCfu(int cfu){
		this.cfu = cfu;
	}
	
	public boolean aggiungiAttrezzoAllaBorsa(Attrezzo attrezzo) {
		return this.borsa.addAttrezzo(attrezzo);
	}
	
	public Attrezzo removeAttrezzoDallaBorsa(String nomeAttrezzo) {
		return this.borsa.removeAttrezzo(nomeAttrezzo);
	}
	// Metodo per controllare se il giocatore ha un attrezzo nella sua borsa
    public boolean haAttrezzo(String nomeAttrezzo) {
        return this.borsa.hasAttrezzo(nomeAttrezzo);
    }
	//metodo per ottenere il contenuto della borsa
	public String getContenutoBorsa() {
		return this.borsa.toString();
	}
	//metodo per ottenere tutte le informazioni sul giocatore
	public String toString() {
		return "Giocatore: "+this.nome + ", CFU: " +this.cfu + ", Contenuto borsa: " +this.getContenutoBorsa();
	}
}
