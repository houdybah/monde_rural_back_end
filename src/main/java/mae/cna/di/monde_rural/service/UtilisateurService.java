package mae.cna.di.monde_rural.service;

import java.util.List;

import mae.cna.di.monde_rural.domain.Utilisateur;
import mae.cna.di.monde_rural.dto.PageDataDto;
import mae.cna.di.monde_rural.dto.UtilisateurDto;

public interface UtilisateurService {

    Utilisateur save(UtilisateurDto userDto);
    
    UtilisateurDto newUtilisateur(UtilisateurDto newUtilisateurdto);
    UtilisateurDto updateUtilisateur(UtilisateurDto utilisateurDto,String uuid);
	PageDataDto<UtilisateurDto> findAll(String email, int page, int size);
	void deleteUtilisateur(String uuid);
	UtilisateurDto getUtilisateur(String uuid);
	UtilisateurDto  getUtilisateurByEmail(String email);

}
