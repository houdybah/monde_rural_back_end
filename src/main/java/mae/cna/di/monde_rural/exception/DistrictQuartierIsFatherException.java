package mae.cna.di.monde_rural.exception;

public class DistrictQuartierIsFatherException extends RuntimeException {

	public DistrictQuartierIsFatherException (String uuidChambre)
	{
		super("Le District ou Quartier est liée avec d'autres enregistrements");
	}
}