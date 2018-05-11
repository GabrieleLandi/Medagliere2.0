import java.util.*;

import it.unibs.fp.mylib.*;

import java.util.Scanner;


public class ElencoNazioni {
	
	private Vector<Nazione> elementi;
	
	 public ElencoNazioni ()
		{
		 elementi = new Vector<Nazione>();
		}

	public void aggiungiNazione (Nazione nuova)
	   {
		 elementi.add(nuova);
	   }
	 
	 public boolean presente (String nomeNazione)
	 {
		 for (Nazione partecipante : elementi)
		 {
			 if (nomeNazione.equalsIgnoreCase(partecipante.getNome()))
				return true;
		 }
		 return false;
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

	  public Nazione scegliNazione (String domanda)
		{
		  String [] elencoScelte = getNomi();
		  // PRODURRE UN ARRAY DI String CON I NOMI PRESENTI IN ELENCO;
		  MyMenu listaScelte = new MyMenu (domanda, elencoScelte);
		  int scelta = listaScelte.scegli();
		  if (scelta == 0)
			  return null;
		  else
			  return elementi.get(scelta-1);
		}// CREARE UN MENU A PARTIRE DALL'ELENCO DEI NOMI
		  // FAR EFFETTUARE LA SCELTA ALL'UTENTE E RESTITUIRE LA NAZIONE CORRISPONDENTE
			// FARE ATTENZIONE AL POSSIBILE CASO DI MANCATA SCELTA DI UNA NAZIONE
		}

	 public void visualizzaMedagliere()
		{
		 
		 
		 System.out.println("QUI CI SARA' LA VISUALIZZAZIONE DEL MEDAGLIERE");
		}

	 public void visualizzaMedagliereOrdinato()
		{
		   System.out.println("QUI CI SARA' LA VISUALIZZAZIONE ORDINATA DEL MEDAGLIERE");
		}
		
		public boolean isEmpty()
		{
			// RESTITUIRE true SE L'ELENCO E' VUOTO, false ALTRIMENTI
		}
	

}
