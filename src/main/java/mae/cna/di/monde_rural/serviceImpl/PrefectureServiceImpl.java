package mae.cna.di.monde_rural.serviceImpl;

import mae.cna.di.monde_rural.dto.PrefectureDto;
import mae.cna.di.monde_rural.exception.PrefectureAlreadyExistException;
import mae.cna.di.monde_rural.exception.PrefectureIsFatherException;
import mae.cna.di.monde_rural.exception.PrefectureNotFoundException;
import mae.cna.di.monde_rural.exception.RegionAdministrativeNotFoundException;
import mae.cna.di.monde_rural.map.Mapper;
import mae.cna.di.monde_rural.repository.PrefectureRepository;
import mae.cna.di.monde_rural.repository.RegionAdministrativeRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import mae.cna.di.monde_rural.domain.Prefecture;
import mae.cna.di.monde_rural.domain.RegionAdministrative;
import mae.cna.di.monde_rural.dto.PrefectureDto;
import mae.cna.di.monde_rural.dto.PageDataDto;
import mae.cna.di.monde_rural.service.PrefectureService;
import mae.cna.di.monde_rural.service.PrefectureService;

@Service
public class PrefectureServiceImpl implements PrefectureService{

	@Autowired
	PrefectureRepository prefectureRepository;
	
	@Autowired
	RegionAdministrativeRepository regionAdministrativeRepository;
	
	@Override
	public PrefectureDto save(PrefectureDto prefectureDto) {
		
		Prefecture prefecture = new Prefecture();
		RegionAdministrative regionAdministrative = regionAdministrativeRepository.findById(prefectureDto.getRegionAdministrativeUuid()).orElseThrow(() -> new RegionAdministrativeNotFoundException(prefectureDto.getRegionAdministrativeUuid()));
		
		prefecture.setCode(prefectureDto.getCode());
		prefecture.setDescription(prefectureDto.getDescription());
		prefecture.setLibelle(prefectureDto.getLibelle());
		prefecture.setRegionAdministrative(regionAdministrative);
		
		Prefecture prefectureSaved = new Prefecture();
		
		try {
			prefectureSaved = prefectureRepository.save(prefecture);
		} catch (Exception e) {
			throw new PrefectureAlreadyExistException();
		}
		
		return Mapper.toPrefectureDto(prefectureSaved);
	}

	@Override
	public PrefectureDto update(PrefectureDto prefectureDto, String uuid) {
		
		Prefecture prefecture = prefectureRepository.findById(uuid).orElseThrow(() -> new PrefectureNotFoundException(uuid));
		RegionAdministrative regionAdministrative = regionAdministrativeRepository.findById(prefectureDto.getRegionAdministrativeUuid()).orElseThrow(() -> new RegionAdministrativeNotFoundException(prefectureDto.getRegionAdministrativeUuid()));
		
		prefecture.setCode(prefectureDto.getCode());
		prefecture.setDescription(prefectureDto.getDescription());
		prefecture.setLibelle(prefectureDto.getLibelle());
		prefecture.setRegionAdministrative(regionAdministrative);
		
		prefecture = prefectureRepository.save(prefecture);
		
		return Mapper.toPrefectureDto(prefecture);
	}

	@Override
	public PrefectureDto getOne(String uuid) {
		Prefecture prefecture = prefectureRepository.findById(uuid).orElseThrow(() -> new PrefectureNotFoundException(uuid));
		return Mapper.toPrefectureDto(prefecture);
	}

	@Override
	public PageDataDto<PrefectureDto> getAllKeyedAndOrPageed(String key, int page, int size) {
		
		PageDataDto<PrefectureDto> pageData = new PageDataDto<PrefectureDto>();
		
		Pageable pageable = PageRequest.of(page, size);
		
		Page<Prefecture> listPrefecture = null;
		
		if(key == null)
		{
			listPrefecture = prefectureRepository.findAll(pageable);
		}
		else
		{
			listPrefecture = prefectureRepository.findAllKeyed(pageable, key);
		}
		
		final List<PrefectureDto> listPrefectureDto = new ArrayList<PrefectureDto>();
		listPrefecture.forEach(prefecture -> {
			listPrefectureDto.add(Mapper.toPrefectureDto(prefecture));
		});
		
		pageData.setData(listPrefectureDto);
		pageData.getPage().setPageNumber(page);
		pageData.getPage().setSize(size);
		pageData.getPage().setTotalElements(listPrefecture.getTotalElements());
		pageData.getPage().setTotalPages(listPrefecture.getTotalPages());
		
		return pageData;
	}

	@Override
	public void delete(String uuid) {
		
		try {
			prefectureRepository.deleteById(uuid);
		} catch (Exception e) {
			throw new PrefectureIsFatherException(uuid);
		}
		
	}

	
	
}
