import it.unibs.fp.mylib.*;

import java.util.Scanner;


class Gara {
	
	 private String nome;
	 private boolean eseguita;
	 private Nazione [] premiate;
		
	 public Gara (String _nome)
		{
		 nome = _nome;
		 eseguita = false;
		 premiate  = new Nazione[Medaglie.NUMMEDAGLIE];
		}
	 
	 public String getNome()
		{
		 return nome;
		}
		
	 public boolean giaPremiata()
		{
		 return eseguita;
		}
	 
	 public void setEseguita()
		{
		 eseguita=true;
		}
	 public void aggiungiPremiata(Nazione medagliata, int posizione)
	   {
		premiate[posizione] =  medagliata;
	   }
	
	 /* AGGIUNGERE DUE METODI:
	  * 
	  * - UNO PER MEMORIZZARE CHE LA GARA E' GIA' STATA SVOLTA
	  * - UNO PER MEMORIZZARE UNA NAZIONE CHE HA VINTO UNA CERTA MEDAGLIA
	  */ 

}
