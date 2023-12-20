package mae.cna.di.monde_rural.exception;


public class TypeDomaineNotFoundException extends RuntimeException {

	
	public TypeDomaineNotFoundException (String uuidChambre)
	{
		super("Le Type de Domaine est introuvable");
	}
	
}
