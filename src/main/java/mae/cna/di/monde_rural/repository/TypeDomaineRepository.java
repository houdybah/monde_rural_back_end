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

public interface TypeDomaineRepository extends CrudRepository<TypeDomaine, String> {

    @Query("select c from TypeDomaine c")
    Page<TypeDomaine> findAll(Pageable pageable);
    
    @Query("select c from TypeDomaine c where lower(c.libelle) like concat('%', :key,'%') or lower(c.description) like concat('%', :key,'%')")
    Page<TypeDomaine> findAllKeyed(Pageable pageable, @Param("key") String key );
    
}
