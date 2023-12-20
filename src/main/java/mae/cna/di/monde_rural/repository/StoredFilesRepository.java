package mae.cna.di.monde_rural.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import mae.cna.di.monde_rural.domain.StoredFile;



public interface StoredFilesRepository extends JpaRepository<StoredFile, String> {

	StoredFile findByUuid(String id);
	

	
}
