package mae.cna.di.monde_rural.serviceImpl;

import mae.cna.di.monde_rural.dto.SousPrefectureDto;
import mae.cna.di.monde_rural.exception.PrefectureNotFoundException;
import mae.cna.di.monde_rural.exception.SousPrefectureAlreadyExistException;
import mae.cna.di.monde_rural.exception.SousPrefectureIsFatherException;
import mae.cna.di.monde_rural.exception.SousPrefectureNotFoundException;
import mae.cna.di.monde_rural.map.Mapper;
import mae.cna.di.monde_rural.repository.PrefectureRepository;
import mae.cna.di.monde_rural.repository.SousPrefectureRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import mae.cna.di.monde_rural.domain.Prefecture;
import mae.cna.di.monde_rural.domain.SousPrefecture;
import mae.cna.di.monde_rural.dto.SousPrefectureDto;
import mae.cna.di.monde_rural.dto.PageDataDto;
import mae.cna.di.monde_rural.service.SousPrefectureService;
import mae.cna.di.monde_rural.service.SousPrefectureService;

@Service
public class SousPrefectureServiceImpl implements SousPrefectureService{

	@Autowired
	SousPrefectureRepository sousPrefectureRepository;
	
	@Autowired
	PrefectureRepository prefectureRepository;
	
	@Override
	public SousPrefectureDto save(SousPrefectureDto sousPrefectureDto) {
		
		Prefecture prefecture = prefectureRepository.findById(sousPrefectureDto.getPrefectureUuid()).orElseThrow(() -> new PrefectureNotFoundException(sousPrefectureDto.getPrefectureUuid()));
		SousPrefecture sousPrefecture = new SousPrefecture();
		
		sousPrefecture.setCode(sousPrefectureDto.getCode());
		sousPrefecture.setDescription(sousPrefectureDto.getDescription());
		sousPrefecture.setLibelle(sousPrefectureDto.getLibelle());
		sousPrefecture.setPrefecture(prefecture);
		
		SousPrefecture sousPrefectureSaved = new SousPrefecture();
		
		try {
			sousPrefectureSaved = sousPrefectureRepository.save(sousPrefecture);
		} catch (Exception e) {
			throw new SousPrefectureAlreadyExistException();
		}
		
		return Mapper.toSousPrefectureDto(sousPrefectureSaved);
	}

	@Override
	public SousPrefectureDto update(SousPrefectureDto sousPrefectureDto, String uuid) {
		
		SousPrefecture sousPrefecture = sousPrefectureRepository.findById(uuid).orElseThrow(() -> new SousPrefectureNotFoundException(uuid));
		Prefecture prefecture = prefectureRepository.findById(sousPrefectureDto.getPrefectureUuid()).orElseThrow(() -> new PrefectureNotFoundException(sousPrefectureDto.getPrefectureUuid()));
		
		sousPrefecture.setCode(sousPrefectureDto.getCode());
		sousPrefecture.setDescription(sousPrefectureDto.getDescription());
		sousPrefecture.setLibelle(sousPrefectureDto.getLibelle());
		sousPrefecture.setPrefecture(prefecture);
		
		sousPrefecture = sousPrefectureRepository.save(sousPrefecture);
		
		return Mapper.toSousPrefectureDto(sousPrefecture);
	}

	@Override
	public SousPrefectureDto getOne(String uuid) {
		SousPrefecture sousPrefecture = sousPrefectureRepository.findById(uuid).orElseThrow(() -> new SousPrefectureNotFoundException(uuid));
		return Mapper.toSousPrefectureDto(sousPrefecture);
	}

	@Override
	public PageDataDto<SousPrefectureDto> getAllKeyedAndOrPageed(String key, int page, int size) {
		
		PageDataDto<SousPrefectureDto> pageData = new PageDataDto<SousPrefectureDto>();
		
		Pageable pageable = PageRequest.of(page, size);
		
		Page<SousPrefecture> listSousPrefecture = null;
		
		if(key == null)
		{
			listSousPrefecture = sousPrefectureRepository.findAll(pageable);
		}
		else
		{
			listSousPrefecture = sousPrefectureRepository.findAllKeyed(pageable, key);
		}
		
		final List<SousPrefectureDto> listSousPrefectureDto = new ArrayList<SousPrefectureDto>();
		listSousPrefecture.forEach(sousPrefecture -> {
			listSousPrefectureDto.add(Mapper.toSousPrefectureDto(sousPrefecture));
		});
		
		pageData.setData(listSousPrefectureDto);
		pageData.getPage().setPageNumber(page);
		pageData.getPage().setSize(size);
		pageData.getPage().setTotalElements(listSousPrefecture.getTotalElements());
		pageData.getPage().setTotalPages(listSousPrefecture.getTotalPages());
		
		return pageData;
	}

	@Override
	public void delete(String uuid) {
		
		try {
			sousPrefectureRepository.deleteById(uuid);
		} catch (Exception e) {
			throw new SousPrefectureIsFatherException(uuid);
		}
		
	}

	
	
}
