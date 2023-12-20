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
import mae.cna.di.monde_rural.domain.Utilisateur;


public interface MembreEtProducteurRepository extends CrudRepository<MembreEtProducteur, String> {

    @Query("select c from MembreEtProducteur c")
    Page<MembreEtProducteur> findAll(Pageable pageable);
    
    @Query("select c from MembreEtProducteur c where lower(c.matricule) like concat('%', :key,'%') and lower(c.nom) like concat('%', :key,'%') and lower(c.prenom) like concat('%', :key,'%')")
    Page<MembreEtProducteur> findAllKeyed(Pageable pageable, @Param("key") String key);
    
}
