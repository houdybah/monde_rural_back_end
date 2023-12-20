package mae.cna.di.monde_rural.exception;


public class RegionNaturelleNotFoundException extends RuntimeException {

	
	public RegionNaturelleNotFoundException (String uuidChambre)
	{
		super("La Region Naturelle est introuvable");
	}
	
}
