package mae.cna.di.monde_rural.exception;

public class StoredFileNotFoundException extends RuntimeException {

    public StoredFileNotFoundException(String id) {
        super("Le fichier " + id + "est introuvable");
    }
}
