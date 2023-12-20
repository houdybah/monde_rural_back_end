package mae.cna.di.monde_rural.serviceImpl;


import mae.cna.di.monde_rural.dto.PersonnelDto;
import mae.cna.di.monde_rural.exception.ChambreNotFoundException;
import mae.cna.di.monde_rural.exception.EmailInvalidException;
import mae.cna.di.monde_rural.exception.PersonnelAlreadyExistException;
import mae.cna.di.monde_rural.exception.PersonnelIsFatherException;
import mae.cna.di.monde_rural.exception.PersonnelNotFoundException;
import mae.cna.di.monde_rural.exception.UtilisateurAlreadyExistException;
import mae.cna.di.monde_rural.map.Mapper;
import mae.cna.di.monde_rural.repository.ChambreRepository;
import mae.cna.di.monde_rural.repository.PersonnelRepository;
import mae.cna.di.monde_rural.repository.UtilisateurRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import mae.cna.di.monde_rural.domain.Chambre;
import mae.cna.di.monde_rural.domain.Personnel;
import mae.cna.di.monde_rural.domain.Utilisateur;
import mae.cna.di.monde_rural.domain.enumeration.EnumRole;
import mae.cna.di.monde_rural.dto.PageDataDto;
import mae.cna.di.monde_rural.service.PersonnelService;

@Service
public class PersonnelServiceImpl implements PersonnelService{

	@Autowired
	PersonnelRepository personnelRepository;
	
	@Autowired
	UtilisateurRepository utilisateurRepository;
	
	@Autowired
	ChambreRepository chambreRepository;
	
	@Override
	public PersonnelDto save(PersonnelDto personnelDto) {
		
		Personnel personnel = new Personnel();
		
		Personnel personnelSaved = new Personnel();
		
		//email validation
		if(true)
		{
			Optional<Utilisateur> utilisateur = utilisateurRepository.findByEmail(personnelDto.getEmail());
			
			if(utilisateur.isEmpty())
			{
				
				if(!personnelDto.getChambreUuid().isEmpty())
				{
					Chambre chambre = chambreRepository.findById(personnelDto.getChambreUuid()).orElseThrow(() -> new ChambreNotFoundException(personnelDto.getChambreUuid()));
					personnel.setChambre(chambre);
				}
				
				personnel.setAdresse(personnelDto.getAdresse());
				personnel.setContact(personnelDto.getContact());
				personnel.setDateNaissance(personnelDto.getDateNaissance());
				personnel.setEmail(personnelDto.getEmail());
				personnel.setGenre(personnelDto.getGenre());
				personnel.setLieuNaissance(personnelDto.getLieuNaissance());
				personnel.setMatricule(personnelDto.getMatricule());
				personnel.setNom(personnelDto.getNom());
				personnel.setPrenom(personnelDto.getPrenom());
				personnel.setNomMere(personnelDto.getNomMere());
				personnel.setPrenomMere(personnelDto.getPrenomMere());
				personnel.setPrenomPere(personnelDto.getPrenomPere());
				
				try {
					personnelSaved = personnelRepository.save(personnel);
					Utilisateur utilisateurSave = new Utilisateur();
					utilisateurSave.setEmail(personnelSaved.getEmail());
					utilisateurSave.setNonLocked(false);
					utilisateurSave.setPassword("123456");
					utilisateurSave.setEnabled(false);
					List<EnumRole> roles = new ArrayList<EnumRole>();
					roles.add(EnumRole.Membre);
					utilisateurSave.setRoles(roles);
					utilisateurSave.setPersonnel(personnelSaved);
					utilisateurRepository.save(utilisateurSave);
				} catch (Exception e) {
					throw new PersonnelAlreadyExistException();
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
		
		
		
		
		return Mapper.toPersonnelDto(personnelSaved);
	}

	@Override
	public PersonnelDto update(PersonnelDto personnelDto, String uuid) {
		
		Personnel personnel = personnelRepository.findById(uuid).orElseThrow(() -> new PersonnelNotFoundException(uuid));
		
		Personnel personnelSaved = new Personnel();
		
		//email validation
		if(true)
		{
			Optional<Utilisateur> utilisateur = utilisateurRepository.findByEmail(personnelDto.getEmail());
			
			if(utilisateur.isEmpty())
			{
				
				if(!personnelDto.getChambreUuid().isEmpty())
				{
					Chambre chambre = chambreRepository.findById(personnelDto.getChambreUuid()).orElseThrow(() -> new ChambreNotFoundException(personnelDto.getChambreUuid()));
					personnel.setChambre(chambre);
				}
				
				personnel.setAdresse(personnelDto.getAdresse());
				personnel.setContact(personnelDto.getContact());
				personnel.setDateNaissance(personnelDto.getDateNaissance());
				personnel.setEmail(personnelDto.getEmail());
				personnel.setGenre(personnelDto.getGenre());
				personnel.setLieuNaissance(personnelDto.getLieuNaissance());
				personnel.setMatricule(personnelDto.getMatricule());
				personnel.setNom(personnelDto.getNom());
				personnel.setPrenom(personnelDto.getPrenom());
				personnel.setNomMere(personnelDto.getNomMere());
				personnel.setPrenomMere(personnelDto.getPrenomMere());
				personnel.setPrenomPere(personnelDto.getPrenomPere());
				
				try {
					personnelSaved = personnelRepository.save(personnel);
					Utilisateur utilisateurSave = new Utilisateur();
					utilisateurSave.setEmail(personnelSaved.getEmail());
					utilisateurSave.setPersonnel(personnelSaved);
					utilisateurRepository.save(utilisateurSave);
				} catch (Exception e) {
					throw new PersonnelAlreadyExistException();
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
		
		return Mapper.toPersonnelDto(personnelSaved);
	}

	@Override
	public PersonnelDto getOne(String uuid) {
		Personnel personnel = personnelRepository.findById(uuid).orElseThrow(() -> new PersonnelNotFoundException(uuid));
		return Mapper.toPersonnelDto(personnel);
	}

	@Override
	public PageDataDto<PersonnelDto> getAllKeyedAndOrPageed(String key, int page, int size) {
		
		PageDataDto<PersonnelDto> pageData = new PageDataDto<PersonnelDto>();
		
		Pageable pageable = PageRequest.of(page, size);
		
		Page<Personnel> listPersonnel = null;
		
		if(key == null)
		{
			listPersonnel = personnelRepository.findAll(pageable);
		}
		else
		{
			listPersonnel = personnelRepository.findAllKeyed(pageable, key);
		}
		
		final List<PersonnelDto> listPersonnelDto = new ArrayList<PersonnelDto>();
		listPersonnel.forEach(personnel -> {
			listPersonnelDto.add(Mapper.toPersonnelDto(personnel));
		});
		
		pageData.setData(listPersonnelDto);
		pageData.getPage().setPageNumber(page);
		pageData.getPage().setSize(size);
		pageData.getPage().setTotalElements(listPersonnel.getTotalElements());
		pageData.getPage().setTotalPages(listPersonnel.getTotalPages());
		
		return pageData;
	}

	@Override
	public void delete(String uuid) {
		
		try {
			personnelRepository.deleteById(uuid);
		} catch (Exception e) {
			throw new PersonnelIsFatherException(uuid);
		}
		
	}	
	
}
