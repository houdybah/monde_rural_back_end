package mae.cna.di.monde_rural.exception;

public class RaceFamilleIsFatherException extends RuntimeException {

	public RaceFamilleIsFatherException (String uuidChambre)
	{
		super("La Race ou Famille est liée avec d'autres enregistrements");
	}
}