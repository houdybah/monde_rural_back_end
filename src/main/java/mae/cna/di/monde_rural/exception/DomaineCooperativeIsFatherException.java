package mae.cna.di.monde_rural.exception;

public class DomaineCooperativeIsFatherException extends RuntimeException {

	public DomaineCooperativeIsFatherException (String uuidChambre)
	{
		super("Le Domaine de Cooperative est liée avec d'autres enregistrements");
	}
}