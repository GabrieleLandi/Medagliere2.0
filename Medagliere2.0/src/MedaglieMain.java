import java.util.Scanner;

import it.unibs.fp.mylib.*;

public class MedaglieMain
{
  private final static String MSG_BENVENUTO = "BENVENUTO NELLA GESTIONE DEL MEDAGLIERE OLIMPICO";
  private final static String MSG_CHIUSURA = "GRAZIE PER AVERE USATO IL PROGRAMMA MEDAGLIERE - ARRIVEDERCI";
  
  private final static String NOME_NULLO = "-";
  
  private final static String MSG_NAZIONI= "Introdurre il nome della nuova nazione partecipante(" + NOME_NULLO + " per tornare al menu principale)";
  private final static String MSG_NAZIONE_PRESENTE= "Attenzione: nazione gia' presente in elenco - Ripetere l'inserimento";
  
  private final static String MSG_GARE= "Introdurre il nome della nuova gara in programma(" + NOME_NULLO + " per tornare al menu principale)";
  private final static String MSG_GARA_PRESENTE= "Attenzione: gara gia' presente in elenco - Ripetere l'inserimento";
  private final static String MSG_GARA_SVOLTA="Attenzione: la premiazione della gara selezionata e' stata gia' svolta";
  
  private final static String MSG_SCELTA_GARA="Selezionare la gara della quale effettuare la premiazione";
  private final static String MSG_SCELTA_VINCENTE="Selezionare nazione vincente della medaglia:";
  
  private final static String MSG_DATI_MANCANTI="Attenzione: devono essere gia' inserite almeno una nazione e una gara";
  private final static String MSG_PREMIAZ_ANNULLATA="Attenzione: premiazione annullata";
  
  private final static String MSG_SCELTA_OBBLIGATORIA="Attenzione: la scelta di una nazione e' obbligatoria";
  
  private final static String [] MAIN_MENU_ITEMS = {"Introduzione nuove nazioni","Introduzione nuove gare","Introduzione risultato gara", "Visualizzazione medagliere","Visualizzazione medagliere ordinato"};
  private final static String MAIN_QUESTION = "Scegli l'operazione da eseguire";
	
	 
 private static void benvenuto()
    {
	 System.out.println(MSG_BENVENUTO);
	 System.out.println();
	}
 
 private static void saluti()
    {
	 System.out.println(MSG_CHIUSURA);
	 System.out.println();
	}
 
	
  private static ElencoNazioni partecipanti = new ElencoNazioni();
	
  private static ElencoGare programma =  new ElencoGare();
	
	
	
 
 	
  public static void main (String [] args)
	 {
		benvenuto();
	  
		
		MyMenu principale = new MyMenu(MAIN_QUESTION, MAIN_MENU_ITEMS);
				
		boolean fine = false;
		
		do 
		{
		 int voceSelezionata = principale.scegli();
			
	     switch ( voceSelezionata ) 
	      {
			   case 1:
				   nuovaNazione();
				 break;
			   case 2:
				   nuovaGara();
				 break;
			   case 3:
				   premiazione();
				 break;
			   case 4:
				   partecipanti.visualizzaMedagliere();
				 break;
			   case 5:
				   partecipanti.visualizzaMedagliereOrdinato();
				 break;
			   case 0:
				   fine = true;
				 break;
			   default:
				   System.out.println("Operazione non riconosciuta.");
				 break;
			}//switch
			
		} while ( !fine );
		 
		saluti();
			
	 } //main
  
  private static void nuovaNazione()
  {
	boolean finito = false;
	do
	{
 	 String nomeNazione = InputDati.leggiStringaNonVuota(MSG_NAZIONI);
	 if (nomeNazione.equals(NOME_NULLO))
	   finito = true;
	 else
       if (partecipanti.presente(nomeNazione))
         System.out.println(MSG_NAZIONE_PRESENTE);
       else
    	 partecipanti.aggiungiNazione(new Nazione(nomeNazione));  
	}while (!finito);
  }
  
  private static void nuovaGara()
  {
	boolean finito = false;
	do
	{
 	 String nomeGara = InputDati.leggiStringaNonVuota(MSG_GARE);
	 if (nomeGara.equals(NOME_NULLO))
	   finito = true;
	 else
       if (programma.presente(nomeGara))
         System.out.println(MSG_GARA_PRESENTE);
       else
    	   programma.aggiungiGara(new Gara(nomeGara));  
	}while (!finito);
  }
  

	private static void premiazione ()
	 {
		if (partecipanti.isEmpty() || programma.isEmpty())
		 System.out.println(MSG_DATI_MANCANTI);
		else
		{
		 Gara prescelta = programma.scegliGara(MSG_SCELTA_GARA);
		 if (prescelta == null) 
		 {
		   System.out.println(MSG_PREMIAZ_ANNULLATA);
		   return;
		 }
		 if (prescelta.giaPremiata())
		  System.out.println(MSG_GARA_SVOLTA);
		 else
		  {
		   prescelta.setEseguita();
		
		   for (int i=0; i < Medaglie.NUMMEDAGLIE; i ++)
		   {
			  Nazione medagliata;
			  do
			   {
				 medagliata = partecipanti.scegliNazione (MSG_SCELTA_VINCENTE + Medaglie.NOMIMEDAGLIE[i]);
				 if (medagliata == null)
					 System.out.println(MSG_SCELTA_OBBLIGATORIA); 
			   } 
			  while (medagliata == null);
			  medagliata.aggiungiMedaglia(i);
			  prescelta.aggiungiPremiata(medagliata,i);
		    }
		   } // else interno
		  } // else esterno
	   }
  
  
} // class


