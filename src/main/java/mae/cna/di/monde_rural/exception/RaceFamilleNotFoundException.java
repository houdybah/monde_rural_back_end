package mae.cna.di.monde_rural.exception;


public class RaceFamilleNotFoundException extends RuntimeException {

	
	public RaceFamilleNotFoundException (String uuidChambre)
	{
		super("La Race ou Famille est introuvable");
	}
	
}
