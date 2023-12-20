package mae.cna.di.monde_rural.exception;


public class LieuNotFoundException extends RuntimeException {

	
	public LieuNotFoundException (String uuidChambre)
	{
		super("Le lieu est introuvable");
	}
	
}
