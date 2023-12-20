package mae.cna.di.monde_rural.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import mae.cna.di.monde_rural.domain.DistrictQuartier;
import mae.cna.di.monde_rural.domain.Utilisateur;


public interface DistrictQuartierRepository extends CrudRepository<DistrictQuartier, String> {

    @Query("select c from DistrictQuartier c")
    Page<DistrictQuartier> findAll(Pageable pageable);
    
    @Query("select c from DistrictQuartier c where lower(c.code) like concat('%', :key,'%')")
    Page<DistrictQuartier> findAllKeyed(Pageable pageable, @Param("key") String key);
    
}
