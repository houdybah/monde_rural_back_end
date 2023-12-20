package mae.cna.di.monde_rural.serviceImpl;

import mae.cna.di.monde_rural.dto.RegionNaturelleDto;
import mae.cna.di.monde_rural.exception.RegionNaturelleAlreadyExistException;
import mae.cna.di.monde_rural.exception.RegionNaturelleIsFatherException;
import mae.cna.di.monde_rural.exception.RegionNaturelleNotFoundException;
import mae.cna.di.monde_rural.map.Mapper;
import mae.cna.di.monde_rural.repository.RegionNaturelleRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import mae.cna.di.monde_rural.domain.RegionNaturelle;
import mae.cna.di.monde_rural.dto.RegionNaturelleDto;
import mae.cna.di.monde_rural.dto.PageDataDto;
import mae.cna.di.monde_rural.service.RegionNaturelleService;
import mae.cna.di.monde_rural.service.RegionNaturelleService;

@Service
public class RegionNaturelleServiceImpl implements RegionNaturelleService{

	@Autowired
	RegionNaturelleRepository regionNaturelleRepository;
	
	@Override
	public RegionNaturelleDto save(RegionNaturelleDto regionNaturelleDto) {
		
		RegionNaturelle regionNaturelle = new RegionNaturelle();
		
		regionNaturelle.setCode(regionNaturelleDto.getCode());
		regionNaturelle.setDescription(regionNaturelleDto.getDescription());
		regionNaturelle.setLibelle(regionNaturelleDto.getLibelle());
		
		RegionNaturelle regionNaturelleSaved = new RegionNaturelle();
		
		try {
			regionNaturelleSaved = regionNaturelleRepository.save(regionNaturelle);
		} catch (Exception e) {
			throw new RegionNaturelleAlreadyExistException();
		}
		
		return Mapper.toRegionNaturelleDto(regionNaturelleSaved);
	}

	@Override
	public RegionNaturelleDto update(RegionNaturelleDto regionNaturelleDto, String uuid) {
		RegionNaturelle regionNaturelle = regionNaturelleRepository.findById(uuid).orElseThrow(() -> new RegionNaturelleNotFoundException(uuid));
		
		regionNaturelle.setCode(regionNaturelleDto.getCode());
		regionNaturelle.setDescription(regionNaturelleDto.getDescription());
		regionNaturelle.setLibelle(regionNaturelleDto.getLibelle());
		
		regionNaturelle = regionNaturelleRepository.save(regionNaturelle);
		
		return Mapper.toRegionNaturelleDto(regionNaturelle);
	}

	@Override
	public RegionNaturelleDto getOne(String uuid) {
		RegionNaturelle regionNaturelle = regionNaturelleRepository.findById(uuid).orElseThrow(() -> new RegionNaturelleNotFoundException(uuid));
		return Mapper.toRegionNaturelleDto(regionNaturelle);
	}

	@Override
	public PageDataDto<RegionNaturelleDto> getAllKeyedAndOrPageed(String key, int page, int size) {
		
		PageDataDto<RegionNaturelleDto> pageData = new PageDataDto<RegionNaturelleDto>();
		
		Pageable pageable = PageRequest.of(page, size);
		
		Page<RegionNaturelle> listRegionNaturelle = null;
		
		if(key == null)
		{
			listRegionNaturelle = regionNaturelleRepository.findAll(pageable);
		}
		else
		{
			listRegionNaturelle = regionNaturelleRepository.findAllKeyed(pageable, key);
		}
		
		final List<RegionNaturelleDto> listRegionNaturelleDto = new ArrayList<RegionNaturelleDto>();
		listRegionNaturelle.forEach(regionNaturelle -> {
			listRegionNaturelleDto.add(Mapper.toRegionNaturelleDto(regionNaturelle));
		});
		
		pageData.setData(listRegionNaturelleDto);
		pageData.getPage().setPageNumber(page);
		pageData.getPage().setSize(size);
		pageData.getPage().setTotalElements(listRegionNaturelle.getTotalElements());
		pageData.getPage().setTotalPages(listRegionNaturelle.getTotalPages());
		
		return pageData;
	}

	@Override
	public void delete(String uuid) {
		
		try {
			regionNaturelleRepository.deleteById(uuid);
		} catch (Exception e) {
			throw new RegionNaturelleIsFatherException(uuid);
		}
		
	}
	
}
