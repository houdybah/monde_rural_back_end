package mae.cna.di.monde_rural.exception;

public class RegionAdministrativeIsFatherException extends RuntimeException {

	public RegionAdministrativeIsFatherException (String uuidChambre)
	{
		super("La Region Administrative est liée avec d'autres enregistrements");
	}
}