package mae.cna.di.monde_rural.exception;


public class RegionAdministrativeNotFoundException extends RuntimeException {

	
	public RegionAdministrativeNotFoundException (String uuidChambre)
	{
		super("La Region Administrative est introuvable");
	}
	
}
