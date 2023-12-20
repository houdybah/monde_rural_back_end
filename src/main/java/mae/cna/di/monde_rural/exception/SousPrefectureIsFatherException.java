package mae.cna.di.monde_rural.exception;

public class SousPrefectureIsFatherException extends RuntimeException {

	public SousPrefectureIsFatherException (String uuidChambre)
	{
		super("La Sous Prefecture est liée avec d'autres enregistrements");
	}
}