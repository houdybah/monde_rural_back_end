package mae.cna.di.monde_rural.serviceImpl;

import java.util.ArrayList;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import mae.cna.di.monde_rural.domain.Utilisateur;
import mae.cna.di.monde_rural.map.Mapper;
import mae.cna.di.monde_rural.repository.UtilisateurRepository;


@Service
public class JwtUserDetailsService implements UserDetailsService {
    Logger logger = LoggerFactory.getLogger(JwtUserDetailsService.class);

    @Autowired
    UtilisateurRepository utilisateurRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Utilisateur> findByEmail = utilisateurRepository.findByEmail(username);
        if (findByEmail.isPresent()) {
            logger.info("user found {}", findByEmail.get().getPassword());
            return (Mapper.toUserDetails(findByEmail.get()));
        }

//        Optional<PersonnelDto> findByMatricule = agentRepository.findByMatricule(username);
//        if (findByMatricule.isPresent()) {
//            return Mapper.toUserDetails(findByMatricule.get().getUser());
//        }

        //        if ("javainuse".equals(username)) {
        //            ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        //            authorities.add(new SimpleGrantedAuthority("USER"));
        //            authorities.add(new SimpleGrantedAuthority("ADMIN"));
        //            return new User("javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6", authorities);
        //        } else {
        throw new UsernameNotFoundException("l'utilisateur avec ce username " + username+" n'existe pas");
        //        }
    }
}
