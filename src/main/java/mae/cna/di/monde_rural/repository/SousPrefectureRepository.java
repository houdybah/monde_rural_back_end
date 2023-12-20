package mae.cna.di.monde_rural.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import mae.cna.di.monde_rural.domain.Chambre;
import mae.cna.di.monde_rural.domain.RegionNaturelle;
import mae.cna.di.monde_rural.domain.SousPrefecture;

public interface SousPrefectureRepository extends CrudRepository<SousPrefecture, String> {

    @Query("select c from SousPrefecture c")
    Page<SousPrefecture> findAll(Pageable pageable);
    
    @Query("select c from SousPrefecture c where lower(c.code) like concat('%', :key,'%') or lower(c.libelle) like concat('%', :key,'%') or lower(c.description) like concat('%', :key,'%')")
    Page<SousPrefecture> findAllKeyed(Pageable pageable, @Param("key") String key );
    
}
