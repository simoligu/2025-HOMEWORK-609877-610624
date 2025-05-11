package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaProtected {

	protected static final int NUMERO_MASSIMO_DIREZIONI = 4;
	protected static final int NUMERO_MASSIMO_ATTREZZI = 10;
	
	protected String nome;
	protected Attrezzo[] attrezzi;
	protected int numeroAttrezzi;
	
	protected StanzaProtected[] stanzeAdiacenti;
	protected int numeroStanzeAdiacenti;
	protected String[] direzioni;
	
	public StanzaProtected(String nome) {
		this.nome=nome;
		this.numeroStanzeAdiacenti=0;
		this.numeroAttrezzi=0;
		this.direzioni=new String[NUMERO_MASSIMO_DIREZIONI];
		this.stanzeAdiacenti=new StanzaProtected[NUMERO_MASSIMO_DIREZIONI];
		this.attrezzi=new Attrezzo[NUMERO_MASSIMO_ATTREZZI];
	}
	public String getNome() {
		return this.nome;
	}
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(this.numeroAttrezzi<NUMERO_MASSIMO_ATTREZZI) {
			this.attrezzi[numeroAttrezzi]=attrezzo;
			this.numeroAttrezzi++;
			return true;
		}
		return false;
	}
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append(this.nome);
		risultato.append("\nAttrezzi nella stanza: ");
		for(Attrezzo attrezzo:this.attrezzi) {
			if(attrezzo!=null) {
				risultato.append(attrezzo.toString()+" ");
			}
		}
		return risultato.toString();
	}
}
