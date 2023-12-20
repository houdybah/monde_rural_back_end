package mae.cna.di.monde_rural.exception;


public class PersonnelNotFoundException extends RuntimeException {

	
	public PersonnelNotFoundException (String uuidChambre)
	{
		super("Le membre du personnel est introuvable");
	}
	
}
