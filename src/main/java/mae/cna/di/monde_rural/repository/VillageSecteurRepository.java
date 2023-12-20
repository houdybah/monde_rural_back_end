package mae.cna.di.monde_rural.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import mae.cna.di.monde_rural.domain.Chambre;
import mae.cna.di.monde_rural.domain.RegionNaturelle;
import mae.cna.di.monde_rural.domain.SousPrefecture;
import mae.cna.di.monde_rural.domain.TypeDomaine;
import mae.cna.di.monde_rural.domain.VillageSecteur;

public interface VillageSecteurRepository extends CrudRepository<VillageSecteur, String> {

    @Query("select c from VillageSecteur c")
    Page<VillageSecteur> findAll(Pageable pageable);
    
    @Query("select c from VillageSecteur c where lower(c.code) like concat('%', :key,'%') or lower(c.libelle) like concat('%', :key,'%') or lower(c.description) like concat('%', :key,'%')")
    Page<VillageSecteur> findAllKeyed(Pageable pageable, @Param("key") String key );
    
}
