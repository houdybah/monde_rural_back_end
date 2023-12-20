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
import mae.cna.di.monde_rural.domain.Utilisateur;


public interface LieuRepository extends CrudRepository<Lieu, String> {

    @Query("select c from Lieu c")
    Page<Lieu> findAll(Pageable pageable);
    
    @Query("select c from Lieu c where c.longitude like concat('%', :key,'%') and c.latitude like concat('%', :key,'%') and lower(c.description) like concat('%', :key,'%')")
    Page<Lieu> findAllKeyed(Pageable pageable, @Param("key") String key);
    
}
