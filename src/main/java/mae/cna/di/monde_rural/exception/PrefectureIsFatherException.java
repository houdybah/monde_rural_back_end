package mae.cna.di.monde_rural.exception;

public class PrefectureIsFatherException extends RuntimeException {

	public PrefectureIsFatherException (String uuidChambre)
	{
		super("La Prefecture est liée avec d'autres enregistrements");
	}
}