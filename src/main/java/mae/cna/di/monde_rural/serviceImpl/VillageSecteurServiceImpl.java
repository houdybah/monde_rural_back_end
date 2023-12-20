package mae.cna.di.monde_rural.serviceImpl;

import mae.cna.di.monde_rural.dto.VillageSecteurDto;
import mae.cna.di.monde_rural.exception.DistrictQuartierNotFoundException;
import mae.cna.di.monde_rural.exception.VillageSecteurAlreadyExistException;
import mae.cna.di.monde_rural.exception.VillageSecteurIsFatherException;
import mae.cna.di.monde_rural.exception.VillageSecteurNotFoundException;
import mae.cna.di.monde_rural.map.Mapper;
import mae.cna.di.monde_rural.repository.DistrictQuartierRepository;
import mae.cna.di.monde_rural.repository.VillageSecteurRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import mae.cna.di.monde_rural.domain.DistrictQuartier;
import mae.cna.di.monde_rural.domain.VillageSecteur;
import mae.cna.di.monde_rural.dto.PageDataDto;
import mae.cna.di.monde_rural.service.VillageSecteurService;

@Service
public class VillageSecteurServiceImpl implements VillageSecteurService{

	@Autowired
	VillageSecteurRepository villageSecteurRepository;
	
	@Autowired
	DistrictQuartierRepository districtQuartierRepository;
	
	@Override
	public VillageSecteurDto save(VillageSecteurDto villageSecteurDto) {
		
		DistrictQuartier districtQuartier = districtQuartierRepository.findById(villageSecteurDto.getDistrictQuartierUuid()).orElseThrow(() -> new DistrictQuartierNotFoundException(villageSecteurDto.getDistrictQuartierUuid()));
		VillageSecteur villageSecteur = new VillageSecteur();
		
		villageSecteur.setCode(villageSecteurDto.getCode());
		villageSecteur.setDescription(villageSecteurDto.getDescription());
		villageSecteur.setLibelle(villageSecteurDto.getLibelle());
		villageSecteur.setDistrictQuartier(districtQuartier);
		
		VillageSecteur villageSecteurSaved = new VillageSecteur();
		
		try {
			villageSecteurSaved = villageSecteurRepository.save(villageSecteur);
		} catch (Exception e) {
			throw new VillageSecteurAlreadyExistException();
		}
		
		return Mapper.toVillageSecteurDto(villageSecteurSaved);
	}

	@Override
	public VillageSecteurDto update(VillageSecteurDto villageSecteurDto, String uuid) {
		
		VillageSecteur villageSecteur = villageSecteurRepository.findById(uuid).orElseThrow(() -> new VillageSecteurNotFoundException(uuid));
		DistrictQuartier districtQuartier = districtQuartierRepository.findById(villageSecteurDto.getDistrictQuartierUuid()).orElseThrow(() -> new DistrictQuartierNotFoundException(villageSecteurDto.getDistrictQuartierUuid()));
		
		villageSecteur.setCode(villageSecteurDto.getCode());
		villageSecteur.setDescription(villageSecteurDto.getDescription());
		villageSecteur.setLibelle(villageSecteurDto.getLibelle());
		villageSecteur.setDistrictQuartier(districtQuartier);
		
		villageSecteur = villageSecteurRepository.save(villageSecteur);
		
		return Mapper.toVillageSecteurDto(villageSecteur);
	}

	@Override
	public VillageSecteurDto getOne(String uuid) {
		VillageSecteur villageSecteur = villageSecteurRepository.findById(uuid).orElseThrow(() -> new VillageSecteurNotFoundException(uuid));
		return Mapper.toVillageSecteurDto(villageSecteur);
	}

	@Override
	public PageDataDto<VillageSecteurDto> getAllKeyedAndOrPageed(String key, int page, int size) {
		
		PageDataDto<VillageSecteurDto> pageData = new PageDataDto<VillageSecteurDto>();
		
		Pageable pageable = PageRequest.of(page, size);
		
		Page<VillageSecteur> listVillageSecteur = null;
		
		if(key == null)
		{
			listVillageSecteur = villageSecteurRepository.findAll(pageable);
		}
		else
		{
			listVillageSecteur = villageSecteurRepository.findAllKeyed(pageable, key);
		}
		
		final List<VillageSecteurDto> listVillageSecteurDto = new ArrayList<VillageSecteurDto>();
		listVillageSecteur.forEach(villageSecteur -> {
			listVillageSecteurDto.add(Mapper.toVillageSecteurDto(villageSecteur));
		});
		
		pageData.setData(listVillageSecteurDto);
		pageData.getPage().setPageNumber(page);
		pageData.getPage().setSize(size);
		pageData.getPage().setTotalElements(listVillageSecteur.getTotalElements());
		pageData.getPage().setTotalPages(listVillageSecteur.getTotalPages());
		
		return pageData;
	}

	@Override
	public void delete(String uuid) {
		
		try {
			villageSecteurRepository.deleteById(uuid);
		} catch (Exception e) {
			throw new VillageSecteurIsFatherException(uuid);
		}
		
	}

	
	
}
