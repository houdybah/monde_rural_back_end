package mae.cna.di.monde_rural.exception;


public class ChambreNotFoundException extends RuntimeException {

	
	public ChambreNotFoundException (String uuidChambre)
	{
		super("La Chambre est introuvable");
	}
	
}
