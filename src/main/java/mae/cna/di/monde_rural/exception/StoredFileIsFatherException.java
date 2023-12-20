package mae.cna.di.monde_rural.exception;

public class StoredFileIsFatherException extends RuntimeException {

	public StoredFileIsFatherException (String uuidChambre)
	{
		super("Le Fichier est liée avec d'autres enregistrements");
	}
}