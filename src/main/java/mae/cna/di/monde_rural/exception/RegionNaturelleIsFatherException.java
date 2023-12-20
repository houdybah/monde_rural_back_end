package mae.cna.di.monde_rural.exception;

public class RegionNaturelleIsFatherException extends RuntimeException {

	public RegionNaturelleIsFatherException (String uuidChambre)
	{
		super("La Region Naturelle est liée avec d'autres enregistrements");
	}
}