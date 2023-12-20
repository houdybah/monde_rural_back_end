package mae.cna.di.monde_rural.exception;

public class TypeDomaineIsFatherException extends RuntimeException {

	public TypeDomaineIsFatherException (String uuidChambre)
	{
		super("Le Type de Domaine est liée avec d'autres enregistrements");
	}
}