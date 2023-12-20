package mae.cna.di.monde_rural.exception;

public class VillageSecteurIsFatherException extends RuntimeException {

	public VillageSecteurIsFatherException (String uuidChambre)
	{
		super("Le Village ou Secteur est liée avec d'autres enregistrements");
	}
}