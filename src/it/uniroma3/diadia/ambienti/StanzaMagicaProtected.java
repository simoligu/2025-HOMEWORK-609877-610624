package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaProtected extends StanzaProtected{
	
	private static final int SOGLIA_DEFAULT=3;
	private int contatoreAttrezzi;
	private int sogliaMagica;
	
	public StanzaMagicaProtected(String nome) {
	this(nome, SOGLIA_DEFAULT);
	}
	public StanzaMagicaProtected(String nome, int sogliaMagica) {
		super(nome);
		this.sogliaMagica = sogliaMagica;
		this.contatoreAttrezzi = 0;
	}

	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.contatoreAttrezzi >= this.sogliaMagica)
			attrezzo = modificaAttrezzo(attrezzo);

		if (this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI) {
			this.attrezzi[this.numeroAttrezzi] = attrezzo;
			this.numeroAttrezzi++;
			this.contatoreAttrezzi++;
			return true;
		}
		return false;
	}

	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		StringBuilder nomeInvertito;
		int pesoX2 = attrezzo.getPeso() * 2;
		nomeInvertito = new StringBuilder(attrezzo.getNome());
		nomeInvertito = nomeInvertito.reverse();
		attrezzo = new Attrezzo(nomeInvertito.toString(),pesoX2);
		return attrezzo;
	}
}
