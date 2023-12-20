package mae.cna.di.monde_rural.exception;

public class CooperativeIsFatherException extends RuntimeException {

	public CooperativeIsFatherException (String uuidChambre)
	{
		super("La Cooperative est liée avec d'autres enregistrements");
	}
}