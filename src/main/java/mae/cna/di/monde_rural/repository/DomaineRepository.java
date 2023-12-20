package mae.cna.di.monde_rural.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import mae.cna.di.monde_rural.domain.Chambre;
import mae.cna.di.monde_rural.domain.DistrictQuartier;
import mae.cna.di.monde_rural.domain.Domaine;
import mae.cna.di.monde_rural.domain.Utilisateur;


public interface DomaineRepository extends CrudRepository<Domaine, String> {

    @Query("select d from Domaine d")
    Page<Domaine> findAll(Pageable pageable);
    
    @Query("select c from Domaine c where lower(c.libelle) like concat('%', :key,'%')")
    Page<Domaine> findAllKeyed(Pageable pageable, @Param("key") String key);
    
}
