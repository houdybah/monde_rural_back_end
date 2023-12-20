package mae.cna.di.monde_rural.exception;

public class ChambreIsFatherException extends RuntimeException {

	public ChambreIsFatherException (String uuidChambre)
	{
		super("La Chambre est liée avec d'autres enregistrements");
	}
}