package mae.cna.di.monde_rural.exception;

public class EspeceIsFatherException extends RuntimeException {

	public EspeceIsFatherException (String uuidChambre)
	{
		super("L'espece est liée avec d'autres enregistrements");
	}
}