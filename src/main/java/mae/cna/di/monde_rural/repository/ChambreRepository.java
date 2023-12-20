package mae.cna.di.monde_rural.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import mae.cna.di.monde_rural.domain.Chambre;
import mae.cna.di.monde_rural.domain.Utilisateur;


public interface ChambreRepository extends CrudRepository<Chambre, String> {

    @Query("select c from Chambre c")
    Page<Chambre> findAll(Pageable pageable);
    
    @Query("select c from Chambre c where lower(c.code) like concat('%', :key,'%') or lower(c.libelle) like concat('%', :key,'%') or lower(c.description) like concat('%', :key,'%')")
    Page<Chambre> findAllKeyed(Pageable pageable, @Param("key") String key );
    
}
