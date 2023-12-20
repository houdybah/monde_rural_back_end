package mae.cna.di.monde_rural.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import mae.cna.di.monde_rural.domain.Cooperative;
import mae.cna.di.monde_rural.dto.CooperativeDto;
import mae.cna.di.monde_rural.dto.PageDataDto;
import mae.cna.di.monde_rural.exception.CooperativeAlreadyExistException;
import mae.cna.di.monde_rural.exception.CooperativeIsFatherException;
import mae.cna.di.monde_rural.exception.CooperativeNotFoundException;
import mae.cna.di.monde_rural.map.Mapper;
import mae.cna.di.monde_rural.repository.CooperativeRepository;
import mae.cna.di.monde_rural.service.CooperativeService;

@Service
public class CooperativeServiceImpl implements CooperativeService{

	@Autowired
	CooperativeRepository cooperativeRepository;
	
	@Override
	public CooperativeDto save(CooperativeDto cooperativeDto) {
		
		Cooperative cooperative = new Cooperative();
		
		cooperative.setCode(cooperativeDto.getCode());
		cooperative.setDescription(cooperativeDto.getDescription());
		cooperative.setLibelle(cooperativeDto.getLibelle());
		
		Cooperative cooperativeSaved = new Cooperative();
		
		try {
			cooperativeSaved = cooperativeRepository.save(cooperative);
		} catch (Exception e) {
			throw new CooperativeAlreadyExistException();
		}
		
		return Mapper.toCooperativeDto(cooperativeSaved);
	}

	@Override
	public CooperativeDto update(CooperativeDto cooperativeDto, String uuid) {
		Cooperative cooperative = cooperativeRepository.findById(uuid).orElseThrow(() -> new CooperativeNotFoundException(uuid));
		
		cooperative.setCode(cooperativeDto.getCode());
		cooperative.setDescription(cooperativeDto.getDescription());
		cooperative.setLibelle(cooperativeDto.getLibelle());
		
		cooperative = cooperativeRepository.save(cooperative);
		
		return Mapper.toCooperativeDto(cooperative);
	}

	@Override
	public CooperativeDto getOne(String uuid) {
		Cooperative cooperative = cooperativeRepository.findById(uuid).orElseThrow(() -> new CooperativeNotFoundException(uuid));
		return Mapper.toCooperativeDto(cooperative);
	}

	@Override
	public PageDataDto<CooperativeDto> getAllKeyedAndOrPageed(String key, int page, int size) {
		
		PageDataDto<CooperativeDto> pageData = new PageDataDto<CooperativeDto>();
		
		Pageable pageable = PageRequest.of(page, size);
		
		Page<Cooperative> listCooperative = null;
		
		if(key == null)
		{
			listCooperative = cooperativeRepository.findAll(pageable);
		}
		else
		{
			listCooperative = cooperativeRepository.findAllKeyed(pageable, key);
		}
		
		final List<CooperativeDto> listCooperativeDto = new ArrayList<CooperativeDto>();
		listCooperative.forEach(cooperative -> {
			listCooperativeDto.add(Mapper.toCooperativeDto(cooperative));
		});
		
		pageData.setData(listCooperativeDto);
		pageData.getPage().setPageNumber(page);
		pageData.getPage().setSize(size);
		pageData.getPage().setTotalElements(listCooperative.getTotalElements());
		pageData.getPage().setTotalPages(listCooperative.getTotalPages());
		
		return pageData;
	}

	@Override
	public void delete(String uuid) {
		
		try {
			cooperativeRepository.deleteById(uuid);
		} catch (Exception e) {
			throw new CooperativeIsFatherException(uuid);
		}
		
	}

	
	
}
