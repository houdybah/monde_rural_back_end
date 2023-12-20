package mae.cna.di.monde_rural.exception;


public class DistrictQuartierNotFoundException extends RuntimeException {

	
	public DistrictQuartierNotFoundException (String uuidChambre)
	{
		super("Le District ou Quartier est introuvable");
	}
	
}
