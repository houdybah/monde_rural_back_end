package mae.cna.di.monde_rural.serviceImpl;

import mae.cna.di.monde_rural.dto.TypeDomaineDto;
import mae.cna.di.monde_rural.exception.TypeDomaineAlreadyExistException;
import mae.cna.di.monde_rural.exception.TypeDomaineIsFatherException;
import mae.cna.di.monde_rural.exception.TypeDomaineNotFoundException;
import mae.cna.di.monde_rural.map.Mapper;
import mae.cna.di.monde_rural.repository.TypeDomaineRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import mae.cna.di.monde_rural.domain.TypeDomaine;
import mae.cna.di.monde_rural.dto.TypeDomaineDto;
import mae.cna.di.monde_rural.dto.PageDataDto;
import mae.cna.di.monde_rural.service.TypeDomaineService;
import mae.cna.di.monde_rural.service.TypeDomaineService;

@Service
public class TypeDomaineServiceImpl implements TypeDomaineService{

	@Autowired
	TypeDomaineRepository typeDomaineRepository;
	
	@Override
	public TypeDomaineDto save(TypeDomaineDto typeDomaineDto) {
		
		TypeDomaine typeDomaine = new TypeDomaine();
		
		typeDomaine.setDescription(typeDomaineDto.getDescription());
		typeDomaine.setLibelle(typeDomaineDto.getLibelle());
		
		TypeDomaine typeDomaineSaved = new TypeDomaine();
		
		try {
			typeDomaineSaved = typeDomaineRepository.save(typeDomaine);
		} catch (Exception e) {
			throw new TypeDomaineAlreadyExistException();
		}
		
		return Mapper.toTypeDomaineDto(typeDomaineSaved);
	}

	@Override
	public TypeDomaineDto update(TypeDomaineDto typeDomaineDto, String uuid) {
		TypeDomaine typeDomaine = typeDomaineRepository.findById(uuid).orElseThrow(() -> new TypeDomaineNotFoundException(uuid));
		
		typeDomaine.setDescription(typeDomaineDto.getDescription());
		typeDomaine.setLibelle(typeDomaineDto.getLibelle());
		
		typeDomaine = typeDomaineRepository.save(typeDomaine);
		
		return Mapper.toTypeDomaineDto(typeDomaine);
	}

	@Override
	public TypeDomaineDto getOne(String uuid) {
		TypeDomaine typeDomaine = typeDomaineRepository.findById(uuid).orElseThrow(() -> new TypeDomaineNotFoundException(uuid));
		return Mapper.toTypeDomaineDto(typeDomaine);
	}

	@Override
	public PageDataDto<TypeDomaineDto> getAllKeyedAndOrPageed(String key, int page, int size) {
		
		PageDataDto<TypeDomaineDto> pageData = new PageDataDto<TypeDomaineDto>();
		
		Pageable pageable = PageRequest.of(page, size);
		
		Page<TypeDomaine> listTypeDomaine = null;
		
		if(key == null)
		{
			listTypeDomaine = typeDomaineRepository.findAll(pageable);
		}
		else
		{
			listTypeDomaine = typeDomaineRepository.findAllKeyed(pageable, key);
		}
		
		final List<TypeDomaineDto> listTypeDomaineDto = new ArrayList<TypeDomaineDto>();
		listTypeDomaine.forEach(typeDomaine -> {
			listTypeDomaineDto.add(Mapper.toTypeDomaineDto(typeDomaine));
		});
		
		pageData.setData(listTypeDomaineDto);
		pageData.getPage().setPageNumber(page);
		pageData.getPage().setSize(size);
		pageData.getPage().setTotalElements(listTypeDomaine.getTotalElements());
		pageData.getPage().setTotalPages(listTypeDomaine.getTotalPages());
		
		return pageData;
	}

	@Override
	public void delete(String uuid) {
		
		try {
			typeDomaineRepository.deleteById(uuid);
		} catch (Exception e) {
			throw new TypeDomaineIsFatherException(uuid);
		}
		
	}	
	
}
