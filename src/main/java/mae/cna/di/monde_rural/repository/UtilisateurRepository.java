package mae.cna.di.monde_rural.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import mae.cna.di.monde_rural.domain.Utilisateur;


public interface UtilisateurRepository extends CrudRepository<Utilisateur, String> {

//    Page<Utilisateur> findAll(Pageable pageable);
//
//    Optional<Utilisateur> findByEmail(String email);
    
    @Query("select e from Utilisateur e where lower(e.email) like concat('%', :email,'%') ")
    Page<Utilisateur> findAllByEmail(Pageable pageable, @Param("email") String email);
    
    
    @Query("select e from Utilisateur e")
    Page<Utilisateur> findAll(Pageable pageable);

    Optional<Utilisateur> findByEmail(String email);

	Optional<Utilisateur> findByUuid(String uuid);
	
    

}
