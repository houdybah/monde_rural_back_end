package mae.cna.di.monde_rural.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import mae.cna.di.monde_rural.domain.DistrictQuartier;
import mae.cna.di.monde_rural.dto.DistrictQuartierDto;
import mae.cna.di.monde_rural.dto.CooperativeDto;
import mae.cna.di.monde_rural.dto.DistrictQuartierDto;
import mae.cna.di.monde_rural.dto.PageDataDto;
import mae.cna.di.monde_rural.exception.DistrictQuartierAlreadyExistException;
import mae.cna.di.monde_rural.exception.DistrictQuartierIsFatherException;
import mae.cna.di.monde_rural.exception.DistrictQuartierNotFoundException;
import mae.cna.di.monde_rural.map.Mapper;
import mae.cna.di.monde_rural.repository.DistrictQuartierRepository;
import mae.cna.di.monde_rural.service.DistrictQuartierService;
import mae.cna.di.monde_rural.service.CooperativeService;
import mae.cna.di.monde_rural.service.DistrictQuartierService;

@Service
public class DistrictQuartierServiceImpl implements DistrictQuartierService{

	@Autowired
	DistrictQuartierRepository districtQuartierRepository;
	
	@Override
	public DistrictQuartierDto save(DistrictQuartierDto districtQuartierDto) {
		
		DistrictQuartier districtQuartier = new DistrictQuartier();
		
		districtQuartier.setCode(districtQuartierDto.getCode());
		districtQuartier.setDescription(districtQuartierDto.getDescription());
		districtQuartier.setLibelle(districtQuartierDto.getLibelle());
		
		DistrictQuartier districtQuartierSaved = new DistrictQuartier();
		
		try {
			districtQuartierSaved = districtQuartierRepository.save(districtQuartier);
		} catch (Exception e) {
			throw new DistrictQuartierAlreadyExistException();
		}
		
		return Mapper.toDistrictQuartierDto(districtQuartierSaved);
	}

	@Override
	public DistrictQuartierDto update(DistrictQuartierDto districtQuartierDto, String uuid) {
		DistrictQuartier districtQuartier = districtQuartierRepository.findById(uuid).orElseThrow(() -> new DistrictQuartierNotFoundException(uuid));
		
		districtQuartier.setCode(districtQuartierDto.getCode());
		districtQuartier.setDescription(districtQuartierDto.getDescription());
		districtQuartier.setLibelle(districtQuartierDto.getLibelle());
		
		districtQuartier = districtQuartierRepository.save(districtQuartier);
		
		return Mapper.toDistrictQuartierDto(districtQuartier);
	}

	@Override
	public DistrictQuartierDto getOne(String uuid) {
		DistrictQuartier districtQuartier = districtQuartierRepository.findById(uuid).orElseThrow(() -> new DistrictQuartierNotFoundException(uuid));
		return Mapper.toDistrictQuartierDto(districtQuartier);
	}

	@Override
	public PageDataDto<DistrictQuartierDto> getAllKeyedAndOrPageed(String key, int page, int size) {
		
		PageDataDto<DistrictQuartierDto> pageData = new PageDataDto<DistrictQuartierDto>();
		
		Pageable pageable = PageRequest.of(page, size);
		
		Page<DistrictQuartier> listDistrictQuartier = null;
		
		if(key == null)
		{
			listDistrictQuartier = districtQuartierRepository.findAll(pageable);
		}
		else
		{
			listDistrictQuartier = districtQuartierRepository.findAllKeyed(pageable, key);
		}
		
		final List<DistrictQuartierDto> listDistrictQuartierDto = new ArrayList<DistrictQuartierDto>();
		listDistrictQuartier.forEach(districtQuartier -> {
			listDistrictQuartierDto.add(Mapper.toDistrictQuartierDto(districtQuartier));
		});
		
		pageData.setData(listDistrictQuartierDto);
		pageData.getPage().setPageNumber(page);
		pageData.getPage().setSize(size);
		pageData.getPage().setTotalElements(listDistrictQuartier.getTotalElements());
		pageData.getPage().setTotalPages(listDistrictQuartier.getTotalPages());
		
		return pageData;
	}

	@Override
	public void delete(String uuid) {
		
		try {
			districtQuartierRepository.deleteById(uuid);
		} catch (Exception e) {
			throw new DistrictQuartierIsFatherException(uuid);
		}
		
	}

	
	
}
