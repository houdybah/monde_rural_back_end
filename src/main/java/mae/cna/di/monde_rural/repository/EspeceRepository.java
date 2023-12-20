package mae.cna.di.monde_rural.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import mae.cna.di.monde_rural.domain.Chambre;
import mae.cna.di.monde_rural.domain.DomainesCooperative;
import mae.cna.di.monde_rural.domain.Espece;
import mae.cna.di.monde_rural.domain.Utilisateur;


public interface EspeceRepository extends CrudRepository<Espece, String> {

    @Query("select c from Espece c")
    Page<Espece> findAll(Pageable pageable);
    
    @Query("select c from Espece c where lower(c.code) like concat('%', :key,'%') and lower(c.libelle) like concat('%', :key,'%')")
    Page<Espece> findAllKeyed(Pageable pageable, @Param("key") String key);
    
}
