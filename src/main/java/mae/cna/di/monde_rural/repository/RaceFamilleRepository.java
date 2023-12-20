package mae.cna.di.monde_rural.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import mae.cna.di.monde_rural.domain.Chambre;
import mae.cna.di.monde_rural.domain.Espece;
import mae.cna.di.monde_rural.domain.Lieu;
import mae.cna.di.monde_rural.domain.MembreEtProducteur;
import mae.cna.di.monde_rural.domain.Personnel;
import mae.cna.di.monde_rural.domain.Prefecture;
import mae.cna.di.monde_rural.domain.RaceFamille;
import mae.cna.di.monde_rural.domain.RegionAdministrative;
import mae.cna.di.monde_rural.domain.Utilisateur;


public interface RaceFamilleRepository extends CrudRepository<RaceFamille, String> {

    @Query("select c from RegionAdministrative c")
    Page<RaceFamille> findAll(Pageable pageable);
    
    @Query("select c from RaceFamille c where lower(c.code) like concat('%', :key,'%') or lower(c.libelle) like concat('%', :key,'%') or lower(c.description) like concat('%', :key,'%')")
    Page<RaceFamille> findAllKeyed(Pageable pageable, @Param("key") String key );
    
}
