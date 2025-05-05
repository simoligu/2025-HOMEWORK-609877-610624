package it.uniroma3.diadia.comandi;


//import it.uniroma3.diadia.giocatore.Giocatore;
import java.util.Scanner;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IOConsole;

/**
 * Questa classe modella un comando.
 * Un comando consiste al piu' di due parole:
 * il nome del comando ed un parametro
 * su cui si applica il comando.
 * (Ad es. alla riga digitata dall'utente "vai nord"
 *  corrisponde un comando di nome "vai" e parametro "nord").
 *
 * @author  docente di POO
 * @version base
 */

//public class Comando {
//
//    private String nome;
//    private String parametro;
//
//    public Comando(String istruzione) {
//		Scanner scannerDiParole = new Scanner(istruzione);
//
//		// prima parola: nome del comando
//		if (scannerDiParole.hasNext())
//			this.nome = scannerDiParole.next(); 
//
//		// seconda parola: eventuale parametro
//		if (scannerDiParole.hasNext())
//			this.parametro = scannerDiParole.next();
//    }
//
//    public String getNome() {
//        return this.nome;
//    }
//
//    public String getParametro() {
//        return this.parametro;
//        //daje roma
//    }
//
//    public boolean sconosciuto() {
//        return (this.nome == null);
//    }
//}

public interface Comando{
	public void esegui(Partita partita);
	public void setParametro(String parametro);
	public void getNome();
	public void getParametro();
}