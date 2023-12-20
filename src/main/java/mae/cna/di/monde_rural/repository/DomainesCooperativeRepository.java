package mae.cna.di.monde_rural.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import mae.cna.di.monde_rural.domain.Chambre;
import mae.cna.di.monde_rural.domain.Domaine;
import mae.cna.di.monde_rural.domain.DomainesCooperative;
import mae.cna.di.monde_rural.domain.Utilisateur;


public interface DomainesCooperativeRepository extends CrudRepository<DomainesCooperative, String> {

    @Query("select d from DomainesCooperative d")
    Page<DomainesCooperative> findAll(Pageable pageable);
    
    @Query("select c from DomainesCooperative c where lower(c.activites) like concat('%', :key,'%')")
    Page<DomainesCooperative> findAllKeyed(Pageable pageable, @Param("key") String key);
    
}
