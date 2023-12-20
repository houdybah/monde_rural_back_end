package mae.cna.di.monde_rural.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import mae.cna.di.monde_rural.domain.Utilisateur;
import mae.cna.di.monde_rural.dto.PageDataDto;
import mae.cna.di.monde_rural.dto.UtilisateurDto;
import mae.cna.di.monde_rural.map.Mapper;
import mae.cna.di.monde_rural.repository.UtilisateurRepository;
import mae.cna.di.monde_rural.service.UtilisateurService;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    @Autowired
    UtilisateurRepository utilisateurRepository;
    
   
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Utilisateur save(UtilisateurDto userDto) {

        Utilisateur user = Mapper.toUser(userDto);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user = utilisateurRepository.save(user);
        return user;
    }

	@Override
	public UtilisateurDto newUtilisateur(UtilisateurDto newUtilisateurdto) {
		 Utilisateur utilisateur = new Utilisateur();
		 
		 utilisateur.setEmail(newUtilisateurdto.getEmail()); ///------------
		 utilisateur.setPassword(passwordEncoder.encode(newUtilisateurdto.getPassword()));
		 utilisateur.setEnabled(true);
		 utilisateur.setNonExpired(true);
		 utilisateur.setNonLocked(true);
		 utilisateur.setRoles(newUtilisateurdto.getRoles());
		 Utilisateur savedUtilisateur = utilisateurRepository.save(utilisateur);
		 return Mapper.toUtilisateurDto(savedUtilisateur);
	}

	@Override
	public UtilisateurDto updateUtilisateur(UtilisateurDto newUtilisateurdto, String uuid) {
	
		
		
		Utilisateur utilisateur = utilisateurRepository.findById(uuid).orElseThrow(null);
		 
		 if(newUtilisateurdto.getEmail()!=utilisateur.getEmail()) 
		 {
			 utilisateur.setEmail(newUtilisateurdto.getEmail());
		 }
		 if(newUtilisateurdto.getPassword()!=null && newUtilisateurdto.getPassword()!="" ) {
			 utilisateur.setPassword(passwordEncoder.encode(newUtilisateurdto.getPassword()));
		 }
		 if(newUtilisateurdto.isEnabled()!=utilisateur.isEnabled()) {
			 utilisateur.setEnabled(newUtilisateurdto.isEnabled());
		 }
		 if(newUtilisateurdto.isNonExpired()!=utilisateur.isNonExpired()) {
			 utilisateur.setNonExpired(newUtilisateurdto.isNonExpired());
		 }
		 if(newUtilisateurdto.isNonLocked()!=utilisateur.isNonLocked()) {
			 utilisateur.setNonLocked(newUtilisateurdto.isNonLocked());
		 }
		 if(newUtilisateurdto.getRoles()!=utilisateur.getRoles()) {
			 utilisateur.setRoles(newUtilisateurdto.getRoles());
		 }
		 
		 Utilisateur savedUtilisateur = utilisateurRepository.save(utilisateur);
		 return Mapper.toUtilisateurDto(savedUtilisateur);
	}

	@Override
	public PageDataDto<UtilisateurDto> findAll(String email, int page, int size) {
		PageDataDto<UtilisateurDto> pageData = new PageDataDto<UtilisateurDto>();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

       
        Pageable pageable = PageRequest.of(page, size);

        Page<Utilisateur> listeUtilisateur = null;
        if (email == null) {
            listeUtilisateur = utilisateurRepository.findAll(pageable);
        } else {

            listeUtilisateur = utilisateurRepository.findAllByEmail(pageable, email.toLowerCase());
        }

        final List<UtilisateurDto> listeUtilisateurDto = new ArrayList<UtilisateurDto>();
        listeUtilisateur.forEach(utilisateur -> {
        	listeUtilisateurDto.add(Mapper.toUtilisateurDto(utilisateur));
        });
        pageData.setData(listeUtilisateurDto);
        pageData.getPage().setPageNumber(page);
        pageData.getPage().setSize(size);
        pageData.getPage().setTotalElements(listeUtilisateur.getTotalElements());
        pageData.getPage().setTotalPages(listeUtilisateur.getTotalPages());

        return pageData;
	}

	@Override
	public void deleteUtilisateur(String uuid) {
		utilisateurRepository.findById(uuid).orElseThrow(null);
		try {
			utilisateurRepository.deleteById(uuid);
		} catch (Exception e) {
		}
	}

	@Override
	public UtilisateurDto getUtilisateur(String uuid) {
		Optional<Utilisateur> optionalUtilisateur = utilisateurRepository.findById(uuid);
		Utilisateur utilisateur = optionalUtilisateur.orElseThrow(null);
        return Mapper.toUtilisateurDto(utilisateur);
	}

	
	@Override
	public UtilisateurDto getUtilisateurByEmail(String email) {
		Optional<Utilisateur> optionalUtilisateur = utilisateurRepository.findByEmail(email);
		Utilisateur utilisateur = optionalUtilisateur.orElseThrow(null);
        return Mapper.toUtilisateurDto(utilisateur);
	}

	
}
