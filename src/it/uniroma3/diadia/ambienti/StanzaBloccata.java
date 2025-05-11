package it.uniroma3.diadia.ambienti;


import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.attrezzi.Attrezzo;

//Stanza atrio = new StanzaBloccata("Atrio", "chiave", "nord");

public class StanzaBloccata extends Stanza{
	String chiave;
	String direzioneBloccata;
	IOConsole io = new IOConsole();
	public StanzaBloccata(String nome, String chiave, String direzioneBloccata) {
		super(nome);
		this.chiave = chiave;
		this.direzioneBloccata = direzioneBloccata;
	}

	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(direzione.equals(direzioneBloccata) && !this.hasAttrezzo(chiave)) {
			return this;
		}
		return super.getStanzaAdiacente(direzione);
	}
	@Override
	public String getDescrizione() {
		String bloccato = new String();
		bloccato = "Nella direzione "+this.direzioneBloccata+" c'è una serratura, serve una chiave per aprirla.";
		if(!this.hasAttrezzo(chiave)) {
			return super.getDescrizione() + "\n" +bloccato;
		}
		return super.getDescrizione();
	}
}

