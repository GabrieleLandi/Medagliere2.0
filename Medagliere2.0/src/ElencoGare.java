import java.util.*;

import it.unibs.fp.mylib.*;

import java.util.Scanner;


public class ElencoGare {
	

	private Vector<Gara> elementi;
	
	 public ElencoGare ()
		{
		 elementi = new Vector<Gara>();
		}
		
	 public void aggiungiGara (Gara nuova)
	 {
		 elementi.add(nuova);
	 }

	 public String [] getNomi()
		{
		 String [] result = new String[elementi.size()];
		 for (int i = 0; i < result.length; i++)
			{
			  result[i] = elementi.get(i).getNome();
			}
			
		 return result;
		}
		
	 
	 public boolean presente (String nomeGara)
	 {
		 for (Gara disciplina : elementi)
		 {
			 if (nomeGara.equalsIgnoreCase(disciplina.getNome()))
				return true;
		 }
		 return false;
	 }

	 
	 public Gara scegliGara (String domanda)
		{
		 String [] elencoScelte = getNomi(); // PRODURRE UN ARRAY DI String CON I NOMI PRESENTI IN ELENCO;
		
				 
		 MyMenu listaScelte = new MyMenu(domanda, elencoScelte );
		 
		 int scelta = listaScelte.scegli();
			if (scelta == 0)
				return null;
			else
			  return elementi.get(scelta-1);
		
		 // CREARE UN MENU A PARTIRE DALL'ELENCO DEI NOMI
		 // FAR EFFETTUARE LA SCELTA ALL'UTENTE E RESTITUIRE LA GARA CORRISPONDENTE
		 // FARE ATTENZIONE AL POSSIBILE CASO DI MANCATA SCELTA DI UNA GARA
		}
	 
	public boolean isEmpty()
		{
		return (elementi.size() == 0);
		}
	
}
