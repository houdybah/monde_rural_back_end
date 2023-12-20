package mae.cna.di.monde_rural.exception;


public class MembreEtProducteurNotFoundException extends RuntimeException {

	
	public MembreEtProducteurNotFoundException (String uuidChambre)
	{
		super("Le Membre ou Producteur est introuvable");
	}
	
}
