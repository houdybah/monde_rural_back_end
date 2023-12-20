package mae.cna.di.monde_rural.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import mae.cna.di.monde_rural.domain.Cooperative;
import mae.cna.di.monde_rural.domain.MembreEtProducteur;
import mae.cna.di.monde_rural.domain.Utilisateur;
import mae.cna.di.monde_rural.domain.enumeration.EnumRole;
import mae.cna.di.monde_rural.dto.MembreEtProducteurDto;
import mae.cna.di.monde_rural.dto.MembreEtProducteurDto;
import mae.cna.di.monde_rural.dto.PageDataDto;
import mae.cna.di.monde_rural.exception.CooperativeNotFoundException;
import mae.cna.di.monde_rural.exception.EmailInvalidException;
import mae.cna.di.monde_rural.exception.MembreEtProducteurAlreadyExistException;
import mae.cna.di.monde_rural.exception.MembreEtProducteurIsFatherException;
import mae.cna.di.monde_rural.exception.MembreEtProducteurNotFoundException;
import mae.cna.di.monde_rural.exception.UtilisateurAlreadyExistException;
import mae.cna.di.monde_rural.map.Mapper;
import mae.cna.di.monde_rural.repository.CooperativeRepository;
import mae.cna.di.monde_rural.repository.MembreEtProducteurRepository;
import mae.cna.di.monde_rural.repository.UtilisateurRepository;
import mae.cna.di.monde_rural.service.MembreEtProducteurService;
import mae.cna.di.monde_rural.service.MembreEtProducteurService;

@Service
public class MembreEtProducteurServiceImpl implements MembreEtProducteurService{

	@Autowired
	MembreEtProducteurRepository membreEtProducteurRepository;
	
	@Autowired
	UtilisateurRepository utilisateurRepository;
	
	@Autowired
	CooperativeRepository cooperativeRepository;
	
	@Override
	public MembreEtProducteurDto save(MembreEtProducteurDto membreEtProducteurDto) {
		
		MembreEtProducteur membreEtProducteur = new MembreEtProducteur();
		
		MembreEtProducteur membreEtProducteurSaved = new MembreEtProducteur();
		
		//email validation
		if(true)
		{
			Optional<Utilisateur> utilisateur = utilisateurRepository.findByEmail(membreEtProducteurDto.getEmail());
			
			if(utilisateur.isEmpty())
			{
				
				if(!membreEtProducteurDto.getCooperativeUuid().isEmpty())
				{
					Cooperative cooperative = cooperativeRepository.findById(membreEtProducteurDto.getCooperativeUuid()).orElseThrow(() -> new CooperativeNotFoundException(membreEtProducteurDto.getCooperativeUuid()));
					membreEtProducteur.setCooperative(cooperative);
				}
				
				membreEtProducteur.setAdresse(membreEtProducteurDto.getAdresse());
				membreEtProducteur.setContact(membreEtProducteurDto.getContact());
				membreEtProducteur.setDateNaissance(membreEtProducteurDto.getDateNaissance());
				membreEtProducteur.setEmail(membreEtProducteurDto.getEmail());
				membreEtProducteur.setGenre(membreEtProducteurDto.getGenre());
				membreEtProducteur.setLieuNaissance(membreEtProducteurDto.getLieuNaissance());
				membreEtProducteur.setMatricule(membreEtProducteurDto.getMatricule());
				membreEtProducteur.setNom(membreEtProducteurDto.getNom());
				membreEtProducteur.setPrenom(membreEtProducteurDto.getPrenom());
				membreEtProducteur.setNomMere(membreEtProducteurDto.getNomMere());
				membreEtProducteur.setPrenomMere(membreEtProducteurDto.getPrenomMere());
				membreEtProducteur.setPrenomPere(membreEtProducteurDto.getPrenomPere());
				membreEtProducteur.setResponsabilite(membreEtProducteurDto.getResponsabilite());
				
				try {
					membreEtProducteurSaved = membreEtProducteurRepository.save(membreEtProducteur);
					Utilisateur utilisateurSave = new Utilisateur();
					utilisateurSave.setEmail(membreEtProducteurSaved.getEmail());
					utilisateurSave.setNonLocked(false);
					utilisateurSave.setPassword("123456");
					utilisateurSave.setEnabled(false);
					List<EnumRole> roles = new ArrayList<EnumRole>();
					roles.add(EnumRole.Membre);
					utilisateurSave.setRoles(roles);
					utilisateurSave.setMembre(membreEtProducteurSaved);
					utilisateurRepository.save(utilisateurSave);
				} catch (Exception e) {
					throw new MembreEtProducteurAlreadyExistException();
				}
			}
			else
			{
				throw new UtilisateurAlreadyExistException();
			}
		}
		else
		{
			throw new EmailInvalidException();
		}
		
		
		
		
		return Mapper.toMembreEtProducteurDto(membreEtProducteurSaved);
	}

