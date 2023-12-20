package mae.cna.di.monde_rural.exception;


public class VillageSecteurNotFoundException extends RuntimeException {

	
	public VillageSecteurNotFoundException (String uuidChambre)
	{
		super("Le Village ou Secteur est introuvable");
	}
	
}
