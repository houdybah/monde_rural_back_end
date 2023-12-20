package mae.cna.di.monde_rural.exception;

public class MembreEtProducteurIsFatherException extends RuntimeException {

	public MembreEtProducteurIsFatherException (String uuidChambre)
	{
		super("Le Membre ou Producteur est liée avec d'autres enregistrements");
	}
}