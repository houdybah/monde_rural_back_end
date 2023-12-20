package mae.cna.di.monde_rural.exception;

public class PersonnelIsFatherException extends RuntimeException {

	public PersonnelIsFatherException (String uuidChambre)
	{
		super("La membre du personnel est liée avec d'autres enregistrements");
	}
}