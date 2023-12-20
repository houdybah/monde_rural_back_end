package mae.cna.di.monde_rural.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import mae.cna.di.monde_rural.domain.Domaine;
import mae.cna.di.monde_rural.dto.DomaineDto;
import mae.cna.di.monde_rural.dto.DomaineDto;
import mae.cna.di.monde_rural.dto.PageDataDto;
import mae.cna.di.monde_rural.exception.DomaineAlreadyExistException;
import mae.cna.di.monde_rural.exception.DomaineIsFatherException;
import mae.cna.di.monde_rural.exception.DomaineNotFoundException;
import mae.cna.di.monde_rural.map.Mapper;
import mae.cna.di.monde_rural.repository.DomaineRepository;
import mae.cna.di.monde_rural.service.DomaineService;
import mae.cna.di.monde_rural.service.DomaineService;

@Service
public class DomaineServiceImpl implements DomaineService{

	@Autowired
	DomaineRepository domaineRepository;
	
	@Override
	public DomaineDto save(DomaineDto domaineDto) {
		
		Domaine domaine = new Domaine();
		
		domaine.setDescription(domaineDto.getDescription());
		domaine.setLibelle(domaineDto.getLibelle());
		
		Domaine domaineSaved = new Domaine();
		
		try {
			domaineSaved = domaineRepository.save(domaine);
		} catch (Exception e) {
			throw new DomaineAlreadyExistException();
		}
		
		return Mapper.toDomaineDto(domaineSaved);
	}

	@Override
	public DomaineDto update(DomaineDto domaineDto, String uuid) {
		Domaine domaine = domaineRepository.findById(uuid).orElseThrow(() -> new DomaineNotFoundException(uuid));
		
		domaine.setDescription(domaineDto.getDescription());
		domaine.setLibelle(domaineDto.getLibelle());
		
		domaine = domaineRepository.save(domaine);
		
		return Mapper.toDomaineDto(domaine);
	}

	@Override
	public DomaineDto getOne(String uuid) {
		Domaine domaine = domaineRepository.findById(uuid).orElseThrow(() -> new DomaineNotFoundException(uuid));
		return Mapper.toDomaineDto(domaine);
	}

	@Override
	public PageDataDto<DomaineDto> getAllKeyedAndOrPageed(String key, int page, int size) {
		
		PageDataDto<DomaineDto> pageData = new PageDataDto<DomaineDto>();
		
		Pageable pageable = PageRequest.of(page, size);
		
		Page<Domaine> listDomaine = null;
		
		if(key == null)
		{
			listDomaine = domaineRepository.findAll(pageable);
		}
		else
		{
			listDomaine = domaineRepository.findAllKeyed(pageable, key);
		}
		
		final List<DomaineDto> listDomaineDto = new ArrayList<DomaineDto>();
		listDomaine.forEach(domaine -> {
			listDomaineDto.add(Mapper.toDomaineDto(domaine));
		});
		
		pageData.setData(listDomaineDto);
		pageData.getPage().setPageNumber(page);
		pageData.getPage().setSize(size);
		pageData.getPage().setTotalElements(listDomaine.getTotalElements());
		pageData.getPage().setTotalPages(listDomaine.getTotalPages());
		
		return pageData;
	}

	@Override
	public void delete(String uuid) {
		
		try {
			domaineRepository.deleteById(uuid);
		} catch (Exception e) {
			throw new DomaineIsFatherException(uuid);
		}
		
	}	
	
}
