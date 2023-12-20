package mae.cna.di.monde_rural.serviceImpl;

import mae.cna.di.monde_rural.dto.RegionAdministrativeDto;
import mae.cna.di.monde_rural.exception.RegionAdministrativeAlreadyExistException;
import mae.cna.di.monde_rural.exception.RegionAdministrativeIsFatherException;
import mae.cna.di.monde_rural.exception.RegionAdministrativeNotFoundException;
import mae.cna.di.monde_rural.exception.RegionNaturelleNotFoundException;
import mae.cna.di.monde_rural.map.Mapper;
import mae.cna.di.monde_rural.repository.RegionAdministrativeRepository;
import mae.cna.di.monde_rural.repository.RegionNaturelleRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import mae.cna.di.monde_rural.domain.RegionAdministrative;
import mae.cna.di.monde_rural.domain.RegionNaturelle;
import mae.cna.di.monde_rural.dto.RegionAdministrativeDto;
import mae.cna.di.monde_rural.dto.PageDataDto;
import mae.cna.di.monde_rural.service.RegionAdministrativeService;
import mae.cna.di.monde_rural.service.RegionAdministrativeService;

@Service
public class RegionAdministrativeServiceImpl implements RegionAdministrativeService{

	@Autowired
	RegionAdministrativeRepository regionAdministrativeRepository;
	
	@Autowired
	RegionNaturelleRepository regionNaturelleRepository;
	
	@Override
	public RegionAdministrativeDto save(RegionAdministrativeDto regionAdministrativeDto) {
		
		RegionAdministrative regionAdministrative = new RegionAdministrative();
		RegionNaturelle regionNaturelle = regionNaturelleRepository.findById(regionAdministrativeDto.getRegionNaturelleUuid()).orElseThrow(() -> new RegionNaturelleNotFoundException(regionAdministrativeDto.getRegionNaturelleUuid()));
		
		regionAdministrative.setCode(regionAdministrativeDto.getCode());
		regionAdministrative.setDescription(regionAdministrativeDto.getDescription());
		regionAdministrative.setLibelle(regionAdministrativeDto.getLibelle());
		regionAdministrative.setRegionNaturelle(regionNaturelle);
		
		RegionAdministrative regionAdministrativeSaved = new RegionAdministrative();
		
		try {
			regionAdministrativeSaved = regionAdministrativeRepository.save(regionAdministrative);
		} catch (Exception e) {
			throw new RegionAdministrativeAlreadyExistException();
		}
		
		return Mapper.toRegionAdministrativeDto(regionAdministrativeSaved);
	}

	@Override
	public RegionAdministrativeDto update(RegionAdministrativeDto regionAdministrativeDto, String uuid) {
		
		RegionAdministrative regionAdministrative = regionAdministrativeRepository.findById(uuid).orElseThrow(() -> new RegionAdministrativeNotFoundException(uuid));
		RegionNaturelle regionNaturelle = regionNaturelleRepository.findById(regionAdministrativeDto.getRegionNaturelleUuid()).orElseThrow(() -> new RegionNaturelleNotFoundException(regionAdministrativeDto.getRegionNaturelleUuid()));
		
		regionAdministrative.setCode(regionAdministrativeDto.getCode());
		regionAdministrative.setDescription(regionAdministrativeDto.getDescription());
		regionAdministrative.setLibelle(regionAdministrativeDto.getLibelle());
		regionAdministrative.setRegionNaturelle(regionNaturelle);
		
		
		regionAdministrative = regionAdministrativeRepository.save(regionAdministrative);
		
		return Mapper.toRegionAdministrativeDto(regionAdministrative);
	}

	@Override
	public RegionAdministrativeDto getOne(String uuid) {
		RegionAdministrative regionAdministrative = regionAdministrativeRepository.findById(uuid).orElseThrow(() -> new RegionAdministrativeNotFoundException(uuid));
		return Mapper.toRegionAdministrativeDto(regionAdministrative);
	}

	@Override
	public PageDataDto<RegionAdministrativeDto> getAllKeyedAndOrPageed(String key, int page, int size) {
		
		PageDataDto<RegionAdministrativeDto> pageData = new PageDataDto<RegionAdministrativeDto>();
		
		Pageable pageable = PageRequest.of(page, size);
		
		Page<RegionAdministrative> listRegionAdministrative = null;
		
		if(key == null)
		{
			listRegionAdministrative = regionAdministrativeRepository.findAll(pageable);
		}
		else
		{
			listRegionAdministrative = regionAdministrativeRepository.findAllKeyed(pageable, key);
		}
		
		final List<RegionAdministrativeDto> listRegionAdministrativeDto = new ArrayList<RegionAdministrativeDto>();
		listRegionAdministrative.forEach(regionAdministrative -> {
			listRegionAdministrativeDto.add(Mapper.toRegionAdministrativeDto(regionAdministrative));
		});
		
		pageData.setData(listRegionAdministrativeDto);
		pageData.getPage().setPageNumber(page);
		pageData.getPage().setSize(size);
		pageData.getPage().setTotalElements(listRegionAdministrative.getTotalElements());
		pageData.getPage().setTotalPages(listRegionAdministrative.getTotalPages());
		
		return pageData;
	}

	@Override
	public void delete(String uuid) {
		
		try {
			regionAdministrativeRepository.deleteById(uuid);
		} catch (Exception e) {
			throw new RegionAdministrativeIsFatherException(uuid);
		}
		
	}

	
	
}
