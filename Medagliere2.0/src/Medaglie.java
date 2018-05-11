
public class Medaglie {
	
	public static final int NUMMEDAGLIE = 3;
	public static final String [] NOMIMEDAGLIE = {"ORO", "ARGENTO", "BRONZO"};	
	
	public final static int LARGHPRIMACOL=12;
	 public final static int LARGHCOLMEDAGLIA=9;
		
	 public static String intestazione() // ESEMPIO DI POSSIBILE INTESTAZIONE DEL MEDAGLIERE
		{
		 StringBuffer res = new StringBuffer();
		 res.append(BelleStringhe.incolonna("", LARGHPRIMACOL));
		 for (int i=0; i < NOMIMEDAGLIE.length; i++)
			res.append(BelleStringhe.centrata(NOMIMEDAGLIE[i],LARGHCOLMEDAGLIA));
			
		 return res.toString();
		}

}