	@Override
	public MembreEtProducteurDto update(MembreEtProducteurDto membreEtProducteurDto, String uuid) {
		
		MembreEtProducteur membreEtProducteur = membreEtProducteurRepository.findById(uuid).orElseThrow(() -> new MembreEtProducteurNotFoundException(uuid));
		
		MembreEtProducteur membreEtProducteurSaved = new MembreEtProducteur();
		
		//email validation
		if(true)
		{
			Optional<Utilisateur> utilisateur = utilisateurRepository.findByEmail(membreEtProducteurDto.getEmail());
			
			if(utilisateur.isEmpty())
			{
				
				if(!membreEtProducteurDto.getCooperativeUuid().isEmpty())
				{
					Cooperative cooperative = cooperativeRepository.findById(membreEtProducteurDto.getCooperativeUuid()).orElseThrow(() -> new CooperativeNotFoundException(membreEtProducteurDto.getCooperativeUuid()));
					membreEtProducteur.setCooperative(cooperative);
				}
				
				membreEtProducteur.setAdresse(membreEtProducteurDto.getAdresse());
				membreEtProducteur.setContact(membreEtProducteurDto.getContact());
				membreEtProducteur.setDateNaissance(membreEtProducteurDto.getDateNaissance());
				membreEtProducteur.setEmail(membreEtProducteurDto.getEmail());
				membreEtProducteur.setGenre(membreEtProducteurDto.getGenre());
				membreEtProducteur.setLieuNaissance(membreEtProducteurDto.getLieuNaissance());
				membreEtProducteur.setMatricule(membreEtProducteurDto.getMatricule());
				membreEtProducteur.setNom(membreEtProducteurDto.getNom());
				membreEtProducteur.setPrenom(membreEtProducteurDto.getPrenom());
				membreEtProducteur.setNomMere(membreEtProducteurDto.getNomMere());
				membreEtProducteur.setPrenomMere(membreEtProducteurDto.getPrenomMere());
				membreEtProducteur.setPrenomPere(membreEtProducteurDto.getPrenomPere());
				membreEtProducteur.setResponsabilite(membreEtProducteurDto.getResponsabilite());
				
				try {
					membreEtProducteurSaved = membreEtProducteurRepository.save(membreEtProducteur);
					Utilisateur utilisateurSave = new Utilisateur();
					utilisateurSave.setEmail(membreEtProducteurSaved.getEmail());
					utilisateurSave.setMembre(membreEtProducteurSaved);
					utilisateurRepository.save(utilisateurSave);
				} catch (Exception e) {
					throw new MembreEtProducteurAlreadyExistException();
				}
			}
			else
			{
				throw new UtilisateurAlreadyExistException();
			}
		}
		else
		{
			throw new EmailInvalidException();
		}
		
		return Mapper.toMembreEtProducteurDto(membreEtProducteurSaved);
	}

	@Override
	public MembreEtProducteurDto getOne(String uuid) {
		MembreEtProducteur membreEtProducteur = membreEtProducteurRepository.findById(uuid).orElseThrow(() -> new MembreEtProducteurNotFoundException(uuid));
		return Mapper.toMembreEtProducteurDto(membreEtProducteur);
	}

	@Override
	public PageDataDto<MembreEtProducteurDto> getAllKeyedAndOrPageed(String key, int page, int size) {
		
		PageDataDto<MembreEtProducteurDto> pageData = new PageDataDto<MembreEtProducteurDto>();
		
		Pageable pageable = PageRequest.of(page, size);
		
		Page<MembreEtProducteur> listMembreEtProducteur = null;
		
		if(key == null)
		{
			listMembreEtProducteur = membreEtProducteurRepository.findAll(pageable);
		}
		else
		{
			listMembreEtProducteur = membreEtProducteurRepository.findAllKeyed(pageable, key);
		}
		
		final List<MembreEtProducteurDto> listMembreEtProducteurDto = new ArrayList<MembreEtProducteurDto>();
		listMembreEtProducteur.forEach(membreEtProducteur -> {
			listMembreEtProducteurDto.add(Mapper.toMembreEtProducteurDto(membreEtProducteur));
		});
		
		pageData.setData(listMembreEtProducteurDto);
		pageData.getPage().setPageNumber(page);
		pageData.getPage().setSize(size);
		pageData.getPage().setTotalElements(listMembreEtProducteur.getTotalElements());
		pageData.getPage().setTotalPages(listMembreEtProducteur.getTotalPages());
		
		return pageData;
	}

	@Override
	public void delete(String uuid) {
		
		try {
			membreEtProducteurRepository.deleteById(uuid);
		} catch (Exception e) {
			throw new MembreEtProducteurIsFatherException(uuid);
		}
		
	}

	
	
}
