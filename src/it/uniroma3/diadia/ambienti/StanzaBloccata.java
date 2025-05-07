package it.uniroma3.diadia.ambienti;


import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccata extends Stanza{
	String chiave;
	String direzioneBloccata;
	String direzione;
	IOConsole io = new IOConsole();
	public StanzaBloccata(String nome, String chiave, String direzioneBloccata) {
		super(nome);
		this.chiave = chiave;
		this.direzioneBloccata = direzioneBloccata;
	}

	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(direzione.equals(direzioneBloccata) && !this.hasAttrezzo(chiave)) {
//			io.mostraMessaggio("Impossibile spostarsi in questa direzione: "+direzione+" perchè nella stanza non è presente l'attrezzo richiesto.");
			return this;
		}
		return super.getStanzaAdiacente(direzione);
	}
}

