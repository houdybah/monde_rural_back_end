package mae.cna.di.monde_rural.exception;

public class LieuIsFatherException extends RuntimeException {

	public LieuIsFatherException (String uuidChambre)
	{
		super("Le lieu est liée avec d'autres enregistrements");
	}
}